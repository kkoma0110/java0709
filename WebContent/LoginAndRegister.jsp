<link href="https://cdn.bootcss.com/twitter-bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/twitter-bootstrap/3.4.1/js/bootstrap.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<nav class="navbar navbar-default" style="margin-bottom: 0px;" >
	<div class="col-md-8 h4" style="height: 30px; line-height: 30px;">
		WoniuShop
	</div>
		<c:if test="${loginUser == null }">
			<div class="col-md-3 text-center h4" style="height: 30px; line-height: 30px;">
			<span class="glyphicon glyphicon-user"></span><a class="btn" id="login"> 登录</a> &nbsp;&nbsp;&nbsp;
			<span class="glyphicon glyphicon-log-in"></span><a class="btn" id="register"> 注册</a>
			</div>
		</c:if>
		<c:if test="${loginUser != null }">
			<div class="col-md-4 text-center h4" style="height: 30px; line-height: 30px;">
		 	<span class="glyphicon glyphicon-log-in"> <a>订单</a></span>
			<span class="glyphicon glyphicon-log-in"> <a>购物车</a></span>
			<span class="glyphicon glyphicon-user"></span><a class="btn" id="loginUser"> ${loginUser.uname }</a> &nbsp;&nbsp;&nbsp;
			<span class="glyphicon glyphicon-log-in"></span><a class="btn" id="exitUser"> 退出</a>
			</div>
		</c:if>
</nav>
<div id="modalLogin" class="modal">
	<div class="modal-dialog">
		<div class="col-md-10 modal-content">
			<div class="modal-header">
				登录
			</div>
			<div class="modal-body">
					<label>用&nbsp;户&nbsp;名</label>
					<div class="input-group">
						<span class="input-group-addon">
							<span class="glyphicon glyphicon-user"></span>
						</span>
						<input class="form-control" type="text" name="loginName" placeholder="请输入账号"><br>
					</div>
					<br>
					<label>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</label>
					<div class="input-group">	
						<span class="input-group-addon">
							<span class="glyphicon glyphicon-lock"></span>
						</span>
						<input class="form-control" type="password" name="loginKey"placeholder="请输入密码"><br>
					</div>
					<div class="text-right">
						<br>
						<button type="button" class="btn btn-success">登录</button>
						<button id="loginCancel" type="button" class="btn btn-danger">取消</button>	
					</div>
			</div>
		</div>
	</div>
</div>	
<div id="modalRegister" class="modal">
	<div class="modal-dialog">
		<div class="col-md-10 modal-content">
			<div class="modal-header">
				注册
			</div>
			<div class="modal-body">
					<label>请输入用户名</label>
					<div class="input-group">
						<span class="input-group-addon">
							<span class="glyphicon glyphicon-user"></span>
						</span>
						<input class="form-control" type="text" name="regName" placeholder="请输入账号"><br>
					</div>
					<br>
					<label>请输入密码</label>
					<div class="input-group">	
						<span class="input-group-addon">
							<span class="glyphicon glyphicon-lock"></span>
						</span>
						<input class="form-control" type="password" name="regKey1"placeholder="请输入密码"><br>
					</div>
					<br>
					<label>请再一次输入密码</label>
					<div class="input-group">	
						<span class="input-group-addon">
							<span class="glyphicon glyphicon-lock"></span>
						</span>
						<input class="form-control" type="password" name="regKey2"placeholder="请再次输入密码"><br>
					</div>
					<div class="text-right">
						<br>
						<button type="button" class="btn btn-success">注册</button>
						<button id="registerCancel" type="button" class="btn btn-danger">取消</button>	
					</div>
			</div>
		</div>
	</div>	
</div>
<nav class="navbar navbar-default navbar-fixed-bottom text-center">
	蜗牛创想科技-woniushop&copy; 版权所有	
</nav>
<script>
	$("#login").click(function(){
		$("#modalLogin").modal("show");
	});
	$("#loginCancel").click(function(){
		$("#modalLogin").modal("hide");	
		$("input[name='loginName']").val("");
		$("input[name='loginKey']").val("");
	});
	$("#register").click(function(){
		$("#modalRegister").modal("show");
	});
	$("#registerCancel").click(function(){
		$("#modalRegister").modal("hide");	
		$("input[name='regName']").val("");
		$("input[name='regKey1']").val("");
		$("input[name='regKey2']").val("");
	});
	$("button:contains('登录')").click(function(){
		$.post("login.do",
			{
				method:"login",	
				uname:$("input[name='loginName']").val(),
				password:$("input[name='loginKey']").val()
			},
			function(data){
				if(data == "true"){
					window.location.reload();
				}
				else if(data == "false"){
					alert("用户名或密码错误");
				}
			}, "text");	
	});	
	$("button:contains('注册')").click(function(){
		var key1 = $("input[name='regKey1']").val();
		var key2 = $("input[name='regKey2']").val();
		
		if(key1 == key2){
			$.post("login.do",
					{
						method:"reg",
						uname:$("input[name='regName']").val(),
						password:key1
					},
					function(data){
						var login = confirm("注册成功，是否登录");
						if(login == true){
						
							$.post("login.do",
									{
										method:"login",	
										uname:$("input[name='regName']").val(),
										password:key1
									},
									function(data){
										window.location.reload();
									}, "text");	
						}
						window.location.reload();
					}, "text");	
		}
		else {
			alert("两次密码不一致");
		}
	});
	
	$("a:contains('退出')").click(function(){
		$.post("login.do",
				{
					method:"out",	
				},
				function(data){
					window.location.reload();
				}, "text");	
	});
	
	
</script>
