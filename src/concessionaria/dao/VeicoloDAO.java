package concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import concessionaria.model.Auto;
import concessionaria.model.Dipendente;
import concessionaria.model.Moto;
import concessionaria.model.Veicolo;
import concessionaria.db.ConcessionariaException;
import concessionaria.db.ConnectionFactory;

public class VeicoloDAO implements Dao<Veicolo> {
	
	private static final String insertQuery =
			"insert into veicoli (tipo, targa, produttore, prezzo, "
			+ "modello, alimentazione, colore, altezzasedile, numeroporte)"
			+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String FindAllQuery = 
			"select id, tipo, targa, produttore, prezzo,"
			+ " modello, alimentazione, colore, "
			+ " altezzasedile, numeroporte from veicoli";
	private static final String FindByIDQuery = 
			"select id, tipo, targa, produttore, prezzo,"
			+ " modello, alimentazione, colore, "
			+ " altezzasedile, numeroporte from veicoli "
			+ "where id=?";
	private static final String DeleteByIDQuery = 
			"delete from veicoli where id = ?";
	
	private static final String UpdateQuery = 
			"update veicoli set targa=?, produttore=?, prezzo=?,"
			+"modello=?, alimentazione=?, colore=?, "
			+ "altezzasedile=?, numeroporte=? where id=?";

	@Override
	public Veicolo create(Veicolo v) throws ConcessionariaException {
		
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet generatedKeys = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			pst = connection.prepareStatement(insertQuery,
					Statement.RETURN_GENERATED_KEYS);
			String tipo = v.getTipo();
			pst.setString(1, tipo);
			pst.setString(2, v.getTarga());
			pst.setString(3, v.getProduttore());
			pst.setString(4, v.getPrezzo());
			pst.setString(5, v.getModello());
			pst.setString(6, v.getAlimentazione());
			pst.setString(7, v.getColore());
			if(tipo.equals("M")) {pst.setString(8, ((Moto) v).getAltezzaSedile());}
			else {pst.setString(8, null);}
			if(tipo.equals("A")) {pst.setString(9, ((Auto) v).getNumeroPorte());}
			else {pst.setString(9, null);}
			
			int affectedRows = pst.executeUpdate();
			if(affectedRows != 1){
				throw new SQLException("Creazione veicolo fallita");
			}
			generatedKeys = pst.getGeneratedKeys();
			connection.commit();
			if(generatedKeys.next()) {
				v.setId(generatedKeys.getLong(1));
			}
			else throw new SQLException("Fail: ID non ottenuta");
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new ConcessionariaException();
		} finally {
			try {generatedKeys.close();} catch (Exception e) {}
			try {pst.close();} catch (Exception e) {}
			try {connection.close();} catch (Exception e) {}
		}
		return v;

	}

	@Override
	public Collection<Veicolo> findAll() throws ConcessionariaException {
		Connection connection = null;
		PreparedStatement pst = null ;
		ResultSet rs = null;
		Collection<Veicolo> veicoli = new ArrayList<>();
		try {
			connection = ConnectionFactory.getConnection();
			pst = connection.prepareStatement(FindAllQuery, 
			ResultSet.TYPE_SCROLL_SENSITIVE,
            ResultSet.CONCUR_READ_ONLY);
			rs = pst.executeQuery();
			while(rs.next()) {
				veicoli.add(creaVeicolo(rs));
			}
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			e.printStackTrace();
			throw new ConcessionariaException();
		}finally {
			try {pst.close(); } catch (SQLException e) {}
			try {connection.close();} catch (SQLException e) {}
		}
		return veicoli;
	}

	@Override
	public Veicolo findById(Long id) throws ConcessionariaException {
		 Connection connection = null;
		 PreparedStatement pst = null ;
		 ResultSet rs = null;
		 Veicolo veicolo = null;
		 try {
			 connection = ConnectionFactory.getConnection();
			 pst = connection.prepareStatement(FindByIDQuery, 
	            ResultSet.TYPE_SCROLL_SENSITIVE,
	            ResultSet.CONCUR_READ_ONLY);
			 pst.setLong(1, id);
			 rs = pst.executeQuery();
			 while(rs.next()) {
				 veicolo = creaVeicolo(rs);
			 }
		 }catch (ClassNotFoundException | SQLException | NamingException e) {
			 e.printStackTrace();
			 throw new ConcessionariaException("ID not found");
		 }finally {
			 try {pst.close(); } catch (SQLException e) {}
			 try {connection.close();} catch (SQLException e) {}
		 }
		 return veicolo;
		
	}

	@Override
	public int remove(Long id) throws ConcessionariaException {
		 Connection connection = null;
		 PreparedStatement pst = null ;
		 ResultSet rs = null;
		 int affectedRows = 0;
		 try {
			 connection = ConnectionFactory.getConnection();
			 pst = connection.prepareStatement(DeleteByIDQuery, 
	            ResultSet.TYPE_SCROLL_SENSITIVE,
	            ResultSet.CONCUR_READ_ONLY);
			 pst.setLong(1, id);
			 affectedRows = pst.executeUpdate();
			 connection.commit();
			 if(affectedRows != 1){
					throw new SQLException("Cancellazione veicolo fallita");
			 }
			 
		 }catch (ClassNotFoundException | SQLException | NamingException e) {
			 e.printStackTrace();
			 try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			 throw new ConcessionariaException("ID not found");
		 }finally {
			 try {pst.close(); } catch (SQLException e) {}
			 try {connection.close();} catch (SQLException e) {}
		 }
		 return affectedRows;

	}

	@Override
	public int remove(Veicolo v) throws ConcessionariaException {
		return this.remove(v.getId());
	}

	@Override
	public int update(Veicolo v) throws ConcessionariaException {
		Connection connection = null;
		PreparedStatement pst = null;
		int affectedRows = 0;
		
		try {
			connection = ConnectionFactory.getConnection();
			pst = connection.prepareStatement(UpdateQuery,
					Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, v.getTarga());
			pst.setString(2, v.getProduttore());
			pst.setDouble(3, v.getPrezzo());
			pst.setString(4, v.getModello());
			pst.setString(5, v.getAlimentazione());
			pst.setString(6, v.getColore());
			if(v.getTipo().equals("A")) {
				pst.setInteger(7, null);
				pst.setInteger(8, ((Auto) v).getNumeroPorte());
			}
			else if(v.getTipo().equals("M")) {
				pst.setInteger(7, ((Mot) v).getAltezzaSedile());
				pst.setInteger(8, null);
			}
			pst.setLong(9, v.getId());
			affectedRows = pst.executeUpdate();
			connection.commit();
			if(affectedRows != 1){
				throw new SQLException();
			}
			
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new ConcessionariaException("Update veicolo fallito");
		} finally {
			try {pst.close();} catch (Exception e) {}
			try {connection.close();} catch (Exception e) {}
		}
		return affectedRows;
	}

	private Veicolo creaVeicolo(ResultSet rs) 
			throws SQLException {
		
		if(rs.getString(2).equals("A")) {
		  return new Auto(rs.getLong(1),rs.getString(3), 
			rs.getString(4),rs.getDouble(5),  
		    rs.getString(6),rs.getString(7),
		    rs.getString(8), rs.getInteger(10));
		 }
		
		else if(rs.getString(2).equals("M")) {
			return new Moto(rs.getLong(1),rs.getString(3), 
					rs.getString(4),rs.getDouble(5),  
				    rs.getString(6),rs.getString(7),
				    rs.getString(8), rs.getInteger(9));
		}
		
		else return null;
	}
	
}