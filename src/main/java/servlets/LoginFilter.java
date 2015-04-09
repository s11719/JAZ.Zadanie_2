package servlets;

import controller.AuthenticationController;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("*")
public class LoginFilter implements Filter {    

    AuthenticationController authentication = new AuthenticationController();
    
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date();
            
            if (true && true) {
                System.out.println("true " + dateFormat.format(date));
                
            }
            else {
                System.out.println("false " + dateFormat.format(date));
            }
            
            chain.doFilter(request, response);
        }

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
