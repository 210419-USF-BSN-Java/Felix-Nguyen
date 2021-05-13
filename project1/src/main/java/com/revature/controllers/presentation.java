package com.revature.controllers;

import java.sql.SQLException;

import com.revature.daos.UsersDAOImp;
import com.revature.models.Users;

import util.UtilConnection;

public class presentation {

	public static void main(String[] args) throws SQLException {
		UsersDAOImp udi = new UsersDAOImp();
		udi.add(new Users(3, "firstname", "lastname", "username", "password","nguyenfelix79@yahoo.com", "emp"));
		UtilConnection u = new UtilConnection();
		
		System.out.println(u.getConnectionFromEnv());
	}

}
