<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="/Data717/css/Login.css" />
</head>
<body>
	<div class="center">
		<div>登录</div>
		<br />
		<form action="${pageContext.request.contextPath }/Login.login" method="post"  target="_top">
			<fieldset>
				<legend class="legent">
					<strong>登录信息</strong>
				</legend>
				<table height="100px">
					<tr>
						<td width="70px">用户名：</td>
						<td><input type="text"  name="username"/></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><input type="password" name="password" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="登录" /></td>
						<td><input type="button" value="返回" onclick="#" /></td>
					</tr>
				</table>
			</fieldset>
		</form>
		<div style="float:center;text-align:center">
		<a>没账号？请点击</a>
		<a href="${pageContext.request.contextPath }/Enroll.jsp" style="text-decoration:none" target="_top">点击注册</a>
		</div>
	</div>
</body>
</html>