<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" class="table">
					<caption>查询结果</caption>
					<tr class="tr1"> 
						<td>姓名</td>
						<td>账户名</td>
						<td>联系电话</td>
						<td>电子邮箱</td>
						<td>操作</td>	
					</tr>
					<c:forEach items="${SearchUser }" var="SUser">
			<tr style="height: 25px">
				<td>${SUser.UI_NAME }</td>
				<td>${SUser.UI_ACCOUNT }</td>
				<td>${SUser.UI_TEL }</td>
				<td>${SUser.UI_EMAIL }</td>
				<td><a href="" class="clickbutton">查看详情</a></td>
			</tr>
			</c:forEach>
				</table>
</body>
</html>