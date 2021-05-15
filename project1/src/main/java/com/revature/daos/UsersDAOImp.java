package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Users;

import util.UtilConnection;

public class UsersDAOImp implements UsersDAO{

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
			//logE("Error sending/receiving data to the database");
			e.printStackTrace();
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
			//logE("Error sending/receiving data to the database");
			e.getStackTrace();
		}

		return u;
	}

	@Override
	public List<Users> getAllEmp() {
		String sql = "select * from ers_users where user_role = ?";
		List<Users> uList = new ArrayList<>();
		try (Connection c = UtilConnection.getConnectionFromEnv()){
			
			PreparedStatement ps = c.prepareStatement(sql);	
			ps.setString(1, "employee");
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
			//logE("Error sending/receiving data to the database");
			e.getStackTrace();
		}

		return uList;
	}

	@Override
	public Integer updateInfo(Users u) {
		String sql = "update ers_users set user_firstname = ?, user_lastname = ?, user_password = ?, user_email = ? where user_id = ? ";
		int result = 0;
		try (Connection c = UtilConnection.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getLastName());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getEmail());
			ps.setInt(5, u.getId());
			
			result = ps.executeUpdate();
			
		}
		catch (SQLException e) {
			//logE("Error sending/receiving data to the database");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Users viewInfo(Users u) {
		String sql = "select * from ers_users where user_role = ?";
		Users user = new Users();
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
			//logE("Error sending/receiving data to the database");
			e.getStackTrace();
		}

		return user;
	}

	// no need already got getAllEmployees no need to get managers
	@Override
	public List<Users> getUsersByRole(String s) {
		// TODO Auto-generated method stub
		return null;
	}

}
