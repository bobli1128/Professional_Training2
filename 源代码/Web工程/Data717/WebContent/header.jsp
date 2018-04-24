                                                                                                       <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>name</title>
<link rel="stylesheet" type="text/css" href="/Data717/css/Login.css" />
</head>
<body>
	<div class="header_1">
		<div class="header_2">
			<img src="img/header.png" width="180px" height="80px"
				alt="cool meeting">
		</div>
		<div class="header_3">
			<font size="6px" face=charcoal>欢迎来访cool_meeting会议管理系统</font>
		</div>
		<div class="header_4">
			<font size="2px">欢迎您，<strong>${UserInfo.UI_NAME }</strong> &nbsp;
			<a href="/Data717/Personals/ChangePasswords.jsp" target="ContentFrame" style="text-decoration:none" >[修改密码]</a>
			<a href="${pageContext.request.contextPath }/Logout.do" target="_top" style="text-decoration:none" >[退出]</a></font>
		</div>
	</div>
</body>
</html>