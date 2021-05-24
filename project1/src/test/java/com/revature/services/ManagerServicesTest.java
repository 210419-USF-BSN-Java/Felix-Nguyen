package com.revature.services;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.revature.daos.ReimbursementDAOImp;
import com.revature.daos.UsersDAOImp;
import com.revature.models.Reimbursement;
import com.revature.models.Users;
import com.revature.services.ManagerServices;

public class ManagerServicesTest {

	private ManagerServices ms = new ManagerServices();
	
	@Test
	public void approveTicket_T() {
		Users u = new UsersDAOImp().getUserById(5);
		Reimbursement r = new ReimbursementDAOImp().getTicketById(11);
		assertTrue(ms.approveTicket(u, r) == 1);
		
	}
	
	//reject the same ticket from the previous test
	@Test
	public void rejectTicket_T() {
		Users u = new UsersDAOImp().getUserById(5);
		Reimbursement r = new ReimbursementDAOImp().getTicketById(11);
		assertTrue(ms.rejectTicket(u, r) == 1);
	}
	
	@Test
	public void viewAllTickets_T() {
		assertTrue(ms.viewAllTickets().size() == 5);
	}
	
	@Test
	public void viewAllEmployees_T() {
		assertTrue(ms.viewAllEmployees().size() == 6);
	}

}
