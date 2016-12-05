package com.tutorialspoint.struts2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tutorialspoint.struts2.Database.DatabaseConnection;
import com.tutorialspoint.struts2.action.Book;

public class UserDAO {
private Connection con=null;
public UserDAO(DatabaseConnection db){
	try {
		this.con=db.getConnection();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public boolean Login(String account,String password) throws SQLException{
	 PreparedStatement pstmt=null;
	 boolean flag=false;
	String sql="select name from user where userid=? and password=?";
	pstmt=this.con.prepareStatement(sql);
	pstmt.setString(1,account);
	pstmt.setString(2,password);
	ResultSet rs=pstmt.executeQuery();
	if(rs.next()){
		flag=true;
	}
	return flag;
}
public void addBook(Book book) throws SQLException{
	 PreparedStatement pstmt=null;
	String sql="insert into booklist(name,author,price) values(?,?,?)";
	pstmt=this.con.prepareStatement(sql);
	pstmt.setString(1,book.getName());
	pstmt.setString(2,book.getAuthor());
	pstmt.setDouble(3,book.getPrice());
	pstmt.executeUpdate();
}

public void delete(String bookname) throws SQLException{
	 PreparedStatement pstmt=null;
		String sql="delete from booklist where name=?";
		pstmt=this.con.prepareStatement(sql);
		pstmt.setString(1,bookname);
		pstmt.executeUpdate();
}

public List<Book> getBooks() throws SQLException{
	ArrayList<Book> list=new ArrayList<Book>();
	 PreparedStatement pstmt=null;
		String sql="select * from booklist";
		pstmt=this.con.prepareStatement(sql);
		ResultSet result=pstmt.executeQuery();
	while(result.next()){
		Book book=new Book(result.getString("name"),result.getString("author"),result.getDouble("price"));
		list.add(book);
	}
	return list;
	}

}
