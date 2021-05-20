package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.services.EmployeeServices;
import com.revature.services.ManagerServices;

public class EmployeeDelegate implements Delegatable{
	private EmployeeServices es = new EmployeeServices();
	private ManagerServices ms = new ManagerServices();
	private ObjectMapper om = new ObjectMapper();
	
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
				//TODO
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
