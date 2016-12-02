package com.tutorialspoint.struts2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class database {
	private Connection conn;
	public database(){
		 try {  
		      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序     
		      //Class.forName("org.gjt.mm.mysql.Driver");  
		    // System.out.println("Success loading Mysql Driver!");  
		    }  
		    catch (Exception e) {  
		      System.out.print("Error loading Mysql Driver!");  
		      e.printStackTrace();  
		    }  
		    try {  
		       conn = DriverManager.getConnection(  
		          "jdbc:mysql://localhost:3306/new_schema","root","");  }
		    catch (Exception e) {  
			      System.out.print("get data error!");  
			      e.printStackTrace();  
			    } 
		    
	}
	
	public boolean login(String username,String password) throws SQLException{
		//Statement stmt = conn.createStatement(); 
		//String sql="select userid from user where userid='"+username+"' and password='"+passwords+"'";
		String sql="select * from user where userid=? and password=?";
		PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);
		ResultSet result=ps.executeQuery();
		
		int rowCount=0;
		while(result.next())      
		 {      
		     rowCount++;      
		 }    
		if(rowCount>=1){
			return true;
		}else{
			return false;
		}
	}
	
//public static void main(String args[]) {  
		//database db=new database();
	//	try {
		//	System.out.println(db.login("627922981","mangguo"));
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		
	    
//}
}