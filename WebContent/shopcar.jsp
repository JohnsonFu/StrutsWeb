<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
<th>书名</th>
<th>作者</th>
<th>价格</th>
<th>添加</th>
<th>编辑</th>
</tr>
<s:iterator id="item" value="#session.shopcar">
<tr>
<s:form action="useredit">
<th><input type="hidden" name="book.name" value=<s:property  value='#item.name'/>>${item.name}</th>
<th><input type="hidden" name="book.author" value=<s:property  value='#item.author'/>>${item.author}</th>
<s:if test="#item.price>50"><th style="color:red"></s:if><s:else><th></s:else><input type="hidden" name="book.price" value=<s:property  value='#item.price'/>>${item.price }</th>
<th><s:submit type="button" method="buy"  value="添加"/></th>
<th><s:submit type="button" method="modify"  value="编辑"/></th>
</s:form>
</tr>

</s:iterator>
</table>


</body>
</html>