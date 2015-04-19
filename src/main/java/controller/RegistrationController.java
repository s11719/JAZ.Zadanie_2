package controller;

import model.*;
import javax.servlet.http.HttpServletRequest;

public class RegistrationController {
        
    public RegistrationController(){
		
    }
	
    public void registerNewUser(HttpServletRequest request){
        userModel user  = new userModel(request.getParameter("username"), request.getParameter("email"), request.getParameter("role"));
        userRepository repository = new userRepository(request);
        credentialsRepository credentials = new credentialsRepository(request);
        
        repository.addUser(user.getUsername(), user, request);
        
        user.addUserToSession(request);
        
        credentials.addCredentials(request.getParameter("username"), request.getParameter("password"));       
    }    
	
}
