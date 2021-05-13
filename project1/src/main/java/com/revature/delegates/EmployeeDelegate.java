package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EmployeeDelegate implements Delegatable{

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
			switch (request.getMethod()) {
			case "GET":
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