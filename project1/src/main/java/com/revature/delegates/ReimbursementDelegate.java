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

import com.revature.models.Reimbursement;
import com.revature.services.EmployeeServices;
import com.revature.services.ManagerServices;


public class ReimbursementDelegate implements Delegatable{
	private EmployeeServices es = new EmployeeServices();
	private ManagerServices ms = new ManagerServices();
	
	ObjectMapper om = new ObjectMapper();
	AtomicInteger ai = new AtomicInteger();
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
				r.setId(ai.incrementAndGet());
				System.out.println(request.getParameter("Amount"));
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
