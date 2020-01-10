package concessionaria.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactory {
	
	public static Connection getConnection() throws ClassNotFoundException, 
									SQLException, NamingException {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection connection =
//     	       DriverManager.getConnection("jdbc:mysql://localhost/corso?" +
//     	                                   "user=master&password=manager&serverTimezone=Europe/Rome");
//		//System.out.println(connection.getClass().getName());
		     
		
		/* Cerco radice dell'albero (context)
		 * Faccio lookup nel sottoalbero delle risorse java
		 * Ottengo la risorsa DataSourse e chiedo connessione
		 */
		
		InitialContext context = new InitialContext();
		DataSource datasource = (DataSource) context.lookup("java:/comp/env/jdbc/Mysql");
		Connection connection = datasource.getConnection();
		connection.setAutoCommit(false);
		return connection;
	}

}

