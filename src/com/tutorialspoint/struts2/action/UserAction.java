package com.tutorialspoint.struts2.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterConfig;
import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tutorialspoint.struts2.Database.DatabaseConnection;
import com.tutorialspoint.struts2.dao.UserDAO;

public class UserAction extends ActionSupport{
private User user=new User();
private List<Book>booklist;
private UserService service;
private String message;
private Book book=new Book();
public String login() throws Exception{
	if(service.login(user)){
		
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

public String buy(){

	if(!service.buy()){
	ServletActionContext.getRequest().setAttribute("message", "该商品已存在购物车中");
	}else{
		ServletActionContext.getRequest().removeAttribute("message");
	}
	return "success";
}

public List<Book> getBooklist() {
	booklist=service.getList();
	return booklist;
}
public void setBooklist(List<Book> booklist) {
	this.booklist = booklist;
}
public Book getBook() {
	return book;
}
public void setBook(Book book) {
	this.book = book;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}


}
