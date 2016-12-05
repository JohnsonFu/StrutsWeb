package com.tutorialspoint.struts2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;
import com.tutorialspoint.struts2.Database.DatabaseConnection;
import com.tutorialspoint.struts2.dao.UserDAO;

public class BookAction  extends ActionSupport implements ServletContextAware,ServletRequestAware,SessionAware {
public static List<Book> booklist=new ArrayList<Book>();
private Book book=new Book();
private HttpServletRequest request;
private ServletContext application;
private Map<String,Object> session;
private DatabaseConnection db;
private UserDAO dao;
private String test;
public BookAction(){
	try {
		db=new DatabaseConnection();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	dao=new UserDAO(db);
}
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
   dao.addBook(book);
	return "list";
}
public String list(){
	return "list";
}

public String remove() throws SQLException{
	//String name=request.getParameter("names");
	dao.delete(book.getName());
	return "list";
}
public String modify(){
	return "modify";
}
public String update() throws SQLException{
	dao.update(book);
	return "list";
}

public List<Book> getBooklist() throws SQLException{
	this.booklist=dao.getBooks();
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

}
