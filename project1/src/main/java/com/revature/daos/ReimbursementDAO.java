package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDAO {

	Integer add(Reimbursement ticket);
	Integer remove(Reimbursement ticket);
	List<Reimbursement> viewAllTickets();
	Reimbursement getTicketById(int id);
	String getStatusById(int id);
	Integer getTicketsByType(String s);
	List<Reimbursement> viewEmpTickets();
	List<Reimbursement> viewPendingEmpTickets();
	List<Reimbursement> viewResolvedEmpTickets();
	
	
}
