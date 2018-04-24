<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/Data717/css/Login.css" />
<style>
.center2_middle{
				margin-top: -100px;
			}
</style>
</head>
<body>
<div class="center">
			<div>会议预定&gt;<a href="#">添加会议室</a></div>
			<br>
			<div>
				<form action="${pageContext.request.contextPath }/MeetingRoomAdd.do" method="post">
					<fieldset>
						<legend><strong>会议室信息</strong></legend>
						<div class="center2_middle">
							<table>
							<tr>
								<td>门牌号：</td><td><input type="text" placeholder="例如：201" name="MR_ADDRESS"></td>
							</tr><br/>
							<tr>
								<td>会议室名称：</td><td><input type="text" placeholder="例如：第一会议室" name="MR_NAME"></td>
							</tr><br />
							<tr>
								<td>最多容纳人数：</td><td><input type="text" placeholder="填写一个正整数" name="MR_COUNT"></td>
							</tr><br />
							<tr>
								<td>当前状态：</td><td><input type="radio" name="MR_STATUS" value="1">启用
														<input type="radio" name="MR_STATUS" value="0">禁用
														<input type="radio" name="MR_STATUS" value="2">删除
													</td></tr><br />
							<tr>
								<td>备注：</td><td><textarea rows="5" cols="60" placeholder="200字以内的文字描述" name="MR_DESC"></textarea></td>
							</tr><br />
							<tr>
								<td><input type="submit" value="添加"></td>
								<td><input type="reset" value="重置"></td>
							</tr>
						</table>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
		</div>
</body>
</html>