package com.regapp.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.regapp.model.DAOService;
import com.regapp.model.DAOServiceImpl;

@WebServlet("/update")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public UpdateController() {
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);  // check for login purpose
		
		//session.setMaxInactiveInterval(86400); // after 86400 sec you will logout/crash
		
		if(session.getAttribute("email")!=null) { //it means some ID is present in email means you are login
		
			// it takes the data from registration table
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
		
			request.setAttribute("email", email);
			request.setAttribute("mobile", mobile);
		
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/update_registration.jsp");
			// it will redirect to update_registration.jsp webpage for update
			rd.forward(request, response);
		
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp"); 
			//if email is null means you are logout then you will redirect into login web page
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);  // check for login purpose
		
		//session.setMaxInactiveInterval(86400); // after 86400 sec you will logout/crash
		
		if(session.getAttribute("email")!=null) { //it means some ID is present in email means you are login
		
			// it takes the data from user & store in it
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
		
			DAOService service = new DAOServiceImpl();
			service.connectDB();  // call for connect the DB
			
			service.updateReg(email , mobile);  // call for update
		
			ResultSet result = service.getAllReg();
			// call for to get all registrations details
			
			request.setAttribute("result", result);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/list_registration.jsp");
			// it will redirect to the same page after update the record
			rd.forward(request, response);
		
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp"); 
			//if email is null means you are logout then you will redirect into login web page
			rd.forward(request, response);
		}
	}	
}
