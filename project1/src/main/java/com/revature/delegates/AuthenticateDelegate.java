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
		System.out.println(path);
		if((path == null) || path.equals("")) {
			switch (request.getMethod()) {
			case "GET":
			
			case "POST":
				// This is bad practice
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				
				PrintWriter pw = response.getWriter();
				
				// Some kind of validation process
				if(username.equals("admin") && password.equals("password")){
					// returned in the response to the client as a cookie to be used for requests
					HttpSession session =request.getSession();
					session.setAttribute("uname", username);
					
					request.getRequestDispatcher("Employees.html").forward(request, response);
				}else {
					request.getRequestDispatcher("index.html").include(request, response);
					pw.write("<div style='color:red;'> Unable to login </div>");
				}
				break;
			case "PUT":
				//TODO
				break;
			case "DELETE":
				HttpSession session = request.getSession(false);
				if(session != null) {
					session.invalidate();
				}			
				break;
			default:
				response.sendError(400, "Method not supported.");
			}
		}
	}
}

