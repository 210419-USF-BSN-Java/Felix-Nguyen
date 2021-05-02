package project0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserPostgres implements UserDao<User> {
	
	public String checkLogin(String username, String pw) {
		
		String usertype = "";
		String[] keys = {"user_id"};		
		String sql = "select * from users where user_loginname =  ? and user_loginpass = ?";
			
		try(Connection con = UtilConnection.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, pw);
				
			ResultSet rs = ps.executeQuery();
			//System.out.println(rs);
			
			
			if(rs.next()) {
				usertype = rs.getString("user_type");
		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return user;
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
	
	 
	
}
