package controller;


import model.*;

import javax.servlet.http.HttpServletRequest;


public class Register {

    userModel user;
    userRepository repository = new userRepository();	
        
    public Register(){
		
    }
	
    public void registerNewUser(HttpServletRequest request){
        this.user  = new userModel(request.getParameter("username"), request.getParameter("email"), request.getParameter("role"));
            
        repository.addUser(user.getUsername(), this.user, request);
        user.addUserToSession(request);        
    }    
	
}
