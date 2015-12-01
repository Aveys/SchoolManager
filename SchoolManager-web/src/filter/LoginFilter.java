package filter;
 
import java.io.IOException;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.User;
 
 
/**
 * Filter checks if LoginBean has loginIn property set to true.
 * If it is not set then request is being redirected to the login.xhml page.
 * 
 * @author itcuties
 *
 */
public class LoginFilter implements Filter {
 
    /**
     * Checks if user is logged in. If not it redirects to the login.xhtml page.
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	System.out.println("contxt : "+((HttpServletRequest)request).getRequestURI());
    	if(((HttpServletRequest)request).getRequestURI().contains("loginPage.xhtml")){
    		chain.doFilter(request, response);
    	}else{
    		try {
    			// Get the loginBean from session attribute
    			//récupère l'espace de mémoire de JSF
    			User user = (User) ((HttpServletRequest)request).getSession().getAttribute("loggedUser");
    			
    			// For the first application request there is no loginBean in the session so user needs to log in
    			// For other requests loginBean is present but we need to check if user has logged in successfully
    			if (user == null) {
    			    String contextPath = ((HttpServletRequest)request).getContextPath();
    			    ((HttpServletResponse)response).sendRedirect(contextPath + "/loginPage.xhtml");
    			}
    			else{
    				chain.doFilter(request, response);
    			}
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    			String contextPath = ((HttpServletRequest)request).getContextPath();
    		    ((HttpServletResponse)response).sendRedirect(contextPath + "/loginPage.xhtml");
    		}
    	}
        
             
    }
 
    public void init(FilterConfig config) throws ServletException {
        // Nothing to do here!
    }
 
    public void destroy() {
        // Nothing to do here!
    }   
     
}