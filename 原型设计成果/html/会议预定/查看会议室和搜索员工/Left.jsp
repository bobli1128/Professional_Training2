<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>zuo</title>
<link rel="stylesheet" type="text/css" href="/Data717/css/Login.css" />
<c:if test="${UserInfo.UI_ROLES=='0' }">
<style>
.grad1 {
    height: 25px;
    width:120px;
    padding-top:8px;
    text-valign:center;
    background: -webkit-linear-gradient(left, rgb(255,150,128), rgb(173,137,118),rgb(165,184,192)); /* Safari 5.1 - 6.0 */
    background: -o-linear-gradient(left, rgb(255,150,128), rgb(173,137,118),rgb(165,184,192)); /* Opera 11.1 - 12.0 */
    background: -moz-linear-gradient(left, rgb(255,150,128), rgb(173,137,118),rgb(165,184,192)); /* Firefox 3.6 - 15 */
    background: linear-gradient(to right, rgb(255,150,128), rgb(173,137,118),rgb(165,184,192)); /* 标准的语法（必须放在最后） */
}
</style>
</c:if>
<c:if test="${UserInfo.UI_ROLES=='1' }">
<style>
.grad1{
 height: 20px;
    width:120px;
    text-valign:center;
    background: -webkit-linear-gradient(left, rgb(255,150,128), rgb(173,137,118),rgb(165,184,192)); /* Safari 5.1 - 6.0 */
    background: -o-linear-gradient(left, rgb(255,150,128), rgb(173,137,118),rgb(165,184,192)); /* Opera 11.1 - 12.0 */
    background: -moz-linear-gradient(left,rgb(255,150,128), rgb(173,137,118),rgb(165,184,192)); /* Firefox 3.6 - 15 */
    background: linear-gradient(to right, rgb(255,150,128), rgb(173,137,118),rgb(165,184,192)); /* 标准的语法（必须放在最后） */
}
</style>
</c:if>
</head>
<body>
	<div class="Left">
	
		<div class="left1">
			<div>
				<div class="grad1">个人中心</div>
				<ul>
					<li><a href="Personals/NewInfomation.jsp" target="ContentFrame" style="text-decoration:none">最新通知</a></li>
					<li><a href="Personals/MyReserve.jsp" target="ContentFrame" style="text-decoration:none">我的预定</a></li>
					<li><a href="MyMeetings.do" target="ContentFrame" style="text-decoration:none">我的会议</a></li>
				</ul>
			</div>
		</div>
		<div>
			<div>
				<div class="grad1">人员管理</div>
				<ul>
					<li><a href="DepartmentShow.do" target="ContentFrame" style="text-decoration:none">部门管理</a></li>
					<li><a href="${pageContext.request.contextPath }/UserEnrollEnter.do" target="ContentFrame" style="text-decoration:none">员工注册</a></li>
					<li><a href="UserEnrollApprovalShow.do" target="ContentFrame" style="text-decoration:none">注册审批</a></li>
					<li><a href="ManagePeople/SearchEmployee.jsp" target="ContentFrame" style="text-decoration:none">搜索员工</a></li>
				</ul>
			</div>
		</div>
		<c:if test="${UserInfo.UI_ROLES=='1' }">
		<div>
			<div>
				<div class="grad1">会议管理</div>
				<ul>
					<li><a href="MeetingManage/AddMeetingRooms.jsp" target="ContentFrame" style="text-decoration:none">添加会议室</a></li>
					<li><a href="RoomShow.do" target="ContentFrame" style="text-decoration:none">查看会议室</a></li>
					<li><a href="MeetingManage/BookMeetings.jsp" target="ContentFrame" style="text-decoration:none">预定会议</a></li>
					<li><a href="MeetingManage/SearchMeeting.jsp" target="ContentFrame" style="text-decoration:none">搜索会议</a></li>
				</ul>
			</div>
		</div>
		</c:if>
	</div>
</body>
</html>