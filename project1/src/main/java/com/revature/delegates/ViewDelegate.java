//package com.revature.delegates;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class ViewDelegate {
//	
//	public void resolveView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String path = request.getServletPath();
//		switch(path) {
//		case "/login":
//			System.out.println(" moving to /index.html");
//			request.getRequestDispatcher("project1/index.html").forward(request, response);		
//			break;
////		case "/EmployeeHome":
////			request.getRequestDispatcher(".html").forward(request, response);
////			break;
////		default:
////			response.sendError(404, "Static Resource Not Found");
//		}
//	}
//}
