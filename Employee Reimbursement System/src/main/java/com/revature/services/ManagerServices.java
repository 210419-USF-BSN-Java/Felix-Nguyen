package com.revature.services;

import java.util.List;

import com.revature.daos.ReimbursementDAOImp;
import com.revature.daos.UsersDAOImp;
import com.revature.models.Reimbursement;
import com.revature.models.Users;

public class ManagerServices {

	private UsersDAOImp uDAO = new UsersDAOImp();
	private ReimbursementDAOImp  rDAO = new ReimbursementDAOImp();
	
	
	public Integer approveTicket(Users u, Reimbursement ticket) {
		return rDAO.approveTicket(u, ticket);
		
	}
	
	public Integer rejectTicket(Users u, Reimbursement ticket) {
		return rDAO.rejectTicket(u, ticket);
	}
	
	public List<Reimbursement> viewAllTickets() {
		return rDAO.viewAllTickets();
	}
	
	public void viewAllReceipts() {
		//TODO:	
	}
	
	public List<Users> viewAllEmployees() {
		return uDAO.getAllEmp();
	}
	
	public List<Reimbursement> viewEmpTicket(Users u) {
		return rDAO.viewEmpTickets();
	}
}
