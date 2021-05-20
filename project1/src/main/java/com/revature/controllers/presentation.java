package com.revature.controllers;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.revature.daos.ReimbursementDAOImp;
import com.revature.daos.UsersDAOImp;
import com.revature.models.Reimbursement;
import com.revature.services.EmployeeServices;

public class presentation {

	public static void main(String[] args) throws SQLException {
		UsersDAOImp udi = new UsersDAOImp();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  //yyyy/MM/dd HH:mm:ss
		LocalDateTime now = LocalDateTime.now(); 
//		udi.add(new Users(3, "firstname", "lastname", "username", "password","nguyenfelix79@yahoo.com", "emp"));
//		UtilConnection u = new UtilConnection();
//		
//		System.out.println(u.getConnectionFromEnv());
		
		ReimbursementDAOImp ri = new ReimbursementDAOImp();
		UsersDAOImp ui = new UsersDAOImp();
		System.out.println(ui.checkLogin("u", "p"));
//		Iterator it = r.viewAllTickets().iterator();
//		
//		while(it.hasNext()) {
//			Object o = it.next();
//			System.out.println(o);
//		}
		
//		ManagerServices ms = new ManagerServices();
//		System.out.println(ms.viewAllEmployees());
		
//		AtomicInteger ai = new AtomicInteger();
//		System.out.println(ai.incrementAndGet());	
//		System.out.println(ai.incrementAndGet());
//		System.out.println(ai.incrementAndGet());
//		System.out.println(ai.incrementAndGet());
		
//		EmployeeServices es = new EmployeeServices();
//		Reimbursement r = new Reimbursement();
//		r.setId(111);
//		r.setAmount(100.23);
//
//		r.setResolver(null);
//		r.setAuthor("Jenkins");
//		r.setDesc("chicken wangs");
//		r.setStatus("pending");
//		r.setType("food");
//		ri.add(r);

		
	}

}
