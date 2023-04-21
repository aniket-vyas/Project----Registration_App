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

@WebServlet("/listAll")
public class GetAllRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public GetAllRegistrationController() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false); // check for login purpose
		
		if(session.getAttribute("email")!=null) { //it means some ID is present in email means you are login
		
			DAOService service = new DAOServiceImpl();
			service.connectDB(); // call for connect the DB
		
			ResultSet result = service.getAllReg();
			// call for to get all registrations details
		
			request.setAttribute("result", result);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/list_registration.jsp");
			// this will redirect to list_registration.jsp web page
			rd.forward(request, response);
		
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp"); 
			//if email is null means you are logout then you will redirect into login web page
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
