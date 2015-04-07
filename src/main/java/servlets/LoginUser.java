
package servlets;

import controller.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    Login login = new Login();
    
    public LoginUser() {
        super();        
    }
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    }
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        login.loginUser(request);
	
        response.sendRedirect("TestShowcase");		
    }
    
}