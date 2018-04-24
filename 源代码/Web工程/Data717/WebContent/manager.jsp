<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
				width: 680px;
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
			}
			</style>
<body>
		<div class="center">
			<div class="titletop">管理员&gt;联系管理员</div>
			<br />
			<table class="table1">
				<caption>
					联系方式
				</caption>
				<tr class="tr1">
					<td>管理员姓名</td>
					<td>电话</td>
					<td>邮箱</td>
				</tr>
				<tr>
					<td>李雪</td>
					<td>15897653467</td>
					<td>182736908@qq.com</td>
				</tr>
				<tr>
					<td>李青青</td>
					<td>13398763456</td>
					<td>23435435@qq.com</td>
				</tr>
				<tr>
					<td>沐春阳</td>
					<td>13398762345</td>
					<td>2324343@qq.com</td>
				</tr>
			</table>

</div>
</body>
</html>