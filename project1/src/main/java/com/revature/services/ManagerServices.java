package com.revature.services;

import com.revature.models.Reimbursement;
import com.revature.models.Users;

public class ManagerServices {

	Reimbursement r = new Reimbursement(0, 0, null, null, null, null, null, null, null, null);
	
	public void viewHome() {
		
	}
	
	public Reimbursement approveTicket(Reimbursement ticket) {
		return r;
	}
	
	public Reimbursement denyTicket(Reimbursement ticket) {
		return r;
	}
	
	public void viewAllTickets() {
		
	}
	
	public void viewAllReceipts() {
		
	}
	
	public void viewAllEmployees() {
		
	}
	
	public int viewEmpTicket(Users u) {
		
		return -1;
	}
}
