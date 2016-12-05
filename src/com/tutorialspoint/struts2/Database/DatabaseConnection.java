package com.tutorialspoint.struts2.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DatabaseConnection {
	private Connection con=null;
	private static final String DBDRIVER="com.mysql.jdbc.Driver";
	private static final String DBURL="jdbc:mysql://localhost:8889/MyData?characterencoding=utf8";
	public DatabaseConnection() throws Exception{
	    try {  
	      Class.forName(DBDRIVER);     //加载MYSQL JDBC驱动程序     
	     
	     System.out.println("Success loading Mysql Driver!");  
	    }  
	    catch (Exception e) {  
	      System.out.print("Error loading Mysql Driver!");  
	      e.printStackTrace();  
	    }  
	    
	      try {
			this.con = DriverManager.getConnection(  
			      DBURL,"root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
}
	public Connection getConnection() throws Exception {
		return this.con;
	}
}