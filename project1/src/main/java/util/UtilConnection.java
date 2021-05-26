package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilConnection {

	private static Connection connection;	

	public static Connection getConnectionFromEnv() throws SQLException
	{		

		try {
			 Class.forName("org.postgresql.Driver");			 
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
//		For public debugging:		
		String RDS_HOSTNAME = "db1.cwx0nihectol.us-west-1.rds.amazonaws.com";
		String RDS_USERNAME = "postgres";
	    String RDS_PASS = "nguyenfelix79";
//		String RDS_HOSTNAME = System.getenv("RDS_HOSTNAME");
//		String RDS_USERNAME = System.getenv("RDS_USERNAME");
//		String RDS_PASS = System.getenv("RDS_PASS");

		
		String jdbcURL = "jdbc:postgresql://" + RDS_HOSTNAME + ":" + 5432 + "/" + RDS_USERNAME +"?user=" + RDS_USERNAME + "&password=" + RDS_PASS;
		
		try {
			if(connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection(jdbcURL);
				}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
		
		
		
	}
	

	
	
	
}
