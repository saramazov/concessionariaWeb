package concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import javax.naming.NamingException;

import concessionaria.db.ConcessionariaException;
import concessionaria.db.ConnectionFactory;
import concessionaria.model.Menu;
import concessionaria.model.MenuItem;

public class MenuDAO implements Dao<Menu> {
	
	private static final String FindforQuery = 
			"select *"+
			" from menu where ruolo=? and "
			+ "livello=? "
			+ "order by ordine";

	public Menu menuSelect(String ruolo,Integer livello,String richiamo) throws ConcessionariaException {
		 
		 Connection connection = null;
		 PreparedStatement pst = null ;
		 ResultSet rs = null;
		 Menu menu = new Menu();
		 MenuItem item = null;
		 
		 try {
			 connection = ConnectionFactory.getConnection();
			 pst = connection.prepareStatement(FindforQuery, 
	            ResultSet.TYPE_SCROLL_SENSITIVE,
	            ResultSet.CONCUR_READ_ONLY);
			 pst.setString(1, ruolo);
			 pst.setInt(2, livello);
			 //pst.setString(3, richiamo);
			 rs = pst.executeQuery();
			 while(rs.next()) {
				 item = creaItem(rs);
				 menu.add(item);
			 }
			 //if(menu.menuSize()==0) throw new BlankException();
	
		 }catch (ClassNotFoundException | SQLException | NamingException e) {
			 e.printStackTrace();
			 throw new ConcessionariaException("ruolo not found");
		 }finally {
			 try {pst.close(); } catch (SQLException e) {}
			 try {connection.close();} catch (SQLException e) {}
		 }
		 return menu;
	}

	private MenuItem creaItem(ResultSet rs) throws SQLException {
		return new MenuItem(rs.getLong(1),
			    rs.getString(2),rs.getString(3),
			    rs.getString(4),rs.getInt(5),
			    rs.getString(6),rs.getInt(7));
	}

	@Override
	public Menu create(Menu t) throws ConcessionariaException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Collection<Menu> findAll() throws ConcessionariaException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Menu findById(Long id) throws ConcessionariaException {
		throw new UnsupportedOperationException();
	}

	@Override
	public int remove(Long id) throws ConcessionariaException {
		throw new UnsupportedOperationException();
	}

	@Override
	public int remove(Menu t) throws ConcessionariaException {
		throw new UnsupportedOperationException();
	}

	@Override
	public int update(Menu t) throws ConcessionariaException {
		throw new UnsupportedOperationException();
	}
	
}
