package com.tutorialspoint.struts2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;
import com.tutorialspoint.struts2.dao.BaseDao;
import com.tutorialspoint.struts2.dao.UserDAO;

public class BookSpringAction  extends ActionSupport implements ServletContextAware,ServletRequestAware,SessionAware {
public static List<Book> booklist=new ArrayList<Book>();
private Book book=new Book();
private HttpServletRequest request;
private ServletContext application;
private Map<String,Object> session;
private UserDAO dao;
private String test;
private BaseDao basedao;
private IBookService service;
public String Add(){
	return "add";
}
public Book getBook() {  
    return book;  
}  

public void setBook(Book book) {  
    this.book = book;  
}  
public String add() throws SQLException{
  service.createBook(book);
  booklist=service.listBook();
	return "list";
}
public String list() throws SQLException{
	booklist=service.listBook();
	return "list";
}

public String remove() throws SQLException{
	//String name=request.getParameter("names");
	service.Remove(book);
	booklist=service.listBook();
	return "list";
}
public String modify(){
	return "modify";
}
public String update() throws SQLException{
	service.update(book);
	booklist=service.listBook();
	return "list";
}

public List<Book> getBooklist() throws SQLException{
	return booklist;
}
@Override
public void setSession(Map<String, Object> arg0) {
	// TODO Auto-generated method stu
	this.session=arg0;
}
@Override
public void setServletRequest(HttpServletRequest arg0) {
	// TODO Auto-generated method stub
	this.request=arg0;
	
}
@Override
public void setServletContext(ServletContext arg0) {
	// TODO Auto-generated method stub
	this.application=arg0;
	
}
public IBookService getService() {
	return service;
}
public void setService(IBookService service) {
	this.service = service;
}

}