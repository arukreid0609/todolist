<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%
List<String> categories = (List<String>)request.getAttribute("categories");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<form action="Main" method="post">
		todo:<input type="text" name="todo"><br>
		category:
		<select name="category">
		<option value="new">新規作成</option>
		<% for(String c : categories){ %>
			<option value="<%=c%>"><%=c %></option>
		<% } %>
		</select><br>
		<input type="text" name="newCategory">
		<input type="submit" value="登録"><br>
	</form>
<%-- 	<% for(Todo todo : todoList){ %>
	<% } %>
 --%></body>
</html>