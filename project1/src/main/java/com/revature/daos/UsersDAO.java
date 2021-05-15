package com.revature.daos;

import java.util.List;

import com.revature.models.Users;

public interface UsersDAO {
	
	int add(Users u);
	//int remove(Users u);
	Users getUserById(int id);
	//List<Users> getAllUsers();
	List<Users> getAllEmp();
	Integer updateInfo(Users u);
	Users viewInfo(Users u);
	List<Users> getUsersByRole(String s);
}
