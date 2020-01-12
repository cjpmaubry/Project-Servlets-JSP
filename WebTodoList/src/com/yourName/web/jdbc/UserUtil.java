package com.yourName.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class UserUtil {
	
private DataSource dataSource;
	
	public UserUtil(DataSource theDataSource) { 
		dataSource = theDataSource; 
	}

	public int Verifuser(User utilisateur) throws Exception { 

		Connection myConn=null;
		Statement myStmt = null;
		ResultSet myRs= null;
		int res =0;
		try {
			myConn = dataSource.getConnection();
			myStmt= myConn.createStatement();
			String sql= "select * from users order by username";
			myRs = myStmt.executeQuery(sql);

			while(myRs.next()){

				String username = myRs.getString("username");
				String password =myRs.getString("password");
				String role = myRs.getString("role");
				if( utilisateur.getUsername().equals(username) && utilisateur.getPassword().equals(password))
				{		
					if (role.equals("student"))
					{
						res=1;
					}
					else
					{
						res=2;
					}
				}
 
			}
			
			
			
			
		}
		finally{
	close(myConn,myStmt,myRs);
	
	}
		return res;
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
	
	
}
