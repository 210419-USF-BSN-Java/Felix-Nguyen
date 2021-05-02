package project0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OffersPostgres {

	public Integer addOffer(int offer_id, int item_id, String item_name, int offer, int user_id, String item_status) {
		
		String sql = "insert into offers(offer_id, item_id, item_name, item_offer, user_id, item_status) values (?,?,?,?,?,?)";
		//String sql = "Update shop set item_offer = ?, user_id = ? where item_id = ? and item_name = ?";
		int rs = 0;
		try (Connection c = UtilConnection.getConnectionFromEnv()){
			
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, offer_id);
			ps.setInt(2, item_id);
			ps.setString(3, item_name);
			ps.setInt(4, offer);
			ps.setInt(5, user_id);
			ps.setString(6,  item_status);

			rs = ps.executeUpdate();

		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	
	}
	
	public void acceptOffer(int id) {
		
		//String sql = "update offers set item_status = ? where item_id = ? and item_name = ?";
		String sql = "Update offers set item_status = ? where offer_id = ?";
		try (Connection c = UtilConnection.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1,"accepted" );
			ps.setInt(2, id);
			//ps.setString(3, name);
			
			int rs = ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void rejectOffer(int id) {
		
		//String sql = "Update offers set item_status = ? where item_id = ? and item_name = ?";
		  String sql = "Update offers set item_status = ? where offer_id = ?";
		try (Connection c = UtilConnection.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1,"rejected" );
			ps.setInt(2,id);
			//ps.setInt(2, id);
			//ps.setString(3, name);
			
			int rs = ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public List<Offers> viewOffers() {
		
		String sql = "select * from offers";
		ArrayList<Offers> offerList = new ArrayList<>();
		
		try (Connection c = UtilConnection.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
					
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int offer_id = rs.getInt("offer_id");
				int item_id = rs.getInt("item_id");
				String item_name = rs.getString("item_name");
				int item_offer = rs.getInt("item_offer");
				int user_id = rs.getInt("user_id");
				String item_status = rs.getString("item_status");
				
				offerList.add(new Offers(offer_id, item_id, item_name, item_offer,user_id, item_status));	
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return offerList;
	}
	
	public void updateOffers(int item_id) {
		
		String sql = "delete from offers where item_id = ? and item_status = ?";
		
		try (Connection c = UtilConnection.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, item_id);
			ps.setString(2, "pending");
					
			//ResultSet rs = ps.executeQuery();
			int result = ps.executeUpdate();
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}













