package com.yourName.web.jdbc;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class EditTodoServlet
 */
@WebServlet("/EditTodoServlet") 
public class EditTodoServlet extends HttpServlet { 
	
private static final long serialVersionUID = 1L;

private TodoUtil todoUtil;

@Resource(name="jdbc/projet1java")
private DataSource dataSource;

int id;

@Override public void init() throws ServletException {
	super.init();
	todoUtil = new TodoUtil(dataSource);
	}

    public EditTodoServlet() { 
    	super();        
    	// TODO Auto-generated constructor stub
    	}
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
    ServletException, IOException {
    		    	
    	id=Integer.parseInt(request.getParameter("todoId"));
    	Todo todo= todoUtil.fetchtodo(id);
    	request.setAttribute("Todo", todo);
    	request.getRequestDispatcher("edit-todos.jsp").forward(request, response);
    	} 
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    	String description= request.getParameter("description");
    	Todo todo = new Todo(id,description);
    	System.out.println(todo.toString());
    	todoUtil.updateTodo(todo);
    	response.sendRedirect("TodoControllerProfServlet");
    	}


}

