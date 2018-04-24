<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>chakan rooom</title>
<link rel="stylesheet" type="text/css" href="/Data717/css/Login.css" />
</head>
<body>
	<div class="center">
		<div class="">
			会议预定&gt;<a href="#">查看会议室</a>
		</div>
		<br /> <br />
		<table border="1" class="table">
			<caption class="caption">所有会议室</caption>
			<tr class="tr1" align="center">
				<td>门牌编号</td>
				<td>会议室名称</td>
				<td>容纳人数</td>
				<td>当前状态</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${rooms }" var="room">
			<tr style="height: 25px">
				<td>${room.MR_ADDRESS }</td>
				<td>${room.MR_NAME }</td>
				<td>${room.MR_COUNT }</td>
				<td>${room.MR_STATUS }</td>
				<td><a href="${pageContext.request.contextPath }/MRinfo/showdetail.do?id=${room.MR_ID }" class="clickbutton">查看详情</a></td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>