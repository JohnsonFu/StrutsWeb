package com.tutorialspoint.struts2.action;

import javax.servlet.FilterConfig;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.tutorialspoint.struts2.Database.DatabaseConnection;
import com.tutorialspoint.struts2.dao.UserDAO;

public class LoginAction extends ActionSupport{
private String account;
private String password;
private DatabaseConnection db;
private UserDAO dao;

public String login() throws Exception{
	db=new DatabaseConnection();
	dao=new UserDAO(db);
	if(dao.Login(account, password)){
	//if("test".equalsIgnoreCase(account)&&"test".equalsIgnoreCase(password)){
		return SUCCESS;
	}
	return LOGIN;
}
public String getAccount() {
	return account;
}
public void setAccount(String account) {
	this.account = account;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}



}
