<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/Data717/css/Login.css" />
<title>Insert title here</title>
<script type="text/javascript" src="/Data717/js/jquery-1.6.js"></script>
        <script type="text/javascript">
        	var deptid="";
        	var deptname="";
        	var flag=false;//默认情况下表格单元格中是文本显示
        	$(function(){
        		$(".clickbuttonEdit").click(function(){
	        			if(!flag){
		        			deptname=$(this).parent().prev().text();
		        			deptid=$(this).parent().prev().prev().text();
		        			var td=$(this).parent().prev();
		        			td.empty();
		        			var formstr="<form id='form1' action='${pageContext.request.contextPath }/DepartmentUpdate.do' "+
		        			"method='post'><fieldset><input type='text' name='departmentname' maxlength='20' value='"+deptname+"'/>"+
		        			"<input type='hidden' name='departmentid' maxlength='20' value='"+deptid+"'/></fieldset></form>";
		        			td.append(formstr);
		        			$(this).after("<a class='clickbuttonEdit' id='cancle' href='#'>取消</a>");
		        			flag=true;
		        			$("#cancle").click(function(){
		        				$(this).parent().prev().empty();
		        				$(this).parent().prev().text(deptname);
		        				$(this).remove();
		        				flag=false;
		        			});
	        			}else{
	        				$("#form1").submit();
	        			}
        		});
        	});
        </script>
</head>
<body>
	<div class="center" align="left">
		<div>
			人员管理&gt;<strong>部门管理</strong>>
			<br/>
			<br/>
		</div>
		<form name="DepartAddForm"
			action="${pageContext.request.contextPath }/DepartmentAdd.do" method="post">
			<fieldset>
				<legend>添加部门</legend>
				<table>
					<tr>
						<td>部门名称</td>
						<td><input type="text" name="departmentname"></td>
						<td><input type="submit" value="添加"></td>
					</tr>
				</table>
			</fieldset>
		</form>

		<div class="guanli" align="left">
			<table border="1" class="table">
				<caption>所有部门</caption>
				<tr class="tr1">
					<td>部门编号</td>
					<td>部门名称</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${dept}" var="dept">
				<tr>
				  <td>${dept.DE_ID }</td>
				    <td>${dept.DE_NAME }</td>
				    <td>
				       <a class="clickbuttonEdit">编辑</a>
                            	<a class="clickbutton" href="${pageContext.request.contextPath }/DepartmentDelete.do?departmentid=${dept.DE_ID}"
                            	onclick="return confirm('是否删除该部门？')">删除</a>
                    </td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>