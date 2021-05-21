package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.UsersDAOImp;
import com.revature.models.Reimbursement;
import com.revature.models.Users;
import com.revature.services.EmployeeServices;
import com.revature.services.ManagerServices;


public class ReimbursementDelegate implements Delegatable{
	private EmployeeServices es = new EmployeeServices();
	private ManagerServices ms = new ManagerServices();
	private UsersDAOImp ui = new UsersDAOImp();
	ObjectMapper om = new ObjectMapper();
	AtomicInteger ai = new AtomicInteger();
	Users u = new Users();
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String path = (String) request.getAttribute("path");
	
		if((path == null) || path.equals("")) {
			switch (request.getMethod()) {
			case "GET":
				PrintWriter pw = response.getWriter();
				pw.write(om.writerWithDefaultPrettyPrinter().writeValueAsString(ms.viewAllTickets()));		
			case "POST":
				Reimbursement r = new Reimbursement();
		
				String authToken = request.getHeader("Authorization");
				System.out.println("Token: " + authToken);
				// check to see if there is an auth header
				if (authToken != null) {
					String[] tokenArr = authToken.split(":");
					// if the token is formatted the way we expect, we can take the id from it and
					// query for that user
					if (tokenArr.length == 2) {
						String idStr = tokenArr[0];
						String userRoleStr = tokenArr[1];

						// check to see if there is a valid user and if that user is the appropriate
						// role in their token
						
						u = ui.getUserById(Integer.parseInt(idStr));
					}
				}
				r.setId(ai.incrementAndGet());
				System.out.println("Amount: " + request.getParameter("Amount"));
				r.setAuthor(u.getFirstName() + " " + u.getLastName());
				r.setAmount(Double.parseDouble(request.getParameter("Amount")));						
				r.setDesc(request.getParameter("Description"));
				r.setStatus("submitted");
				r.setType(request.getParameter("type"));
				es.addTicket(r);
				response.setStatus(201);
				response.sendRedirect("../project1/Reimbursement");
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
