package project0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class UserPostgres implements UserDao<User> {
	
	private static Scanner sc = new Scanner(System.in);
	private static Logger l = Logger.getLogger(UserPostgres.class.getName());
	
	public String checkLogin(String username, String pw) {
	
		String usertype = "";
		String[] keys = {"user_id"};		
		String sql = "select * from users where user_loginname =  ? and user_loginpass = ?";
			
		try(Connection con = UtilConnection.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, pw);
				
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				usertype = rs.getString("user_type");
		
			}
			
		} catch (SQLException e) {
			logE("Error sending/receiving data to the database");
		}
		
		return usertype;
	}

	@Override
	public User add(User t) {
		
			User user = null;
			String sql = "insert into users (user_id, user_type, user_loginname, user_loginpass) values (?,?,?,?) returning user_id;";

			String[] keys = {"user_id"};
			
			try(Connection con = UtilConnection.getConnectionFromEnv()){
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1,t.getUserID());
				ps.setString(2, t.getUsertype());
				ps.setString(3, t.getUsername());
				ps.setString(4, t.getPassword());
				
				ResultSet rs = ps.executeQuery();

				if(rs.next()) {
					user = t;
					user.setUserID(rs.getInt(1));
			
				}
				
			} catch (SQLException e) {
				logE("Error sending/receiving data to the database");
			}
			return user;
	}
	
	public int getUserID()
	{
		int id = 0;
		String sql = "Select user_id from users where user_loginname = ? and user_loginpass = ?";

		String[] keys = {"user_id"};
		
		try(Connection con = UtilConnection.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("Enter username");
			String username = sc.next() + sc.nextLine();
			System.out.println("Enter password");
			String password = sc.next() + sc.nextLine();
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				id = rs.getInt("user_id");
		
			}
			
		} catch (SQLException e) {
			logE("Error sending/receiving data to the database");
		}
		return id;
	}
	
	public String checkExistingUser(String username) {
		String sql = "Select user_loginname from users where user_loginname = ?";
		String row = "";
		//String[] keys = {"user_id"};
		
		try(Connection con = UtilConnection.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				 row = rs.getString("user_loginname");		
			}
			
		} catch (SQLException e) {
			logE("Error sending/receiving data to the database");
		}
		return row;
	}

	@Override
	public User delete(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer update(User t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public void logI(String s) { // outputs string 's' with new line
		l.info(s);
		l.info("                 ");
	}
	
	public void logE(String s) { // outputs string 's' with new line
		l.error(s);
		l.error("                 ");
	}
	 
	
}
