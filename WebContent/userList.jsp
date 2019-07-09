<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width=800>
		<tr>
			<th>序号</th>
			<th>用户名</th>
			<th>密码</th>
			<th>编辑</th>
			<th>删除</th>
		</tr>
		<c:forEach items="${users }" var="u" varStatus="i">
			<tr>
				<th>${i.index+1 }</th>
				<th>${u.uname}</th>
				<th>${u.password }</th>
				<th><a href="userServlet.do?method=getUser&uid=${u.uid }">编辑</a></th>
				<th><a href="userServlet.do?method=delete&uid=${u.uid }">删除</a></th>
			<tr>
		</c:forEach>
	</table>
	<button onclick="location.href='addUser.jsp'">添加用户</button>
</body>
</html>