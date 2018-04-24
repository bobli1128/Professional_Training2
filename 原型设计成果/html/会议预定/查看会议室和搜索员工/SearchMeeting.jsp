<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SearchMeetings</title>
<link rel="stylesheet" type="text/css" href="/Data717/css/Login.css" />
<script type="text/javascript" src="/Data717/js/jquery-1.6.js"></script>
<style>
.table {
	border-collapse: collapse;
	border: 1px solid red;
	width: 750px;
}

.caption {
	text-align: left;
	font-size: 16px;
	font-weight: 300px;
}

.table td {
	border: 1px solid gray;
	text-align: center;
	font-size:14px;
}

.table tr:nth-child(2n) {
	background-color: rgb(211,223,210);
	
}

.tr1 {
	background-color: rgb(221,221,221);
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
<script type="text/javascript">
$(function(){
        		$("input[name='MI_NAME']").blur(function(){	
        			var miname=$(this).val();
        			$.ajax({
        				type:"post",
        				url:"${pageContext.request.contextPath}/MeetingApplySearchbyMIName.do",
        				data:"miname="+miname,
        				success:function(result){
        					$(".tr1").nextAll().remove();
        					var objs=eval(result);
        					var l=objs;
        					alert(l.length);
        					$(objs).each(function(){
        						var trcontent="<tr><td>"+this.mi_NAME+"</td><td>"+this.mr_ADDRESS+
        						"</td><td>"+this.mi_START_TIME+"</td><td>"+this.mi_END_TIME+"</td><td>"+this.mi_BOOK_TIME+"</td><td>"
        						+this.ui_NAME+"</td><td><a href='#'>查看详情</a></td></tr>";
        						$(".tr1").after(trcontent);
        					});
        				}
        			});
        		});
        		$("input[name='MR_NAME']").blur(function(){	
        			var mrname=$(this).val();
        			$.ajax({
        				type:"post",
        				url:"${pageContext.request.contextPath}/MeetingApplySearchbyMRName.do",
        				data:"mrname="+mrname,
        				success:function(result){
        					$(".tr1").nextAll().remove();
        					var objs=eval(result);
        					$(objs).each(function(){
        						var trcontent="<tr><td>"+this.mi_NAME+"</td><td>"+this.mr_ADDRESS+
        						"</td><td>"+this.mi_START_TIME+"</td><td>"+this.mi_END_TIME+"</td><td>"+this.mi_BOOK_TIME+"</td><td>"
        						+this.ui_NAME+"</td><td><a href='#'>查看详情</a></td></tr>";
        						$(".tr1").after(trcontent);
        					});
        				}
        			});
        		});
        		$("input[name='MU_NAME']").blur(function(){	
        			var muname=$(this).val();
        			$.ajax({
        				type:"post",
        				url:"${pageContext.request.contextPath}/MeetingApplySearchbyMUName.do",
        				data:"muname="+muname,
        				success:function(result){
        					$(".tr1").nextAll().remove();
        					var objs=eval(result);
        					var l=objs;
        					alert(l.length);
        					$(objs).each(function(){
        						var trcontent="<tr><td>"+this.mi_NAME+"</td><td>"+this.mr_ADDRESS+
        						"</td><td>"+this.mi_START_TIME+"</td><td>"+this.mi_END_TIME+"</td><td>"+this.mi_BOOK_TIME+"</td><td>"
        						+this.ui_NAME+"</td><td><a href='#'>查看详情</a></td></tr>";
        						$(".tr1").after(trcontent);
        					});
        				}
        			});
        		});
        	});
</script>
</head>
<body>
	<div class="center">
		<div>
			会议预定&gt;<a href="#">搜索会议</a>
		</div>
		<br />
		<form name="SearchMeetForm" action="${pageContext.request.contextPath }/MeetingApplySearch.do" method="post">
			<fieldset style="height: 160px; width: 720px">
				<legend class="legent1">
					<strong>搜索会议</strong>
				</legend>
				<font size="2">会议名称:</font><input type="text" name="MI_NAME" id="min"/> 
				<font size="2">会议室名称:</font><input type="text" name="MR_NAME" /> 
				<font size="2">预订者姓名:</font><input type="text" name="MU_NAME"/><br /><br />
				<font size="2">会议日期:</font><input type="date" name="MI_START"/><input type="time" name="MI_STARTT"/>
				 <font size="2">到</font><input type="date" name="MI_END"/><input type="time" name="MI_ENDT"/>
				<br />
				 <br style="height: 1px" /> <font size="2">申请日期:</font><input type="date" name="MA_START"/><input type="time" name="MA_ST"/>
				<br />
				<p align="center">
					<input type="submit" value="查询" />&nbsp;&nbsp;&nbsp;
					<input type="reset" value="重置" />
				</p>
			</fieldset>
		</form>
		<p align="center">
			<strong>查询结果</strong>
		</p>
		<span id="list" style="color:red"><strong>${tishi }</strong> </span>
		<table border="1" class="table">
			<caption class="caption">
		 	  <table width="750px" border=0 cellpadding=0 cellspacing=0>
					<tr border=0>
						<td style="text-align:left">
						<font size="3">共</font><strong>54</strong><font>条结果，分成<strong>6</strong>页显示，当前第<strong>1</strong>页</font>
						</td>
						<td style="text-align:right ">
						<input type="button" value="首页" id="firstpage" />&nbsp;
						<input type="button" value="上页" id="previouspage"/>&nbsp;
						<input type="button" value="下页" id="nextpage" />&nbsp;
						<input type="button" value="末页" id="lastpage"/>&nbsp; 
						<font size="2">跳到第</font>
						<input type="text" size="2" id="xpage"/>
						<font size="2">页</font>
						</td>
					</tr>
				</table>
			</caption>
			<tr class="tr1" align="center">
				<td>会议名称</td>
				<td>会议地点</td>
				<td>会议开始时间</td>
				<td>会议结束时间</td>
				<td>会议预定时间</td>
				<td>预订者</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${SearchMeet }" var="SMeet">
			 <tr style="height: 25px">     
				<td>${SMeet.MI_NAME }</td>
				<td>${SMeet.MR_ADDRESS }</td>
				<td>${SMeet.MI_START_TIME }</td>
				<td>${SMeet.MI_END_TIME }</td>
				<td>${SMeet.MI_BOOK_TIME }</td>
				<td>${SMeet.UI_NAME }</td>
				<td><a href="#">查看详情</a></td>
			 </tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>