<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="goods.do?method=exit" method="post">
		<input type="hidden" name="gid" value="${g.gid }"/>
		商品名称:<input name="gname" value="${g.gname }"/>
		商品价格:<input name="gprice" value="${g.gprice }"/>
		库存数量:<input name="quantity" value="${g.quantity }" />
		商品图片:<input name="gphoto" value="${g.gphoto }"/>
		商品描述:<input type="text" name="gdesc" value="${g.gdesc }" />
		商品类型:<input name="gtype" value="${g.gtype }" />
		<button>提交</button>
		<button type="reset">重置</button>
	</form>

</body>
</html>