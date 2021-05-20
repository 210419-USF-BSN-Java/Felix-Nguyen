package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.Users;

public interface ReimbursementDAO {

	Integer add(Reimbursement ticket);
	Integer remove(Reimbursement ticket);
	List<Reimbursement> viewAllTickets();
	Reimbursement getTicketById(int id);
	String getStatusById(int id);
	Integer getTicketsByType(String s);
	List<Reimbursement> viewEmpTickets();
	List<Reimbursement> viewPendingEmpTickets();// manager
	List<Reimbursement> viewResolvedEmpTickets();// manager
	List<Reimbursement> viewOwnPendingTickets();// employee
	List<Reimbursement> viewOwnResolvedTickets();// employee
	Reimbursement approveTicket(Users u, Reimbursement t);
	Reimbursement rejectTicket(Users u,Reimbursement t);
	
}
