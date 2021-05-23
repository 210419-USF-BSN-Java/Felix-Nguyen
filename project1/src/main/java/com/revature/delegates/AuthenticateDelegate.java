package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.daos.UsersDAO;
import com.revature.daos.UsersDAOImp;

import com.revature.models.Users;

public class AuthenticateDelegate implements Delegatable{

	UsersDAO u = new UsersDAOImp();
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String path = (String) request.getAttribute("path");
		//String path = request.getServletPath();
		System.out.println(path);
		if((path == null) || path.equals("")) {
			switch (request.getMethod()) {
			case "GET":
//				System.out.println("get auth delegate");
//				request.getRequestDispatcher("/index.html").forward(request, response);
			case "POST":
				System.out.println("inside authen ");
				String username = request.getParameter("username");
				String password = request.getParameter("password");

				Users us = u.checkLogin(username, password);
				System.out.println(us);
	
				if (us.getId() > 0) {
					
					String token = us.getId() + ":" + us.getRole();
					System.out.println("token: " + token);
					response.setStatus(200);
					response.setHeader("Authorization", token);
					
				}
				else {
					System.out.println("incorrect credentials");
					request.getRequestDispatcher("/index.html").forward(request, response);
				}
				
				break;
			case "PUT":
				//TODO
				break;
			case "DELETE":
				break;			
			default:
				response.sendError(400, "Method not supported.");
				break;
				}			
			
			
			}
		}
	}


