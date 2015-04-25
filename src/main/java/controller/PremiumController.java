package controller;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletContext;
import model.userModel;

public class PremiumController {
    
    public PremiumController() {
        
    }
    
    public void changePremium (HttpServletRequest request) {
        ServletContext context = request.getServletContext();
        HashMap<String, userModel> userRepository = (HashMap<String, userModel>) context.getAttribute("userRepository");
        userModel user = userRepository.get(request.getParameter("username"));
        
        if (request.getParameter("premium").equals("yes")) {
            user.setPremium(true);
        }
        else {
            user.setPremium(false);
        }
        
        user.addUserToSession(request);
    }
    
}
