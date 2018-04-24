<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的預定</title>
<link rel="stylesheet" type="text/css" href="/Data717/css/Login.css" />
<style>
		   .centerright{
		        margin-left: 0px;
		   }
		   
		   .table1 {
	border-collapse: collapse;
	border: 1px solid rgb(165, 184, 192);
	width: 800px;
}
			.center caption{                  /*标题字*/
				text-align: left;
				font-size:15px;
				font-weight: bold;
			}
			.table1 td{
				border: 1px solid grey;
				text-align: center;
			}
			/*.table1 tr:nth-child(2n){
				background-color: #ebeaea;
			}*/                                                                                                                                                                               
			.table1 .tr1{
				background-color:skyblue ;
			}
			.table {
	border-collapse: collapse;
	border: 1px solid red;
	width: 700px;
}

.caption {
	text-align: left;
	font-size: 16px;
	font-weight: 300;
}

.table td {
	border: 1px solid gray;
	text-align: center;
	font-size: 5px;
}

.table tr:nth-child(2n) {
	background-color: darkslateblue;
}

.tr1 {
	background-color: #2F4F4F;
	font-size: 10px;
	height: 30px;
}

.clickbutton {
	border: 1px solid black; padding 0 8px;
	text-align: center;
	color: black;
	text-decoration: none;
}
</style>
</head>
<body>
	<div class="center">
		<div class="centerright">
			<div class="titletop">个人中心&gt;<a href="${pageContext.request.contextPath }/MRApplyInfo/show.do">我的预定</a></div>
			<br />
			<table class="table1">
				<caption>
					我预定的会议>
				</caption>
				<tr class="tr1">
					<td>会议名称</td>
					<td>会议室名称</td>
					<td>会议开始时间</td>
					<td>会议结束时间</td>
					<td>会议预定时间</td>
					<td>预订者</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${mrainfo }" var="mra">
					<tr style="height: 25px">
						<td>${mra.MI_TITLE }</td>
						<td>${mra.MI_ROOM}</td>
						<td>
							<fmt:formatDate value="${mra.MI_START_TIME }" type="both"/>
						</td>
						<td>
							<fmt:formatDate value="${mra.MI_END_TIME }" type="both"/>
						</td>
						<td>
							<fmt:formatDate value="${mra.MI_BOOK_TIME }" type="both"/>
						</td>
						<td>${mra.MI_ORDER }</td>
						<td><a href="${pageContext.request.contextPath }/MRApplyInfo/showdetail.do?id=${mra.MI_ID}">查看</a>/
						<a href="${pageContext.request.contextPath }/MRApplyInfo/delete.do?id=${mra.MI_ID}"
						onclick="return confirm('是否撤銷該會議？')">撤銷</a></td>
					</tr>
				</c:forEach>
			</table>
			
		</div>
	</div>
</body>
</html>