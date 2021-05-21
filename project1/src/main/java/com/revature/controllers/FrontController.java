package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import com.revature.delegates.AuthenticateDelegate;
import com.revature.delegates.ReimbursementDelegate;



public class FrontController extends DefaultServlet{

	private static final long serialVersionUID = 1L;

	private RequestHelper rh = new RequestHelper();
	private AuthenticateDelegate ad = new AuthenticateDelegate();
	private ReimbursementDelegate rd = new ReimbursementDelegate();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

		String path = request.getRequestURI().substring(request.getContextPath().length());

		System.out.println("Path in get: " + path);
		if(path.equals("/index.html") || path.startsWith("/static/")) {
			super.doGet(request, response);
			System.out.println("super.doGet");
		}
		else {			
			System.out.println("call request helper from front controler");
			rh.processRequest(request, response);
		}	
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		//doGet(request, response);
		//rh.processRequest(request, response);
		//Path: /static/Submit.html
		String path = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("Path in post: " + path);
		
		if(path.equals("static/Submit.html"))	{
				rd.process(request, response);
		}
		else if(path.equals("/Reimbursement")) {
			rd.process(request, response);
		}
		else {
			ad.process(request, response);
		}
		
		
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doGet(request, response);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doGet(request, response);
	}
}
