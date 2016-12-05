<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书籍列表</title>
</head>
<body>
<a href="add.jsp">添加书籍</a>
<a href="showlist.action">书籍列表</a><br>
<table border="1">
<tr>
<th>书名</th>
<th>作者</th>
<th>价格</th>
<th>删除</th>
</tr>
<s:iterator id="item" value="booklist">
<tr>
<s:form action="remove">
<th><input type="hidden" name="bookname" value=<s:property  value='#item.name'/>>${item.name}</th>
<th><s:label >${item.author}</s:label></th>
<th><s:label >${item.price }</s:label></th>
<th><s:submit type="button"  value="删除"/></th>
</s:form>
</tr>

</s:iterator>
</table>
</body>
</html>