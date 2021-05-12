package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.EmployeeDelegate;
import com.revature.delegates.ManagerDelegate;


public class RequestHelper {

	EmployeeDelegate ed = new EmployeeDelegate();
	ManagerDelegate md = new ManagerDelegate();

	public void processRequest(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
			
		StringBuilder uriString = new StringBuilder(request.getRequestURI());
		uriString.replace(0, request.getContextPath().length() + 1, "");

		if (uriString.indexOf("/") != -1) {
			request.setAttribute("path", uriString.substring(uriString.indexOf("/") + 1));			
			uriString.replace(uriString.indexOf("/"), uriString.length(), "");
		}

		switch (uriString.toString()) {
		case "employee":
			ed.process(request, response);
			break;
		case "manager":
			md.process(request, response);
			break;
		default:
			response.sendError(404, "Path not supported");
		}
	}
}
