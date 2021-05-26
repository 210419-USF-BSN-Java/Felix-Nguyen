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
		System.out.println("Uri: " + uriString.toString());
		System.out.println("Path: "+  request.getServletPath());
		switch (uriString.toString()) {
		case "":
			ad.process(request, response);
			System.out.println("inside authentication");
			break;
		case "Submit.html":
			request.getRequestDispatcher("/static/Submit.html").forward(request, response);
			//esd.process(request, response);
			break;
	
		case "ManagerHome.html":		
			System.out.println("inside managerhome");
			request.getRequestDispatcher("/static/Manager/ManagerHome.html").forward(request, response);
			break;
		case "ViewAllEmp.html":		
			System.out.println("inside viewAllEmp");
			request.getRequestDispatcher("/static/Manager/ViewAllEmp.html").forward(request, response);
			break;
		case "A_R_Requests.html":		
			System.out.println("inside Requests");
			request.getRequestDispatcher("/static/Manager/A_R_Requests.html").forward(request, response);
			break;
		case "login":		
			System.out.println("inside login");
			request.getRequestDispatcher("/index.html").forward(request, response);
			break;
		case "Employee":
			ed.process(request, response);
			break;
		case "Manager":
			System.out.println("inside manager request helper");
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
