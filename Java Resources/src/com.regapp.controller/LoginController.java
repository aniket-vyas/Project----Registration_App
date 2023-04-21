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

@WebServlet("/verifyLogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginController() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// it takes the data from user & store in it
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			DAOService service = new DAOServiceImpl();
			service.connectDB(); // it call the method connectDB
			
			boolean status = service.verifyCredentials(email, password);
			// it call the method verifyCredentials() 
			// for check email & pass is true or not
			if(status == true) {
				
				HttpSession session = request.getSession(true); 
				// it create new session variable for login purpose
				
				session.setAttribute("email", email); // and it store email ID into email 
				
				// session.setMaxInactiveInterval(86400); // after 86400 sec you will logout/crash
				
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/new_registration.jsp"); 
				rd.forward(request, response);
				// when we click on login it will redirect into new_registration webpage
				
			} else {
				
				request.setAttribute("error", "Invalid :| Username / Password !!");
				
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp"); 
				//if email , pass is wrong remain on the same page
				rd.forward(request, response);
				
			}
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp"); 
			//if exception occurs , remain on the same page
			rd.forward(request, response);
		}
		
	}

}
