<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<form action="typeServlet.do?method=change" method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="tid" value="${type.tid }" /><br /> tname:<input
			type="text" name="tname" value="${type.tname }" /><br /> tphoto:<input
			type="file" name="tphoto" value="${type.tphoto }" /><br /> tdesc:<input
			type="text" name="tdesc" value="${type.tdesc }" /><br />
		<button>添加</button>
	</form>

</body>
</html>