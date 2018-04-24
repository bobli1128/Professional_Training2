<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/Data717/css/Login.css" />
</head>
<body>
<div class="center">
		<div>人员管理&gt;<strong>修改密码</strong>></div>
		<br/>
			<form action="${pageContext.request.contextPath }/PasswordChange.do" method="post" target="_top">
				<fieldset>
					<legend>修改密码</legend>
					<table>
					    <tr>
							<td>用户标识： </td>
							<td><input type="text" name="UI_ID" value="${UserInfo.UI_ID }" readonly="readonly"></td>
						</tr>
						
						<tr>
							<td>旧密码： </td>
							<td><input type="password" name="oldpwd"></td>
						</tr>
						<tr>
							<td>新密码：   </td>
							<td><input type="password" placeholder="请输入6位以上的密码" name="newpassword"></td>
						</tr>
						<tr>
							<td>确认密码： </td>
							<td><input type="password" name="newpasswordAgain"></td>
						</tr>
						<tr>
							<td><input type="submit" value="修改"/></td>
				       		<td><input type="button" value="取消"/></td>
						</tr>
					</table>
				</fieldset>
			</form>
	</div>
</body>
</html>