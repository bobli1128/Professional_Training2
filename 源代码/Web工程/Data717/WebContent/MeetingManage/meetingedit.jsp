<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html>
<head>
		<meta charset="UTF-8">
		<title>修改会议室</title>
		<link rel="stylesheet" type="text/css" href="/Data717/css/Login.css" />
	</head>
<body>
			<div class="center">
			<div>会议预定&gt;<a href="/CMGS/BookMeeting/meetingedit.jsp">更改会议室信息</a></div>
			<div>
				<form action="${pageContext.request.contextPath }/MRinfo/update.do" method="post">
					<fieldset>
						<legend><strong>更改会议室信息</strong></legend>
						<table>
							<tr>
								<td>门牌编号：</td><td><input type="number" name="id" value="${MRinfo.MR_ID }" readonly="readonly"></td>
							</tr>
							<tr>
								<td>会议室地址：</td><td><input type="text" name="address" value="${MRinfo.MR_ADDRESS }"></td>
							</tr>
							<tr>
								<td>会议室名称：</td><td><input type="text" name="name" value="${MRinfo.MR_NAME }"></td>
							</tr>
							<tr>
								<td>会议室管理员：</td><td><input type="text" name="manager" value="${MRinfo.MR_MANAGER }" readonly="readonly"></td>
							</tr>
							<tr>
								<td>容纳人数：</td><td><input type="number" name="count" value="${MRinfo.MR_COUNT }"></td>
							</tr>
							<tr>
								<td>会议室添加时间：</td><td><input type="date" name="date" ><input type="time" name="time" ></td>
							</tr>
							<tr>
								<td>会议室状态：</td><td><input type="text" name="status" value="${MRinfo.MR_STATUS}"></td>
							</tr>
							<tr>
								<td>会议室描述：</td><td><input type="text" name="desc" value="${MRinfo.MR_DESC }"></td>
							</tr>
							<tr><td colspan="2"><input type="submit" value="确定"></td></tr>
						</table>
					</fieldset>
				</form>
			</div>
		</div>
		</div>
	</body>
</html>