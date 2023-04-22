package com.regapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public LogOutController() {
      
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false); 
		// false --> it will not create new one but it is using which is already created
		// true --> it will create new session variable
		
		session.invalidate();
		// it will make email ID null means you are logout
		
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		// when we click on logout it will call post() and redirect to login.jsp page
		rd.forward(request, response);
	}

}
