package dev.sol.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static Connection connection;
	
	
	public static Connection getConnection() throws SQLException {
		String url = System.getenv("DB_URL"); // best not to hard code in your db credentials ! 
		String username = System.getenv("DB_USERNAME");
		String password = System.getenv("DB_PASSWORD");
		
		
		try { 
	        Class.forName("oracle.jdbc.driver.OracleDriver"); 
	    } catch (ClassNotFoundException e) { 
	        System.out.println("Could not load the driver"); 
	    } 
		
		
		
		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password);
		}
		return connection;
	}

}
