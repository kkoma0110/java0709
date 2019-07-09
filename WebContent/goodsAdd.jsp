<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="goods.do?method=add" method="post">
		商品名称:<input name="gname" />
		商品价格:<input name="gprice"/>
		库存数量:<input name="quantity" />
		商品图片:<input name="gphoto"/>
		商品描述:<input type="text" name="gdesc" />
		商品类型:<input name="gtype" />
		<button>提交</button>
		<button type="reset">重置</button>
	</form>

</body>
</html>