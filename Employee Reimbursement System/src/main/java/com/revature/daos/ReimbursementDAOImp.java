package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.delegates.AuthenticateDelegate;
import com.revature.models.Reimbursement;
import com.revature.models.Users;

import util.UtilConnection;

public class ReimbursementDAOImp implements ReimbursementDAO{

	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	private static Logger l = Logger.getLogger(ReimbursementDAOImp.class.getName());
	@Override
	public Integer add(Reimbursement ticket) {

		String sql = "insert into reimbursement (reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_authorid, reimb_resolver, reimb_status, reimb_type) values (?,?,?,?,?,?,?,?,?,?,?)";

				int rs = 0;
				try (Connection c = UtilConnection.getConnectionFromEnv()){
					
					PreparedStatement ps = c.prepareStatement(sql);					
					ps.setInt(1, ticket.getId());
					ps.setDouble(2, ticket.getAmount());
					ps.setTimestamp(3, timestamp);
					ps.setTimestamp(4, null); //timestamp resolved
					ps.setString(5, ticket.getDesc());
					ps.setString(6, null); //receipt
					ps.setString(7, ticket.getAuthor());
					ps.setInt(8, ticket.getAuthorId());
					ps.setString(9, ticket.getResolver());
					ps.setString(10, ticket.getStatus());
					ps.setString(11, ticket.getType());
		
					rs = ps.executeUpdate();
					System.out.println("Time: " + timestamp);
				}
				catch (SQLException e) {
					logE("Error sending/receiving data to the database");
				
				}
		
				return rs;
	}

	@Override
	public Integer remove(Reimbursement ticket) {
	
			String sql = "delete from reimbursement where reimb_id = ?";
					
					int rs = 0;
					try (Connection c = UtilConnection.getConnectionFromEnv()){
						
						PreparedStatement ps = c.prepareStatement(sql);	
						ps.setInt(1,ticket.getId());
						

						rs = ps.executeUpdate();
			
					}
					catch (SQLException e) {
						logE("Error sending/receiving data to the database");
						//e.getStackTrace();
					}
			
					return rs;	}

	@Override
	public List<Reimbursement> viewAllTickets() {
		String sql = "select * from reimbursement";
		List<Reimbursement> rsList = new ArrayList<>();
		try (Connection c = UtilConnection.getConnectionFromEnv()){
			
			PreparedStatement ps = c.prepareStatement(sql);	

			ResultSet rs = ps.executeQuery();
			
				while(rs.next()) {
					rsList.add(new Reimbursement(rs.getInt("reimb_id"), 
												  rs.getInt("reimb_amount"),
												  rs.getString("reimb_submitted"),
												  rs.getString("reimb_resolved"),
												  rs.getString("reimb_description"),
												  rs.getString("reimb_receipt"),
												  rs.getString("reimb_author"),
												  rs.getInt("reimb_authorid"),
												  rs.getString("reimb_resolver"),
												  rs.getString("reimb_status"),
												  rs.getString("reimb_type")));
				}
			
		}
		catch (SQLException e) {
			logE("Error sending/receiving data to the database");
			//e.getStackTrace();
		}

		return rsList;
	}


	@Override
	public List<Reimbursement> viewEmpTickets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> viewPendingEmpTickets() {
		String sql = "select * from reimbursement where reimb_type = ?";
		List<Reimbursement> rsList = new ArrayList<>();
		try (Connection c = UtilConnection.getConnectionFromEnv()){
			
			PreparedStatement ps = c.prepareStatement(sql);	
			ps.setString(1, "pending");
			

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				rsList.add(new Reimbursement(rs.getInt("reimb_id"), 
											  rs.getInt("reimb_amount"),
											  rs.getString("reimb_submitted"),
											  rs.getString("reimb_resolved"),
											  rs.getString("reimb_description"),
											  rs.getString("reimb_receipt"),
											  rs.getString("reimb_author"),
											  rs.getInt("reimb_authorID"),
											  rs.getString("reimb_resolver"),
											  rs.getString("reimb_status"),
											  rs.getString("reimb_type")));
			}

		}
		catch (SQLException e) {
			//logE("Error sending/receiving data to the database");
			e.getStackTrace();
		}

		return rsList;
				
	}

	@Override
	public List<Reimbursement> viewResolvedEmpTickets() {
		String sql = "select * from reimbursement where reimb_type = ?";
		List<Reimbursement> rsList = new ArrayList<>();
		try (Connection c = UtilConnection.getConnectionFromEnv()){
			
			PreparedStatement ps = c.prepareStatement(sql);	
			ps.setString(1, "resolved");
			

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				rsList.add(new Reimbursement(rs.getInt("reimb_id"), 
											  rs.getInt("reimb_amount"),
											  rs.getString("reimb_submitted"),
											  rs.getString("reimb_resolved"),
											  rs.getString("reimb_description"),
											  rs.getString("reimb_receipt"),
											  rs.getString("reimb_author"),
											  rs.getInt("reimb_authorID"),
											  rs.getString("reimb_resolver"),
											  rs.getString("reimb_status"),
											  rs.getString("reimb_type")));
			}

		}
		catch (SQLException e) {
			logE("Error sending/receiving data to the database");
			//e.getStackTrace();
		}

		return rsList;
	}

	@Override
	public Reimbursement getTicketById(int id) {
		String sql = "select * from reimbursement where reimb_id = ?";
		Reimbursement ticket = new Reimbursement();
		try (Connection c = UtilConnection.getConnectionFromEnv()){
			
			PreparedStatement ps = c.prepareStatement(sql);	
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			ticket = new Reimbursement(rs.getInt("reimb_id"), 
											  rs.getInt("reimb_amount"),
											  rs.getString("reimb_submitted"),
											  rs.getString("reimb_resolved"),
											  rs.getString("reimb_description"),
											  rs.getString("reimb_receipt"),
											  rs.getString("reimb_author"),
											  rs.getInt("reimb_authorID"),
											  rs.getString("reimb_resolver"),
											  rs.getString("reimb_status"),
											  rs.getString("reimb_type"));
			}

		}
		catch (SQLException e) {
			logE("Error sending/receiving data to the database");
			//e.getStackTrace();
		}

		return ticket;
	}

	@Override
	public Integer approveTicket(Users u, Reimbursement t) {
		String sql = "update reimbursement set reimb_resolved = ?, reimb_resolver = ?, reimb_status = ? where reimb_id = ?";
		Reimbursement ticket = new Reimbursement();
		int rs = 0;
		try (Connection c = UtilConnection.getConnectionFromEnv()){
			
			PreparedStatement ps = c.prepareStatement(sql);	
			ps.setTimestamp(1, timestamp);
			ps.setString(2, u.getFirstName() + " " + u.getLastName());
			ps.setString(3, "approved");
			ps.setInt(4, t.getId());

		 rs = ps.executeUpdate();
			
			}

		
		catch (SQLException e) {
			logE("Error sending/receiving data to the database");
			//e.getStackTrace();
		}

		return rs;
	}


	@Override
	public Integer rejectTicket(Users u, Reimbursement t) {
		String sql = "update reimbursement set reimb_resolved = ?, reimb_resolver = ?, reimb_status = ? where reimb_id = ?";
		Reimbursement ticket = new Reimbursement();
		int rs = 0;
		try (Connection c = UtilConnection.getConnectionFromEnv()){
			
			PreparedStatement ps = c.prepareStatement(sql);	
			ps.setTimestamp(1, timestamp);
			ps.setString(2, u.getFirstName() + " " + u.getLastName());
			ps.setString(3, "rejected");
			ps.setInt(4, t.getId());

			rs = ps.executeUpdate();
			
			}

		
		catch (SQLException e) {
			logE("Error sending/receiving data to the database");
			
		}

		return rs;
	}

	@Override
	public List<Reimbursement> viewOwnPendingTickets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> viewOwnResolvedTickets() {
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
