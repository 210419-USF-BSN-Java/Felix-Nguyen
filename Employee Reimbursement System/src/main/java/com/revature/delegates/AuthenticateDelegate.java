package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.daos.UsersDAO;
import com.revature.daos.UsersDAOImp;
import com.revature.models.Users;

public class AuthenticateDelegate implements Delegatable{
	private static Logger l = Logger.getLogger(AuthenticateDelegate.class.getName());
	UsersDAO u = new UsersDAOImp();
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String path = (String) request.getAttribute("path");

		System.out.println(path);
		if((path == null) || path.equals("")) {
			switch (request.getMethod()) {
			case "GET":

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
					logI("Login Successful | Username: " + username + " " + "Password: " + password + " | " + "Token: " + token);
					
				}
				else {
					System.out.println("incorrect credentials");
					request.getRequestDispatcher("/index.html").forward(request, response);
					logI("Login Failed | Username: " + username + " " + "Password: " + password);
				}
				
				break;
			case "PUT":
				//TODO
				break;
			case "DELETE":
				break;			
			default:
				response.sendError(400, "Method not supported.");
				logE("Path in Authenticate Delegate not supported");
				break;
				}			
			
			
			}
		}
	public void logI(String s) { // outputs string 's' with new line
		l.info(s);
		l.info("                 ");
	}
	
	public void logE(String s) { // outputs string 's' with new line
		l.error(s);
		l.error("                 ");
	}
	}


