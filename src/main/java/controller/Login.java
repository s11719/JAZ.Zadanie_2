
package controller;

import model.*;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class Login {    
    
    public Login () {
        
    }    
    
    public void loginUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();
        
        HashMap<String, userModel> userRepository = (HashMap<String, userModel>) context.getAttribute("userRepository");
        userModel user = userRepository.get(request.getParameter("username"));
        
        user.addUserToSession(request);
    }
    
}
