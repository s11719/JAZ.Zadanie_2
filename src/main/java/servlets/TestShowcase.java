package servlets;


import controller.*;
import model.*;

import java.util.HashMap;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class TestShowcase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestShowcase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {                
            response.getWriter().println("Hello!");
            
        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();
            
            System.out.println("Servlet is called " + getServletName());
            System.out.println("Username: " + session.getAttribute("username"));
            System.out.println("Email: " + session.getAttribute("email"));
            System.out.println("User role: " + session.getAttribute("role"));  
            
        HashMap<String, userModel> userRepository = (HashMap<String, userModel>) context.getAttribute("userRepository");
        userModel user = userRepository.get(session.getAttribute("username"));
            
        response.getWriter().println("User from list is called " + user.getUsername()); 
        response.getWriter().println("Number of users is " + userRepository.size());
        }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	               
		
	}

}
