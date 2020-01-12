package com.yourName.web.jdbc;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class DeleteTodoServlet
 */
@WebServlet("/DeleteTodoServlet")
public class DeleteTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TodoUtil todoUtil;
	
@Resource(name="jdbc/projet1java")
private DataSource dataSource;

@Override
public void init() throws ServletException {
	super.init();
	todoUtil = new TodoUtil(dataSource);
	}
 
protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	
	HttpSession session = request.getSession();
	if ( (session.getAttribute( "SessionUser" ).equals(2) )) 		 
		 {
int id=Integer.parseInt(request.getParameter("todoId"));
todoUtil.deleteTodo(id);
response.sendRedirect("TodoControllerProfServlet");
		 }
} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}