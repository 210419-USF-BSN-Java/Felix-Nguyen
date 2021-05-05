package project0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

public class ShopPostgres{

	private static Logger l = Logger.getLogger(ShopPostgres.class.getName());
	
	public Shop add(Shop t) {
		
		Shop shop = null;
		String sql = "insert into shop (item_id, item_name, item_status, item_owned, item_offer) values (?,?,?,?,?) returning item_id;";

		String[] keys = {"item_id"};
		
		try(Connection con = UtilConnection.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,t.getItemID());
			ps.setString(2, t.getItem());
			ps.setString(3, t.getItemStatus());
			ps.setBoolean(4, t.getItemOwned());
			ps.setInt(5, t.getItemOffer());
			
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				shop = t;
				shop.setItemID(rs.getInt(1));
		
			}
			
		} catch (SQLException e) {
			logE("Error sending/receiving data to the database");
		}
		return shop;
	}

	
	public Integer delete(int id, String name) {
		String sql = "DELETE FROM shop WHERE item_ID = ? and item_name = ?";
		int result = 0;
		try (Connection c = UtilConnection.getConnectionFromEnv()){
			
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			
			result = ps.executeUpdate();
		}
			catch (SQLException e) {
				logE("Error sending/receiving data to the database");
			}
		return result;
	}
	
	public List<String> viewItems(){
		List<String> items = new ArrayList<>();
		String sql = "SELECT * FROM shop";
		try (Connection c = UtilConnection.getConnectionFromEnv()){
					
					PreparedStatement ps = c.prepareStatement(sql);

					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						items.add("Item ID: " + rs.getInt("item_id") +" " + rs.getString("item_name"));
					}
				}
					catch (SQLException e) {
						logE("Error sending/receiving data to the database");
					}				
		return items;
		
	}
	
	public Integer makeOffer(int offer, int user_id, int item_id, String itemName) {
		String sql = "Update shop set item_offer = ?, user_id = ? where item_id = ? and item_name = ?";
		int rs = 0;
		try (Connection c = UtilConnection.getConnectionFromEnv()){
			
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, offer);
			ps.setInt(2, user_id);
			ps.setInt(3, item_id);
			ps.setString(4, itemName);

			rs = ps.executeUpdate();

		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}
	
	public Integer updateOwnedItems(int user_id, int item_id) {
		String sql = "Update shop set item_owned = ?, user_id = ? where item_id = ?";
		
		int rs = 0;
		try (Connection c = UtilConnection.getConnectionFromEnv()){
			
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setBoolean(1, true);
			ps.setInt(2, user_id);
			ps.setInt(3, item_id);
		
			rs = ps.executeUpdate();

		}
		catch (SQLException e) {
			logE("Error sending/receiving data to the database");
		}

		return rs;
	}
	
	
	public List<String> viewOwnedItems(int id) {
		String sql = "Select item_name from shop where user_id = ? and item_owned = ?";
		List<String> items = new ArrayList<>();
		try (Connection c = UtilConnection.getConnectionFromEnv()){
			
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setBoolean(2, true);
		
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				items.add(rs.getString("item_name"));
			}
			
			Iterator it = items.iterator();
			while(it.hasNext()) {
				Object o = it.next();
				System.out.println(o);
			}

		}
		catch (SQLException e) {
			logE("Error sending/receiving data to the database");
		}
		
		return items;
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
	


