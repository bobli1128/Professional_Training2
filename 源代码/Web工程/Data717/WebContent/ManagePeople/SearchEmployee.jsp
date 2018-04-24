<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/Data717/css/Login.css" />
<script type="text/javascript" src="/Data717/js/jquery-1.6.js"></script>
<script type="text/javascript">
var confirmm="是否关闭该用户？";
var confirmn="是否恢复该用户？";
</script>
 <script type="text/javascript">
        	$(function(){
        		$("input[name='UI_STATUS']").click(function(){
        			var status=$(this).val();
        			$.ajax({
        				type:"post",
        				url:"${pageContext.request.contextPath}/UserSearchbyStatues.do",
        				data:"status="+status,
        				success:function(result){
        					$(".tr1").nextAll().remove();
        					var objs=eval(result);
        					$(objs).each(function(){
        						if(this.ui_STATUS!='2'){
        						var trcontent="<tr><td>"+this.ui_NAME+"</td><td>"+this.ui_ACCOUNT+
        						"</td><td>"+this.ui_TEL+"</td><td>"+this.ui_EMAIL+"</td><td><a class='Close' href='${pageContext.request.contextPath }/CloseUser.do?id="+this.ui_ID+"' onclick='return confirm(confirmm)'>关闭账号</a></td></tr>";
        						$(".tr1").after(trcontent);}
        						else{
        							var trcontent="<tr><td>"+this.ui_NAME+"</td><td>"+this.ui_ACCOUNT+
            						"</td><td>"+this.ui_TEL+"</td><td>"+this.ui_EMAIL+"</td><td><a class='Close' href='${pageContext.request.contextPath }/RecoverUser.do?id="+this.ui_ID+"' onclick='return confirm(confirmn)'>恢复账号</a></td></tr>";
            						$(".tr1").after(trcontent);
        						}
        					});
        				}
        			});
        		});
        	});
</script>
</head>
<body>
<div class="center" align="left" >
			<div>人员管理&gt;<a href="#">搜索员工</a></div>
			<br/>
			<form name="SearchEmployeeForm" action="${pageContext.request.contextPath }/SearchEmployee.do" method="post">
				<fieldset>
					<legend>搜索员工</legend>
					<table>
						<tr>
							<a>姓名:</a><input type="text" name="UI_NAME"/>
							<a>账户名:</a><input type="text" name="UI_ACCOUNT"/>
						</tr>
						<tr>
							<td>状态</td>
							<td><input type="radio" name="UI_STATUS" value="1">已批准</td>
							<td><input type="radio" name="UI_STATUS" value="0">待审批</td>
						    <td><input type="radio" name="UI_STATUS" value="2">已关闭</td>
						</tr>
						<tr>
							<td><input type="submit" value="查询"/></td>
				       		<td><input type="reset" value="重置" onclick=""/></td>
						</tr>
						
					</table>
				</fieldset>
			</form>
		
		<div class="guanli" align="left">
			<table border="1" class="table">
					<caption>查询结果</caption>
					<tr class="tr1"> 
						<td>姓名</td>
						<td>账户名</td>
						<td>联系电话</td>
						<td>电子邮箱</td>
						<td>操作</td>	
					</tr>
			<c:forEach items="${SearchUser }" var="SUser">
			 <tr style="height: 25px">
			         
				<td>${SUser.UI_NAME }</td>
				<td>${SUser.UI_ACCOUNT }</td>
				<td>${SUser.UI_TEL }</td>
				<td>${SUser.UI_EMAIL }</td>
				<c:if test="${SUser.UI_STATUS!='2'}">
				<td><a class="clickbutton" href="${pageContext.request.contextPath }/CloseUser.do?id=${SUser.UI_ID}"
                            	onclick="return confirm('是否关闭该用户？')">关闭账号</a></td>
                </c:if>
                <c:if test="${SUser.UI_STATUS=='2'}">
                <td><a class="clickbutton" href="${pageContext.request.contextPath }/RecoverUser.do?id=${SUser.UI_ID}"
                            	onclick="return confirm('是否恢复该用户？')">恢复账号</a></td>
                </c:if>
			 </tr>
			</c:forEach>
				</table>
	       </div>
		</div>
</body>
</html>