package com.yourName.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class TodoControllerProfServlet
 */
@WebServlet("/TodoControllerProfServlet") 
public class TodoControllerProfServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
private TodoUtil todoUtil;

@Resource(name="jdbc/projet1java") 
private DataSource dataSource;
	

@Override
public void init() throws ServletException {
	// TODO Auto-generated method stub
	super.init();
	todoUtil = new TodoUtil(dataSource);
}


protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {

	 HttpSession session = request.getSession();
     if ( (session.getAttribute( "SessionUser" ).equals(2) )) {
    	 /* Display page if teacher are connected */
    	 try {
			listTodo(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
				}
     }
     else {   
    	 /* Redirection */
    	 request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
         		
		}
}
     
private void listTodo(HttpServletRequest request, HttpServletResponse response) 
		throws Exception{
List<Todo> todos = todoUtil.gettodos();
request.setAttribute("TODO_LIST", todos);
RequestDispatcher dispatcher = request.getRequestDispatcher("/list-todos-prof.jsp");
dispatcher.forward(request, response); 
}




protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
ServletException, IOException {
	
	HttpSession session = req.getSession();
    if ( (session.getAttribute( "SessionUser" ).equals(2) )) {
	System.out.println(3);
	String fn= req.getParameter("description");
	if(fn!=null)
	{
	Todo todo = new Todo(fn);
	todoUtil.addTodo(todo);
	}
	try { listTodo(req,resp);
	} catch (Exception e) { 
		// TODO Auto-generated catch block 
		e.printStackTrace(); }
    }
}


}
