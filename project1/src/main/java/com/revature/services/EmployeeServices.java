package com.revature.services;

import com.revature.models.Reimbursement;
import com.revature.models.Users;

public class EmployeeServices {

	Reimbursement r = new Reimbursement(0, 0, null, null, null, null, null, null, null, null);
	Users user = new Users(0, null, null, null, null, null, null);
	
	public void viewHome() {
		
	}
	
	public Reimbursement addTicket() {
		return r;
	}
	
	public Reimbursement uploadReceipt() {
		return r;
	}
	
	public Reimbursement viewPendingTickets(Users u) {
		return r;
	}
	
	public Reimbursement viewResolvedTickets(Users u) {
		return r;
	}
	
	public int viewInfo(Users u) {
		return -1;
	}
	
	public Users updateInfo(Users u) {
		return user;
	}
	
	public Users sendEmail(Users u) {
		return user;
	}
}
