package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;

import util.UtilConnection;

public class ReimbursementDAOImp implements ReimbursementDAO{

	@Override
	public Integer add(Reimbursement ticket) {
		String sql = "insert into reimbursement (reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt reimb_author, reimb_resolver, reimb_status, reimb_type) values (?,?,?,?,?,?,?,?,?,?)";
				
				int rs = 0;
				try (Connection c = UtilConnection.getConnectionFromEnv()){
					
					PreparedStatement ps = c.prepareStatement(sql);			
					ps.setInt(1, ticket.getId());
					ps.setInt(2, ticket.getAmount());
					ps.setString(3, "CURRENT_TIMESTAMP"); //timestamp
					ps.setString(4, null); //timestamp
					ps.setString(5, ticket.getDesc());
					ps.setString(6, null); //receipt
					ps.setString(7, ticket.getAuthor());
					ps.setString(8, ticket.getResolver());
					ps.setString(9, ticket.getStatus());
					ps.setString(10, ticket.getType());
		
					rs = ps.executeUpdate();
		
				}
				catch (SQLException e) {
					//logE("Error sending/receiving data to the database");
					e.getStackTrace();
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
						//logE("Error sending/receiving data to the database");
						e.getStackTrace();
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
	public Reimbursement getTicketById(int id) {
		String sql = "select * from reimbursement where reimb_id = ?";
		Reimbursement ticket = new Reimbursement();
		try (Connection c = UtilConnection.getConnectionFromEnv()){
			
			PreparedStatement ps = c.prepareStatement(sql);	
			ps.setString(1, "pending");
			

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			ticket = new Reimbursement(rs.getInt("reimb_id"), 
											  rs.getInt("reimb_amount"),
											  rs.getString("reimb_submitted"),
											  rs.getString("reimb_resolved"),
											  rs.getString("reimb_description"),
											  rs.getString("reimb_receipt"),
											  rs.getString("reimb_author"),
											  rs.getString("reimb_resolver"),
											  rs.getString("reimb_status"),
											  rs.getString("reimb_type"));
			}

		}
		catch (SQLException e) {
			//logE("Error sending/receiving data to the database");
			e.getStackTrace();
		}

		return ticket;
	}

	@Override
	public String getStatusById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getTicketsByType(String s) {
		// TODO Auto-generated method stub
		return null;
	}

}
