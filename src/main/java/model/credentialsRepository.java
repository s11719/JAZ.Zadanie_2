
package model;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;


public class credentialsRepository {
   
    HashMap<String, String> credentialsRepository;    
    
    public credentialsRepository() {
        this.credentialsRepository = new HashMap<String, String>();
    }    
    
    public void addCredentials(String username, String password, HttpServletRequest request) {
        
        this.credentialsRepository.put(username, password);
        
        ServletContext context = request.getServletContext(); 
        context.setAttribute("credentialsRepository", this.credentialsRepository);
    }    
    
    public int validateUser(String username, String password) {
        String validation = this.credentialsRepository.get("username");
        
        if (validation == password) {
            return 1;
        }
        else {
            return 0;
        }
    }    
    
    public int checkIfUserExists(String username) {
        if (this.credentialsRepository.get("username") != null) {
            return 1;
        }
        else {
            return 0;
        }
    }   
    
}
