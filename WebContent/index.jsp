<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登录</title>
</head>
<body>
   <h1>登录</h1>
   <form action="login">
      <label for="name">登录界面</label><br/>
      账户名<input type="text" name="username"/><br>
      密码<input type="text" name="password"/>
      <input type="submit" value="登录"/>
   </form>
</body>
</html>