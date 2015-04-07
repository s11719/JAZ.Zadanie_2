package controller;


import model.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class Register {

    userModel user;
    userRepository repository = new userRepository();
	
        
    public Register(){
		
    }
	
    public void registerNewUser(HttpServletRequest request){
        this.user  = new userModel(request.getParameter("username"), request.getParameter("email"), request.getParameter("role"));
            
        repository.addUser(user.getUsername(), this.user, request);           
    }
	
        
    public void addUserToSession(HttpServletRequest request){
        HttpSession session = request.getSession();
            
        session.setAttribute("username", this.user.getUsername());
        session.setAttribute("email", this.user.getEmail());
        session.setAttribute("role", this.user.getRole());
    }        
	
}
