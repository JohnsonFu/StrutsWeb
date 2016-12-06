package com.tutorialspoint.struts2.action;

import javax.servlet.FilterConfig;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.tutorialspoint.struts2.Database.DatabaseConnection;
import com.tutorialspoint.struts2.dao.UserDAO;

public class LoginAction extends ActionSupport{
private User user=new User();;
private UserService service;
public String login() throws Exception{
	if(service.login(user)){
	//if("test".equalsIgnoreCase(account)&&"test".equalsIgnoreCase(password)){
		return "success";
	}
	return "fail";
}
public UserService getService() {
	return service;
}
public void setService(UserService service) {
	this.service = service;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}




}
