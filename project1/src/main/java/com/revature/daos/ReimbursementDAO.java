package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDAO {

	int add(Reimbursement ticket);
	int remove(Reimbursement ticket);
	List<Reimbursement> viewAllTickets();
	Reimbursement getTicketById();
	List<Reimbursement> viewEmpTickets();
	List<Reimbursement> viewPendingEmpTickets();
	List<Reimbursement> viewResolvedEmpTickets();
	
	
}
