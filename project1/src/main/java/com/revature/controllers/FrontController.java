package com.revature.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;


public class FrontController extends DefaultServlet{

	private static final long serialVersionUID = 1L;

	private RequestHelper rh = new RequestHelper();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
//		PrintWriter pw = response.getWriter();
//		pw.println("hello");
		String path = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(request.getRequestURI());
		System.out.println(request.getContextPath());
		
		if(path.startsWith("/static/") || path.equals("/") || path.equals("/index.html") ) {
			super.doGet(request, response);
		}else {
			rh.processRequest(request, response);
		}
		
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doGet(request, response);
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doGet(request, response);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doGet(request, response);
	}
}
