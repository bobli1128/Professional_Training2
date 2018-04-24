<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/Data717/css/Login.css" />
<title>我的会议</title>

</head>
		<style>
		   .centerright{
		        margin-left: 0px;
		   }
		   .table1{                            /*边框*/
				border-collapse: collapse;
				border: 1px solid red;
				width: 720px;
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
				background-color:#85c7c4 ;
				font-size:18px;
			}
			</style>
<body>
		<div class="center">
			<div class="titletop">个人中心&gt;我要参加的会议&gt;查看详情</div>
			<br />
			<table class="table1">
				<caption>
					详情
				</caption>
				<tr class="tr1">
					<td>会议名称</td>
					<td>会议室名称</td>
					<td>会议开始时间</td>
					<td>会议结束时间</td>
					<td>会议内容</td>
					<td>申请人</td>
					<td>操作</td>
				</tr>
				<tr>
					<td>${meetings.MI_TITLE}</td>
					<td>${meetings.MI_ROOM}</td>
					<td>
						<fmt:formatDate value="${meetings.MI_START_TIME} type="both"/>
					</td>
					<td>
						<fmt:formatDate value="${meetings.MI_END_TIME} type="both"/>
					</td>
					<td>${meetings.MI_CONTENT}</td>
					<td>${meetings.MI_ORDER}</td>
					<td><a href="${pageContext.request.contextPath }/MyMeetings.do">返回</a></td>
				</tr>
			</table>
			
		</div>
</body>
</html>