package com.revature.controllers;

import java.sql.SQLException;
import java.util.Iterator;

import com.revature.daos.ReimbursementDAOImp;

public class presentation {

	public static void main(String[] args) throws SQLException {
//		UsersDAOImp udi = new UsersDAOImp();
//		udi.add(new Users(3, "firstname", "lastname", "username", "password","nguyenfelix79@yahoo.com", "emp"));
//		UtilConnection u = new UtilConnection();
//		
//		System.out.println(u.getConnectionFromEnv());
		
		ReimbursementDAOImp r = new ReimbursementDAOImp();
		
		Iterator it = r.viewAllTickets().iterator();
		
		while(it.hasNext()) {
			Object o = it.next();
			System.out.println(o);
		}
		
	}

}
