package com.revature.daos;

import java.util.List;

import com.revature.models.Users;

public interface UsersDAO {
	
	Users checkLogin(String username, String password);
	int add(Users u);
	Users getUserById(int id);;
	List<Users> getAllEmp();
	Integer updateInfo(Users u);
	Users viewInfo(Users u);

}
