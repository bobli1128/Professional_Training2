<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/Data717/css/Login.css" />
</head>
<body>
<div class="center" align="left" >
			<div>人员管理&gt;<strong>注册审批</strong>></div>
		<br/>
		<div class="guanli" align="left">
			<table border="1" class="table">
				<caption>所有待注册审批信息</caption>
				<thead>
					<tr class="tr1"> 
						<td>姓名</td>
						<td>账户名</td>
						<td>联系电话</td>
						<td>电子邮箱</td>
						<td>操作</td>	
					</tr>
				</thead>
				<tbody>
			<!-- 循环遍历集合，集合数据是请求对象中的属性内容，通过EL表达式获取，EL表达式写法${属性名} -->
			       <c:forEach items="${user }" var="u">
				     <tr>
					    <td>${u.UI_NAME }</td>
					    <td>${u.UI_ACCOUNT }</td>
					    <td>${u.UI_TEL }</td>
				    	<td>${u.UI_EMAIL }</td>
					    <td><a href="${pageContext.request.contextPath }/UserEnrollApprovalDelete.do?type=del&id=${u.UI_ID}"
					    onclick="return confirm('是否删除该用户？')">删除</a>
					    <a href="${pageContext.request.contextPath }/UserEnrollApprovalUpdate.do?type=approved&id=${u.UI_ID}">通过</a>
					    </td>
				      </tr>
			        </c:forEach>
		         </tbody>
			</table>
			<!-- 判断属性中的集合是否为空 -->
	          <c:if test="${empty user }">
	        	用户信息表中无任何记录！
	          </c:if>
		     </div>
		</div>
</body>
</html>