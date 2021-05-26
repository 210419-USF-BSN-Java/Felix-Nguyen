package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.daos.ReimbursementDAOImp;
import com.revature.daos.UsersDAOImp;
import com.revature.models.Reimbursement;
import com.revature.models.Users;
import com.revature.services.ManagerServices;

public class ManagerDelegate implements Delegatable{

	private ManagerServices ms = new ManagerServices();
	private UsersDAOImp ui = new UsersDAOImp();
	private ReimbursementDAOImp ri = new ReimbursementDAOImp();
	private static Logger l = Logger.getLogger(ManagerDelegate.class.getName());
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
		Users u = new Users();
		System.out.println("Method in manager delegate: " + request.getMethod());
			switch (request.getMethod()) {
			case "GET":
				System.out.println("in Manager delegate doing post");
				Reimbursement r = new Reimbursement();
				String authToken = request.getHeader("Authorization");
				System.out.println("Token: " + authToken);

				if (authToken != null) {
					String[] tokenArr = authToken.split(":");

					if (tokenArr.length == 2) {
						String idStr = tokenArr[0];
						String userRoleStr = tokenArr[1];

						u = ui.getUserById(Integer.parseInt(idStr));
						System.out.println(u.toString());
					}
				}
				
				System.out.println("ID: " + request.getHeader("id"));
				System.out.println("Select: " + request.getHeader("select"));
				try {
					if(request.getHeader("select").equals("Accept")){
						r = ri.getTicketById(Integer.parseInt(request.getHeader("id")));		
					
						ms.approveTicket(u, r);
					}
					else {
						r = ri.getTicketById(Integer.parseInt(request.getHeader("id")));
						ms.rejectTicket(u, r);
					}
				
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case "POST":
				
				break;
			case "DELETE":
				//TODO
				break;
			default:
				response.sendError(400, "Method not supported.");
			}
		}
	public void logI(String s) { // outputs string 's' with new line
		l.info(s);
		l.info("                 ");
	}
	
	public void logE(String s) { // outputs string 's' with new line
		l.error(s);
		l.error("                 ");
	}
	}

