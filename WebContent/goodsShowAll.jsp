<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="LoginAndRegister.jsp" %>

	<form action="goodsAdd.jsp" method="post">
		<table style="width:800px align:center">
			<tr>
				<td>序号</td>
				<td>商品名称</td>
				<td>商品价格</td>
				<td>库存数量</td>
				<td>商品照片</td>
				<td>商品描述</td>
				<td>商品类型</td>
				<td>编辑</td>
				<td>删除</td>			
			</tr>
			<c:forEach items="${gs }" var="g" varStatus="i">
				<tr>
					<td>${i.index+1 }</td>
					<td>${g.gname }</td>
					<td>${g.gprice }</td>
					<td>${g.quantity }</td>
					<td>${g.gphoto }</td>
					<td>${g.gdesc }</td>
					<td>${g.gtype }</td>
					<td><a href="goods.do?method=updateForm&&gid=${g.gid }">编辑</a></td>
					<td><a href="goods.do?method=delete&&gid=${g.gid }">删除</a></td>	
				</tr>
			</c:forEach>
			<tr>
				<td>
					<button>添加商品</button>
				</td>
			</tr>
		</table>	
	</form>


</body>
</html>