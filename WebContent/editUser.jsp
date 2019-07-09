<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="userServlet.do?method=edit" method="post">
		<input name="uid" type="hidden" value="${user.uid }"> 用户名：<input
			name="uname" value="${user.uname }"><br> 密码：<input
			name="password" type="password" value="${user.password }"><br>
		<button>提交</button>
		<button type="reset">重置</button>
	</form>
</body>
</html>