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
		<style>
            #divto{
                float:left;
                width:150px;
            }
            #divoperator{
                float:left;
                width:50px;
                padding:60px 5px;
            }
            #divoperator input[type="button"]{
                margin:10px 0;
            }
            #selDepartments{
                display:block;
                width:100%;
            }
            #selEmployees{
                display:block;
                width:100%;
                height:200px;
            }
            #selSelectedEmployees{
                display:block;
                width:100%;
                height:225px;
            }
            .buttom1{
            	position:relative;
				background-color: rosybrown;
				margin-top: 0px;
				height:100px;
				width: 900px;
				margin-left: 200px;
			}
			.buttom1_text{
				margin-left: 280px;
				padding-top: 40px;
			}
			.buttom1_img{
				margin-left: 450px;
				margin-top: -50px;
			}
			.hr2{
				width: 970px;
				margin-left: 200px;
				margin-top: -10px;
				margin-bottom: -7px;
			}
			.center3{
				position:relative;
				padding-top: 20px;
				width:970px;
				height:600px;
				background-color: rosybrown;
				margin-left: 200px;
			}
			.table1 {
				border-collapse: collapse;
				border: 1px solid rgb(165, 184, 192);
				width: 800px;
				margin-left:-60px;
			}
			.table_middle {
				padding-top: 10px;
				margin-top: 0px;
				margin-left: 70px;
			}
		</style>
</head>
<body>
<div class="center">
				<div>最新通知&gt;查看详情
				</div>
				<div class="table_middle">
					<table border="1" class="table1">
						<caption>会议室信息表</caption>
						<thead>
							<tr >
								<th width="70px">会议编号</th><th width="70px">会议名称</th><th width="70px">会议级别</th><th width="70px">会议内容</th><th width="90px">会议开始时间</th><th width="90px">会议结束时间</th>
								<th width="90px">会议预定时间</th><th width="70px">参会人数</th><th width="60px">预订者</th><th width="90px">举办会议地点</th><th width="70px">会议状态</th>
							</tr>
						</thead>
						<tbody>
								<tr>
									<td>${mrapp.MI_ID}</td>
									<td>${mrapp.MI_TITLE}</td>
									<td>${mrapp.MI_DEGREE}</td>
									<td>${mrapp.MI_CONTENT}</td>
									<td>
										<fmt:formatDate value="${mrapp.MI_START_TIME}" type="both"/>
									</td>
									<td>
										<fmt:formatDate value="${mrapp.MI_END_TIME}" type="both"/>
									</td>
									<td>
										<fmt:formatDate value="${mrapp.MI_BOOK_TIME}" type="both"/>
									</td>
									<td>${mrapp.MI_COUNT}</td>
									<td>${mrapp.MI_ORDER}</td>
									<td>${mrapp.MI_ROOM}</td>
									<td>${mrapp.MI_STATUS}</td>
								</tr>
						</tbody>
					</table>
				</div>
		</div>
	</body>
</html>