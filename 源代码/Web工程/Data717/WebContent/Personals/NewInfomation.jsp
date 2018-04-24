<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/Data717/css/Login.css" />
<title>Insert title here</title>
</head>
<style>

		   .table1{                            /*边框*/
				border-collapse: collapse;
				border: 1px solid red;
				width: 680px;
			}
			.center caption{                  /*标题字*/
				text-align: left;
				font-size:15px;
				font-weight: bold;
			}
			.table1 td{
				border: 1px solid grey;
				text-align:center;
			}
			.table1 tr:nth-child(2n){
				background-color: rgb(214, 223, 220);
			}
			.table1 .tr1{
				background-color:rgb(165, 184, 192) ;
				font-size:18px;
			}
			
			.table2{                            /*边框*/
				border-collapse: collapse;
				border: 1px solid red;
				width: 680px;
			}
            .table2 td{
				border: 1px solid grey;
				text-align: center;
			}
			.table2 tr:nth-child(2n){
				background-color: rgb(214, 223, 220);
			}
			.table2 .tr1{
				background-color:rgb(165, 184, 192) ;
				font-size:18px;
			}
			
</style>
<body>
		<div class="center">
			<div class="titletop">个人中心&gt;<a href="#">最新通知</a></div>
			<br />
			<table class="table1">
				<caption>
					未来七天的会议
				</caption>
				<tr class="tr1">
					<td>会议名称</td>
					<td>会议地点</td>
					<td>开始时间</td>
					<td>结束时间</td>
					<td >操作</td>
				</tr>
			</table>
			<br />
			<table class="table2">
				<caption>
					已取消的会议
				</caption>
				<tr class="tr1">
					<td>会议名称</td>
					<td>会议地点</td>
					<td>开始时间</td>
					<td>结束时间</td>
					<td>操作</td>
				</tr>
			</table>
		</div>
</body>
</html>