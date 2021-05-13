package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> getAllEmp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users updateInfo(Users u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users viewInfo(Users u) {
		// TODO Auto-generated method stub
		return null;
	}

}
