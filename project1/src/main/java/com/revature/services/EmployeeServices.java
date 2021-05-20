package com.revature.services;

import java.util.List;

import com.revature.daos.ReimbursementDAOImp;
import com.revature.daos.UsersDAOImp;
import com.revature.models.Reimbursement;
import com.revature.models.Users;

public class EmployeeServices {

	private UsersDAOImp uDAO = new UsersDAOImp();
	private ReimbursementDAOImp  rDAO = new ReimbursementDAOImp();
	public void viewHome() {
		
	}
	
	public Integer addTicket(Reimbursement r) {
		return rDAO.add(r);		
	}
	
	public Reimbursement uploadReceipt() {
		//TODO:
		return null;
	}
	
	public List<Reimbursement> viewPendingTickets(Users u) {
		return rDAO.viewPendingEmpTickets();
	}
	
	public List<Reimbursement> viewResolvedTickets(Users u) {
		return rDAO.viewResolvedEmpTickets();
	}
	
	public void viewInfo(Users u) {
		uDAO.getUserById(u.getId());
	}
	
	public Users updateInfo(Users u) {
		uDAO.updateInfo(u);
		return u;
	}
	
	public Users sendEmail(Users u) {
		//TODO:
		return null;
	}
}
