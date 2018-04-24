<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/Data717/css/Login.css">
<style type="text/css">
	.table2 {
	margin-top:-750px;
	border-collapse: collapse;
	border: 1px solid rgb(165, 184, 192);
	width: 800px;
}
</style>
</head>
<body>
	<div class="center" align="left" >
		<div>个人中心&gt;<a href="${pageContext.request.contextPath }/UserNewNotice/show.do">最新通知</a></div>
		</div>
		<div class="guanli" align="left">
		
			<table border="1" class="table2">
			
					<caption><a href="${pageContext.request.contextPath }/UserNewNotice/show.do">未来七天我要参加的会议</a></caption>
					<tr class="tr1"> 
					    
						<td>会议名称</td>
						<td>会议室</td>
						<td>起始时间</td>
						<td>结束时间</td>
						<td>操作</td>
					</tr>
					 <c:forEach items="${mymeeting }" var="m">
                      <tr>
                            
                            <td>${m.MI_TITLE }</td>
                    		<td>${m.MI_ROOM }</td>
                    		<td>
                    			<fmt:formatDate value="${m.MI_START_TIME }" type="both"/>
                    		</td>
                    		<td>
                    			<fmt:formatDate value="${m.MI_END_TIME }" type="both"/>
                    		</td>
                    		<td><a href="${pageContext.request.contextPath }/MRApplyInfo/showdetail.do?id=${m.MI_ID }">查看详情</a></td>
                      </tr>
                    
                    </c:forEach>
                   
				</table>

		</div>
</body>
</html>