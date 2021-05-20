package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.AuthenticateDelegate;
import com.revature.delegates.EmployeeDelegate;
import com.revature.delegates.ManagerDelegate;
import com.revature.delegates.ReimbursementDelegate;


public class RequestHelper {

	EmployeeDelegate ed = new EmployeeDelegate();
	ManagerDelegate md = new ManagerDelegate();
	ReimbursementDelegate rd = new ReimbursementDelegate();
	AuthenticateDelegate ad = new AuthenticateDelegate();
	public void processRequest(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
			
		StringBuilder uriString = new StringBuilder(request.getRequestURI());
		uriString.replace(0, request.getContextPath().length() + 1, "");

		if (uriString.indexOf("/") != -1) {
			request.setAttribute("path", uriString.substring(uriString.indexOf("/") + 1));			
			uriString.replace(uriString.indexOf("/"), uriString.length(), "");
		}

		switch (uriString.toString()) {
		case "Login":
			ad.process(request, response);
			break;
		case "Employee":
			ed.process(request, response);
			break;
		case "Manager":
			md.process(request, response);
			break;
		case "Reimbursement":
			rd.process(request, response);
			break;
		default:
			response.sendError(404, "Path not supported");
		}
	}
}
