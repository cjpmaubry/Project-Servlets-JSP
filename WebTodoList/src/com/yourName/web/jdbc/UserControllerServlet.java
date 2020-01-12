package com.yourName.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;


/**
 * Servlet implementation class UserControllerServlet
 */

@WebServlet("/UserControllerServlet")
public class UserControllerServlet extends HttpServlet {

private static final long serialVersionUID = 1L;

private UserUtil userUtil;

@Resource(name="jdbc/projet1java") 
private DataSource dataSource;

	
@Override
public void init() throws ServletException {
	// TODO Auto-generated method stub
	super.init();
	userUtil = new UserUtil(dataSource);
}


protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	Cookie [] cookies = request.getCookies();
	if(cookies!= null){ 
		for(Cookie cookie:cookies){		
			if(cookie.getName().equals("Cusername"))
			{
				request.setAttribute("Cusername", cookie.getValue());
			}		
	}	
}	
	request.getRequestDispatcher("/login.jsp").forward(request, response); 
}


protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
ServletException, IOException {	
	String fn= req.getParameter("username");
	String ln= req.getParameter("password");
	User user = new User(fn,ln);
	Cookie cookie = new Cookie("Cusername", fn);
	cookie.setMaxAge(60*60); // in seconds, here for 24 hours response.addCookie(cookie) ; 
	resp.addCookie(cookie);
	HttpSession session = req.getSession();
	try {
		int verif= userUtil.Verifuser(user);
		session.setAttribute( "SessionUser", verif );
		session.setAttribute( "User", fn );

		if(verif==0)
		{
			req.getRequestDispatcher("/login-error.jsp").forward(req, resp);
		}
		if(verif==1)
		{
			resp.sendRedirect("TodoControllerStudentServlet");
		}
		if(verif==2)
		{
			resp.sendRedirect("TodoControllerProfServlet");
		}	
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}	
}


}

