<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="UTF-8">
		<title>学习HTML</title>
		<link rel="stylesheet" type="text/css" href="/Data717/css/Login.css" />
</head>
			<div class="center">
				<div>会议预定&gt;<a href="${pageContext.request.contextPath }/RoomShow.do">查看会议室</a>&gt;
								<a href="${pageContext.request.contextPath }/MRinfo/showdetail.do">会议室详情</a>
				</div>
				<div class="table_middle">
					<table border="1" class="table">
						<caption>会议室信息表</caption>
						<thead>
							<tr>
								<th>会议室编号</th><th>会议室地址</th><th>会议室名称</th><th>会议室管理员</th><th>会议室容量</th><th>会议室添加日期</th><th>会议室描述</th>	<th>会议室状态</th><th>操作</th>
							</tr>
						</thead>
						<tbody>
								<tr>
									<td>${mrap.MR_ID}</td>
									<td>${mrap.MR_ADDRESS}</td>
									<td>${mrap.MR_NAME}</td>
									<td>${mrap.MR_MANAGER}</td>
									<td>${mrap.MR_COUNT}</td>
									<td>
										<fmt:formatDate value="${mrap.MR_MONTH}" type="both"/>
									</td>
									<td>${mrap.MR_DESC}</td>
									<td>${mrap.MR_STATUS}</td>
									<td><a href="${pageContext.request.contextPath }/MRinfo/delete.do?id=${mrap.MR_ID}"
									onclick="return confirm('是否删除该会议室？')">删除</a>
									<a href="${pageContext.request.contextPath }/MRinfo/update.do?id=${mrap.MR_ID}">更新</a>
									</td>
								</tr>
						</tbody>
					</table>
				</div>
		</div>
		</div>
	</body>
</html>