package com.tutorialspoint.struts2.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener{
public void sessionCreated(HttpSessionEvent se){
	System.out.println("新创建了一个session");
}
}
