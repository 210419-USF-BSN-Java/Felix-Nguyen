package com.revature.services;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.revature.daos.UsersDAOImp;
import com.revature.models.Reimbursement;
import com.revature.models.Users;


public class EmployeeServicesTests {

	
	private EmployeeServices es = new EmployeeServices();
	private Reimbursement r = new Reimbursement();
	UsersDAOImp ui = new UsersDAOImp();
	
	
	//run test once
	@Test 
	public void viewInfo_T(){
		
		Users u = es.viewInfo(ui.getUserById(1));
		assertTrue(u.getUsername().equals("Username"));
		assertTrue(u.getPassword().equals("Password"));
		assertTrue(u.getFirstName().equals("First"));
		assertTrue(u.getLastName().equals("Last"));
		assertTrue(u.getEmail().equals("firstlast@gmail.com"));
		
	}
	
	@Test
	public void viewPendingTickets_T() {

		r.setAmount(100);
		r.setAuthor("William");
		r.setAuthorId(123);
		r.setDesc("flights");
		r.setId(234);
		r.setStatus("submitted");
				
		assertTrue(es.addTicket(r) == 1);
		
		List<Reimbursement> l = es.viewPendingTickets();				
		assertTrue(l.size() == 2);
	}
	
	@Test
	public void updateInfo_T() {
		Users u = new Users();
		u = ui.getUserById(3);
		u.setFirstName("somethingfirst");
		u.setLastName("somethinglast");
		es.updateInfo(u);
		assertTrue(es.updateInfo(u).getFirstName().equals("somethingfirst"));
		assertTrue(es.updateInfo(u).getLastName().equals("somethinglast"));
	}

}
