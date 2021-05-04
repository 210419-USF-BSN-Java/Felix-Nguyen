package project0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilConnection {

	private static Connection connection;
	
		/*public static Connection getConnectionFromEnv() throws SQLException
		{
			
			String url = "jdbc:postgresql://localhost:5432/postgres";
			String username = "postgres";
			String password ="nguyenfelix79";
			
			if(connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection(url, username, password);
			}
							
			return connection;
			//remember to add dependency into the pom 
			//put
		}*/
		
		public static Connection getConnectionFromEnv() throws SQLException
		{

			String url = System.getenv("DB_URL");
			String username = System.getenv("DB_USER");
			String password = System.getenv("DB_PASS");

			if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password);
			}
			
			return connection;
		}
		
}
