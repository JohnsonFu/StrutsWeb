package com.tutorialspoint.struts2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class LoginAction{
private String username;
private String password;

	
	
	public String execute() throws Exception{
	database db=new database();
	if(db.login(username, password)){
	return "登陆成功";
	}else{
		return "登录失败";
	}
}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
}
