<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/Facility_type/add.do" method="post">
		<table>
			<tr>
				<td>设备名：</td><td><input type="text" name="FT_NAME"></td>
			</tr>
			<tr><td colspan="2"><input type="submit"></td></tr>
		</table>
	</form>
</body>
</html>