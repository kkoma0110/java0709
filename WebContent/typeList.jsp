<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<table width="100%" border="1">
		<tr>
			<th>序号</th>
			<th>名称</th>
			<th>图片</th>
			<th>描述</th>
			<th>编辑</th>
			<th>删除</th>
		</tr>

		<c:forEach items="${typeList }" var="type" varStatus="i">

			<tr>
				<th>${i.index+1 }</th>
				<th>${type.tname }</th>
				<th><img src="${type.tphoto }" width="100px" heigth="75px" /></th>
				<th>${type.tdesc }</th>
				<th><a href="typeServlet.do?method=edit&tid=${type.tid }">编辑</a></th>
				<th><a href="typeServlet.do?method=delete&tid=${type.tid }">删除</a></th>
			</tr>

		</c:forEach>

	</table>
	<button onclick="location.href='addType.jsp'">添加商品类型</button>
</body>
</html>