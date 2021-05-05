package project0;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;



public class OffersPostgres {

	private static Scanner sc = new Scanner(System.in);
	private static Logger l = Logger.getLogger(OffersPostgres.class.getName());
	
	
	public String getItemName(int id) {
		String sql = "select item_name from shop where item_id = ?";
	
		String s = null;
		try (Connection c = UtilConnection.getConnectionFromEnv()){
			
			PreparedStatement ps = c.prepareStatement(sql);		
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				s = rs.getString("item_name");
			}

		}
		catch (SQLException e) {
			logE("Error sending/receiving data to the database");
		}
		if(s.equals(null))
		{
			logE("You cannot make an offer with an item_ID that does not exist");
		}
		return s;
	
	}
	
	public Integer addOffer(int offer_id, int item_id, String item_name, double offer, int user_id, String item_status) {
		
		String sql = "insert into offers(offer_id, item_id, item_name, item_offer, user_id, item_status) values (?,?,?,?,?,?)";
		
		int rs = 0;
		try (Connection c = UtilConnection.getConnectionFromEnv()){
			
			PreparedStatement ps = c.prepareStatement(sql);
		
			ps.setInt(1, offer_id);
			ps.setInt(2, item_id);
			ps.setString(3, item_name);
			ps.setDouble(4, offer);
			ps.setInt(5, user_id);
			ps.setString(6,  item_status);

			rs = ps.executeUpdate();

		}
		catch (SQLException e) {
			logE("Error sending/receiving data to the database");
		}

		return rs;
	
	}
	
	public Integer acceptOffer(int id) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  //yyyy/MM/dd HH:mm:ss
		LocalDateTime now = LocalDateTime.now();  
		Customer cus = new Customer();
		int rs = -1;
		String sql = "Update offers set item_status = ?, time = ? where offer_id = ? ";
		try (Connection c = UtilConnection.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1,"accepted" );		
			ps.setString(2, dtf.format(now));
			ps.setInt(3, id);
			
			rs = ps.executeUpdate();
		}
		catch (SQLException e) {
			logE("Error sending/receiving data to the database");
		}
		return rs;
	}

	public Integer rejectOffer(int id) {
		int rs = -1;
		String sql = "Update offers set item_status = ? where offer_id = ?";
		try (Connection c = UtilConnection.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1,"rejected" );
			ps.setInt(2,id);
			
			rs = ps.executeUpdate();
		}
		catch (SQLException e) {
			logE("Error sending/receiving data to the database");
		}
		return rs;
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
				double item_offer = rs.getDouble("item_offer");
				int user_id = rs.getInt("user_id");
				String item_status = rs.getString("item_status");
				String time = rs.getString("time");
				
				offerList.add(new Offers(offer_id, item_id, item_name, item_offer,user_id, item_status, time));	
			}
		}
		catch (SQLException e) {
			logE("Error sending/receiving data to the database");
		}

		return offerList;
	}
	
	public Integer updateOffers(int item_id) {
		
		String sql = "delete from offers where item_id = ? and item_status = ?";
		int result = -1;
		try (Connection c = UtilConnection.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, item_id);
			ps.setString(2, "pending");
					
			result = ps.executeUpdate();
			
			
		}
		catch (SQLException e) {
			logE("Error sending/receiving data to the database");
		}
		
		return result;
	}
	
	public List<Offers> viewPayments() {
		String sql = "select * from offers where item_status = ?";
		ArrayList<Offers> o = new ArrayList<>(); 
		try (Connection c = UtilConnection.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, "accepted");
					
			ResultSet rs = ps.executeQuery();
			
				while(rs.next()) {
				
				int offer_id = rs.getInt("offer_id");
				int item_id = rs.getInt("item_id");
				String item_name = rs.getString("item_name");
				int item_offer = rs.getInt("item_offer");
				int user_id = rs.getInt("user_id");
				String item_status = rs.getString("item_status");
				String time = rs.getString("time");
				
				o.add(new Offers(offer_id, item_id, item_name, item_offer,user_id, item_status, time));	
			}
					
		}
		catch (SQLException e) {
			logE("Error sending/receiving data to the database");
		}
		
		return o;
	}
	
	public Integer calcWeeklyPayment(String date1, String date2) {
		String sql = "select sum(item_offer) from offers where item_status = ? and offers.time >= ? and offers.time <= ?;";
		int result = 0;
		try (Connection c = UtilConnection.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, "accepted");
			ps.setString(2,  date1);
			ps.setString(3, date2);
					
			ResultSet rs = ps.executeQuery();
			
				while(rs.next()) {
				
				result = rs.getInt("sum");
			}

		}
		catch (SQLException e) {
			logE("Error sending/receiving data to the database");
		}
		
		return result;
	}
	
	public List<Offers> viewOffersForItem(){
		String sql = "select * from offers where item_name = ?";
		ArrayList<Offers> o = new ArrayList<>(); 
		try (Connection c = UtilConnection.getConnectionFromEnv()){
			
			String itemName = sc.next() + sc.nextLine();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, itemName);
					
			ResultSet rs = ps.executeQuery();
			
				while(rs.next()) {
				
				int offer_id = rs.getInt("offer_id");
				int item_id = rs.getInt("item_id");
				String item_name = rs.getString("item_name");
				int item_offer = rs.getInt("item_offer");
							
				o.add(new Offers(offer_id, item_id, item_name, item_offer));	
			}
		
			
		}
		catch (SQLException e) {
			logE("Error sending/receiving data to the database");
		}
		
		return o;
	}
	
	public ArrayList<Offers> viewOffersForItem(String s) {
		String sql = "select * from offers where item_name = ?";
		ArrayList<Offers> o = new ArrayList<>(); 
		try (Connection c = UtilConnection.getConnectionFromEnv()){
			
			String itemName = sc.next() + sc.nextLine();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, itemName);
					
			ResultSet rs = ps.executeQuery();
			
				while(rs.next()) {
				
				int offer_id = rs.getInt("offer_id");
				int item_id = rs.getInt("item_id");
				String item_name = rs.getString("item_name");
				int item_offer = rs.getInt("item_offer");
							
				o.add(new Offers(offer_id, item_id, item_name, item_offer));	
			}
		
			
		}
		catch (SQLException e) {
			logE("Error sending/receiving data to the database");
		}
		
		return o;
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













