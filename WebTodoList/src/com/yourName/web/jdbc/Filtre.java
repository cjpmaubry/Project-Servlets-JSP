package com.yourName.web.jdbc;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class Filtre
 */
@WebFilter(urlPatterns="/*")
public class Filtre implements Filter {

    /**
     * Default constructor. 
     */
    public Filtre() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		//Cast 
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpServletRequest request = (HttpServletRequest) req;
		
		// Here it is restriction about cache to avoid previous button on the navigator.
		// Improve security
		HttpSession session = request.getSession();
		response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
    	response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
    	response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
    	response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
    	
    	//if to avoid loop of the filter
    	if(request.getRequestURI().equals("/WebTodoList/UserControllerServlet"))
    	{
    		
    	}
    	else
    	{
    	// Redirection 
   	 if ( (session.getAttribute( "SessionUser" )==null )) {req.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);}
		
    	}
		// pass the request along the filter chain
		chain.doFilter(req, resp);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
