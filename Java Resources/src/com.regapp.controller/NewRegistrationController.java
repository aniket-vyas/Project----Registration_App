package com.regapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.regapp.model.DAOService;
import com.regapp.model.DAOServiceImpl;

@WebServlet("/saveReg")
public class NewRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NewRegistrationController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// when we click on the link "New Registration" it will reload the new_registration.jsp page
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/new_registration.jsp"); 
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession(false); // check for login purpose
			
			session.setMaxInactiveInterval(86400); // after 86400 sec you will logout/crash
			
			if(session.getAttribute("email")!=null) { 
			//it means some ID is present in email means you are login
			
				//it takes the user input data from new_registration.jsp file
				String name = request.getParameter("name");
				String city = request.getParameter("city");
				String email = request.getParameter("email");
				String mobile = request.getParameter("mobile");
			
				DAOService service = new DAOServiceImpl();
				service.connectDB(); // call for connect the DB
				
				service.saveRegistration(name, city, email, mobile); // & save the data
		
				// when you click on save it print the message
				request.setAttribute("msg", "record is save :) ");
			
			
				// this will redirect to the same page when you save new registartion details 
				// otherwise you go into blank white page
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/new_registration.jsp"); 
				rd.forward(request, response);
			
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp"); 
				//if email is null means you are logout then you will redirect into login page
				rd.forward(request, response);
			}
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp"); 
			//if any exception occurs then you will redirect into login page
			rd.forward(request, response);
		}
		
	}

}
