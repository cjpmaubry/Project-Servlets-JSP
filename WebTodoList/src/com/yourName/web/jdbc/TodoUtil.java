package com.yourName.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class TodoUtil {
	
private DataSource dataSource;
	
	public TodoUtil(DataSource theDataSource) { 
		dataSource = theDataSource; 
	}

	public List<Todo> gettodos() throws Exception { 
		List<Todo> todos= new ArrayList<Todo>();
	
		Connection myConn=null;
		Statement myStmt = null;
		ResultSet myRs= null;

		try {
			myConn = dataSource.getConnection();
			myStmt= myConn.createStatement();
			String sql= "select * from todos order by id";
			myRs = myStmt.executeQuery(sql);

			while(myRs.next()){
				int id = myRs.getInt("id");
				String description=myRs.getString("description");
				
				
			Todo temptodo= new Todo(id,description);
			todos.add(temptodo); 
			}
			
			return todos;
			
} finally{
	close(myConn,myStmt,myRs);
	
}
			
}
	
	
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try{
			if(myStmt!=null)
				myStmt.close();
			if(myRs!=null)
				myRs.close();
			if(myConn!=null)
				myConn.close();
			}catch(Exception e){
				System.out.println(e.getMessage()); 
			}
}

	
	public void deleteTodo(int id) {
		// TODO Auto-generated method stub
		Connection myConn=null; Statement myStmt = null;
		try {
			myConn = dataSource.getConnection();
			myStmt= myConn.createStatement();
			String sql= "delete from todos where id="+id;
			myStmt.execute(sql);
			}catch(Exception e){
				System.out.println(e.getMessage());
		} finally{ close(myConn,myStmt,null); }
}
		
	
	public Todo fetchtodo(int id) { Connection myConn=null; Statement myStmt = null; ResultSet myRs= null; Todo todo=null;
	try {
	myConn = dataSource.getConnection(); myStmt= myConn.createStatement(); String sql= "select * from student where id="+id; myRs = myStmt.executeQuery(sql);
	while(myRs.next()){ String description = myRs.getString("description");
	todo = new Todo(id,description);
	}
	return todo; }catch(Exception e){ System.out.println(e.getMessage()); return null;
	} finally{ close(myConn,myStmt,myRs);
	}
	}
	
	
	public void addTodo(Todo todo){ 
		Connection myConn=null;
		PreparedStatement myStmt = null;
	ResultSet myRs= null;
	try {
	myConn = dataSource.getConnection();
	String sql = "INSERT INTO Todos (description) "
			+ "VALUES (?)";
	myStmt = myConn.prepareStatement(sql);
	String description = todo.getDescription();
	myStmt.setString(1, description);
	myStmt.execute();
	} catch(Exception e){
		System.out.println(e.getMessage());
		}
	finally{
		close(myConn,myStmt,myRs); 
		}
	}
	
	
	public void updateTodo(Todo todo) { Connection myConn=null; PreparedStatement myStmt = null;
	try {
	myConn = dataSource.getConnection();
	String sql = "update todos set description=? where id=?";
	myStmt = myConn.prepareStatement(sql);
	myStmt.setString(1, todo.getDescription());
	myStmt.setInt(2,todo.getId());
	myStmt.execute();
	} catch(Exception e){ System.out.println(e.getMessage()); }
	finally{ close(myConn,myStmt,null); }
	} 
	
	
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		Connection myConn=null; Statement myStmt = null;
		try {
			myConn = dataSource.getConnection();
			myStmt= myConn.createStatement();
			String sql= "delete from student where id="+id;
			myStmt.execute(sql);
			}catch(Exception e){
				System.out.println(e.getMessage());
		} finally{ close(myConn,myStmt,null); }}
	
	

}


