package project0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SystemManagerPostgres {

	
	
	public void update() {
		String sql = "select * from offers where item_status = ?";
		ArrayList<Integer> acceptedItems = new ArrayList<Integer>();
	
		try (Connection c = UtilConnection.getConnectionFromEnv()){
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, "accepted");


		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			acceptedItems.add(rs.getInt("item_id"));
		}

		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(acceptedItems);
		
		for(Integer i: acceptedItems) {

			try (Connection c = UtilConnection.getConnectionFromEnv()){
				sql = "update shop set item_owned = ? where item_id = ?";
				PreparedStatement ps = c.prepareStatement(sql);
				ps.setBoolean(1, true);
				ps.setInt(2, i.valueOf(i));
			}
			
			catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
			
				
				
			
	}
}
	
	
	
