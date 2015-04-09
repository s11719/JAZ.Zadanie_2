package servlets;

import controller.AuthenticationController;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("*")
public class RegisterFilter implements Filter {    

    AuthenticationController authentication = new AuthenticationController();
    
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            if (authentication.usernameFree(request, request.getParameter("username"))) {
                chain.doFilter(request, response);                
            }		
            else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
                dispatcher.forward(request, response);
            }
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
