<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<caption>设备信息 表</caption>
		<thead>
			<tr>
				<th>设备ID</th><th>设备名</th><th>操作</th>
			</tr>
		</thead>
		<tbody>
			<!-- 循环遍历集合，集合数据是请求对象中的属性内容，通过EL表达式获取，EL表达式写法${属性名} -->
			<c:forEach items="${list}" var="u">
				<tr>
					<td>${u.FT_ID}</td>
					<td>${u.FT_NAME}</td>
					<td><a href="${pageContext.request.contextPath }/Facility_type/delete.do?id=${u.FT_ID}"
					onclick="return confirm('是否删除该用户？')">删除</a>
					<a href="${pageContext.request.contextPath }/Facility_type/update.do?id=${u.FT_ID}">更新</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 判断属性中的集合是否为空 -->
	<c:if test="${empty list }">
		用户信息表中无任何记录！
	</c:if>
</body>
</html>