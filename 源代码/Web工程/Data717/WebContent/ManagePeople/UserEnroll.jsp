<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/Data717/css/Login.css" />
<title>Insert title here</title>
</head>
<script type="text/javascript">
	window.onload = function() {
		var name = document.getElementById('name');
		var account = document.getElementById('Uaccount');
		var pw1 = document.getElementById('pw1');
		var pw2 = document.getElementById('pw2');
		var tel = document.getElementById('tel');
		var email = document.getElementById('email');
		var su = document.getElementById('su');
		var regEm = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
		var regTe = /^[1]([3][0-9]{1}|59|58|88|89)[0-9]{8}$/;
		name.onblur = function() {
			if (name.value == "") {
				//alert("姓名格式錯誤");
				var nam = document.getElementById("nam");
				nam.style.color = "red";
				nam.innerHTML = "姓名格式錯誤";
				su.disabled = true;
				document.EnrollForm.elements(0).focus();
			} else {
				var nam = document.getElementById("nam");
				nam.style.color = "blue";
				nam.innerHTML = "姓名输入完成";
				if(account.value != ""&&pw1.value != ""){
					su.disabled = false;
				}
			}

		}
		account.onblur = function() {
			if (account.value == "") {
				//alert("賬戶名不能為空");
				var ac = document.getElementById("ac");
				ac.style.color = "red";
				ac.innerHTML = "賬戶名不能為空";
				su.disabled = true;
				document.EnrollForm.elements(1).focus();
			} else {
				var ac = document.getElementById("ac");
				ac.style.color = "blue";
				ac.innerHTML = "賬戶名输入完成";
				if(name.value != ""&&pw1.value != ""){
					su.disabled = false;
				}
			}
		}
		pw1.onblur = function() {
			if (pw1.value == "") {
				//alert("密碼不能為空");
				var p1 = document.getElementById("p1");
				p1.style.color = "red";
				p1.innerHTML = "密碼不能為空";
				su.disabled = true;
				document.EnrollForm.elements(2).focus();
			} else {
				var p1 = document.getElementById("p1");
				p1.style.color = "blue";
				p1.innerHTML = "密碼输入完成";
				if(name.value != ""&&account.value != ""&&pw2.value!=""){
					su.disabled = false;
				}
			}
		}
		pw2.onblur = function() {
			if (pw1.value != pw2.value||pw2.value=="") {
				//alert("兩次密碼不相等");
				var p2 = document.getElementById("p2");
				p2.style.color = "red";
				p2.innerHTML = "兩次密碼不相等";
				su.disabled = true;
				document.EnrollForm.elements(3).focus();
			} else {
				var p2 = document.getElementById("p2");
				p2.style.color = "blue";
				p2.innerHTML = "密碼输入完成";
				if(name.value != ""&&account.value != ""&&pw1.value != ""){
					su.disabled = false;
				}
			}
		}
		tel.onblur = function() {
			if (tel.value == "") {
				//alert("電話不能為空");
				var te = document.getElementById("te");
				te.style.color = "red";
				te.innerHTML = "電話不能為空";
				su.disabled = true;
				document.EnrollForm.elements(4).focus();
			} else {
				if (!(regTe.test(tel.value))) {
					//alert("電話格式不正确");
					var te = document.getElementById("te");
					te.style.color = "red";
					te.innerHTML = "電話格式不正确";
					su.disabled = true;
					document.EnrollForm.elements(4).focus();
				} else {
					var te = document.getElementById("te");
					te.style.color = "blue";
					te.innerHTML = "電話输入成功";
					if(name.value != ""&&account.value != ""&&pw1.value != ""){
						su.disabled = false;
					}
				}
			}
		}
		email.onblur = function() {
			if (email.value == "") {
				//alert("郵箱不能為空");
				var em = document.getElementById("em");
				em.style.color = "red";
				em.innerHTML = "郵箱不能為空";
				su.disabled = true;
				document.EnrollForm.elements(5).focus();
			} else {
				if (!(regEm.test(email.value))) {
					//alert("郵箱格式不正确");
					var em = document.getElementById("em");
					em.style.color = "red";
					em.innerHTML = "郵箱格式不正确";
					su.disabled = true;
					document.EnrollForm.elements(5).focus();
				} else {
					var em = document.getElementById("em");
					em.style.color = "blue";
					em.innerHTML = "郵箱输入完成";
					if(name.value != ""&&account.value != ""&&pw1.value != ""){
						su.disabled = false;
					}
				}
			}
		}
	}
</script>
<body>
	<div class="center" align="left">
		<div>
			人员管理&gt;<a href="#">员工注册</a>
		</div>
		<br/>
		<span id="list" style="color:red"><strong>${list }</strong> </span>
		<form name="EnrollForm"
			action="${pageContext.request.contextPath }/Enroll.Enroll" method="post" target="_top">
			<fieldset>
				<legend>员工信息</legend>
				<table>
					<tr>
						<td>姓名：</td>
						<td><input type="text" id="name" name="UI_NAME"><span id="nam" style="color:blue"></span></td>
					</tr>
					<tr>
						<td>账户名：</td>
						<td><input type="text" id="Uaccount" name="UI_ACCOUNT"><span id="ac" style="color:blue"></span></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><input type="password" id="pw1" name="UI_PWD" placeholder="请输入6位以上的密码"><span id="p1" style="color:blue"></span></td>
					</tr>
					<tr>
						<td>确认密码：</td>
						<td><input type="password" id="pw2" name="pwd2"
							placeholder="请确认密码"><span id="p2" style="color:blue"></span></td>
					</tr>
					<tr>
						<td>联系电话：</td>
						<td><input type="text" id="tel" name="UI_TEL"><span id="te" style="color:blue"></span></td>
					</tr>
					<tr>
						<td>电子邮件：</td>
						<td><input type="text" id="email" name="UI_EMAIL"><span id="em" style="color:blue"></span></td>
					</tr>
					<tr>
						<td>所在部门：</td>
						<td><select name="UI_DEPARTMENT" id="depart">
						  <c:forEach items="${dept }" var="depart">
								<option value=${depart.DE_NAME }>${depart.DE_NAME }</option>
							</c:forEach>
						</select></td>


					</tr>
					<tr>
						<td><input type="submit" id="su" value="注册" disabled="disabled"/></td>
						<td><input type="reset" value="重置" /></td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
</body>
</html>