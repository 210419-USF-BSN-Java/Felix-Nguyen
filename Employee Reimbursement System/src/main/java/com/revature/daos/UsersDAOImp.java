package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Users;

import util.UtilConnection;

public class UsersDAOImp implements UsersDAO{
	private static Logger l = Logger.getLogger(UsersDAOImp.class.getName());
	@Override
	public int add(Users u) {
		String sql = "insert into ers_users (user_id, user_firstname, user_lastname, user_email, user_role) values (?,?,?,?,?)";
		int result = 0;
		try (Connection c = UtilConnection.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1,u.getId());	
			ps.setString(2, u.getFirstName());
			ps.setString(3, u.getLastName());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getRole());
			
			result = ps.executeUpdate();
			
		}
		catch (SQLException e) {
			logE("Error sending/receiving data to the database");
			//e.printStackTrace();
		}
		return result;
	}

	@Override
	public Users getUserById(int id) {
		String sql = "select * from ers_users where user_id = ?";
		Users u = new Users();
		try (Connection c = UtilConnection.getConnectionFromEnv()){
			
			PreparedStatement ps = c.prepareStatement(sql);	
			ps.setInt(1, id);
			

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u = new Users(rs.getInt("user_id"),
								rs.getString("user_username"),
								rs.getString("user_password"),
								rs.getString("user_firstname"),
								rs.getString("user_lastname"),
								rs.getString("user_email"),
								rs.getString("user_role")
						);
			}

		}
		catch (SQLException e) {
			logE("Error sending/receiving data to the database");
			//e.getStackTrace();
		}

		return u;
	}

	@Override
	public List<Users> getAllEmp() {
		String sql = "select * from ers_users";
		List<Users> uList = new ArrayList<>();
		try (Connection c = UtilConnection.getConnectionFromEnv()){
		
			PreparedStatement ps = c.prepareStatement(sql);	

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				uList.add(new Users(rs.getInt("user_id"),
								rs.getString("user_username"),
								rs.getString("user_password"),
								rs.getString("user_firstname"),
								rs.getString("user_lastname"),
								rs.getString("user_email"),
								rs.getString("user_role")
						));
			}
		}
		catch (SQLException e) {
			logE("Error sending/receiving data to the database");
		}

		return uList;
	}

	@Override
	public Integer updateInfo(Users u) {
		String sql = "update ers_users set user_firstname = ?, user_lastname = ?, user_username = ?, user_password = ?, user_email = ? where user_id = ? ";
		int result = 0;
		try (Connection c = UtilConnection.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getLastName());
			ps.setString(3,  u.getUsername());
			ps.setString(4, u.getPassword());
			ps.setString(5, u.getEmail());
			ps.setInt(6, u.getId());
			
			result = ps.executeUpdate();
			
		}
		catch (SQLException e) {
			logE("Error sending/receiving data to the database");
			
		}
		return result;
	}

	@Override
	public Users viewInfo(Users u) {
		String sql = "select * from ers_users where user_role = ?";
		Users user = null;
		try (Connection c = UtilConnection.getConnectionFromEnv()){
			
			PreparedStatement ps = c.prepareStatement(sql);	
			ps.setString(1, "employee");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			user = new Users(rs.getInt("user_id"),
								rs.getString("user_username"),
								rs.getString("user_password"),
								rs.getString("user_firstname"),
								rs.getString("user_lastname"),
								rs.getString("user_email"),
								rs.getString("user_role")
						);
			}

		}
		catch (SQLException e) {
			logE("Error sending/receiving data to the database");
		
		}

		return user;
	}

	@Override
	public Users checkLogin(String username, String password) {
		String sql = "select * from ers_users where user_username = ? and user_password = ?";
		Users user = new Users();
		try (Connection c = UtilConnection.getConnectionFromEnv()){
			
			PreparedStatement ps = c.prepareStatement(sql);	
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			user = new Users(rs.getInt("user_id"),
								rs.getString("user_username"),
								rs.getString("user_password"),
								rs.getString("user_firstname"),
								rs.getString("user_lastname"),
								rs.getString("user_email"),
								rs.getString("user_role")
						);
			}

		}
		catch (SQLException e) {
			logE("Error sending/receiving data to the database");
		
		}

		return user;
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
