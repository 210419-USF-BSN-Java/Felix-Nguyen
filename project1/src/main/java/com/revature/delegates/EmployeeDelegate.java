package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.UsersDAOImp;
import com.revature.models.Users;
import com.revature.services.EmployeeServices;
import com.revature.services.ManagerServices;

public class EmployeeDelegate implements Delegatable{
	private EmployeeServices es = new EmployeeServices();
	private ManagerServices ms = new ManagerServices();
	private ObjectMapper om = new ObjectMapper();
	private UsersDAOImp ui = new UsersDAOImp();
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String path = (String) request.getAttribute("path");
		System.out.println(path);
		if((path == null) || path.equals("")) {
			switch (request.getMethod()) {
			case "GET":
				PrintWriter pw = response.getWriter();
				System.out.println(ms.viewAllEmployees());
				pw.write(om.writerWithDefaultPrettyPrinter().writeValueAsString(ms.viewAllEmployees()));				
			case "POST":
				Users u = new Users();
				String authToken = request.getHeader("Authorization");
				System.out.println("Token: " + authToken);

				if (authToken != null) {
					String[] tokenArr = authToken.split(":");
					if (tokenArr.length == 2) {
						String idStr = tokenArr[0];
						String userRoleStr = tokenArr[1];						
						u = ui.getUserById(Integer.parseInt(idStr));
					}
				}
				System.out.println("firstname: " + request.getHeader("firstName"));
				System.out.println("lastname: " + request.getHeader("lastName"));
				System.out.println("username: " + request.getHeader("username"));
				System.out.println("password: " + request.getHeader("password"));
				System.out.println("email: " + request.getHeader("email"));
				
				u.setFirstName(request.getHeader("firstName"));
				u.setLastName(request.getHeader("lastName"));
				u.setUsername(request.getHeader("username"));
				u.setPassword(request.getHeader("password"));
				u.setEmail(request.getHeader("email"));
				ui.updateInfo(u);							
				
				response.setStatus(201);
				break;
			case "PUT":
				//TODO
				break;
			case "DELETE":
				//TODO
				break;
			default:
				response.sendError(400, "Method not supported.");
			}
		}
	}
}
