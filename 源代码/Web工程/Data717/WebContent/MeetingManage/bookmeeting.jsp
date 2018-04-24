<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>学习HTML</title>
<link rel="stylesheet" type="text/css" href="/Data717/css/Login.css" />
<style>
.center1 {
	background-color: rosybrown;
	padding-top: 0px;
	padding-left: 100px;
	margin-left: 0px;
	margin-bottom: 120px;
}

.center1_middle {
	margin-top: -115px;
}

#divfrom {
	float: left;
	width: 150px;
}

#divto {
	float: left;
	width: 150px;
}

#divoperator {
	float: left;
	width: 50px;
	padding: 60px 5px;
}

#divoperator input[type="button"] {
	margin: 10px 0;
}

#selDepartments {
	display: block;
	width: 100%;
}

#selEmployees {
	display: block;
	width: 100%;
	height: 200px;
}

#selSelectedEmployees {
	display: block;
	width: 100%;
	height: 225px;
}

.buttom1 {
	background-color: rosybrown;
	margin-top: 0px;
	height: 100px;
	width: 970px;
	margin-left: 200px;
}

.buttom1_text {
	margin-left: 280px;
	padding-top: 40px;
}

.buttom1_img {
	margin-left: 450px;
	margin-top: -50px;
}

.hr2 {
	width: 970px;
	margin-left: 200px;
	margin-top: -10px;
	margin-bottom: -7px;
}

.center3 {
	padding-top: 20px;
	width: 970px;
	height: 600px;
	background-color: rosybrown;
	margin-left: 200px;
}
</style>
<script type="text/javascript" src="../js/jquery-1.6.js"></script>
<script type="text/javascript">
		$(function(){
			$("select[name='seldepa']").change(function(){
				$.ajax({
					type:"post",
					
					url:"${pageContext.request.contextPath }/MRApplyInfoDepaEmp/select.do",
					datatype:"json",
					data:"depa="+$("#selDepartments").val(),
					success:function(result){
						var objs=eval(result);
						$("#selEmployees").empty();
						for(var i=0;i<objs.length;i++){
							$("#selEmployees").append("<option value="+objs[i].ui_ID+">"+objs[i].ui_NAME);
						}
					}
				});
			});
		});
</script>

<script type="application/javascript">
            function employee(employeeid, employeename){
                this.employeeid = employeeid;
                this.employeename = employeename;
            }
            function department(departmentid, departmentname, employees){
                this.departmentid = departmentid;
                this.departmentname = departmentname;
                this.employees = employees;
            }            
            var selDepartments;
            var selEmployees;
            var selSelectedEmployees;
            
            function body_load(){
                selDepartments = document.getElementById("selDepartments");
                selEmployees = document.getElementById("selEmployees");
                selSelectedEmployees = document.getElementById("selSelectedEmployees");
                
                for(var i=0;i<data.length;i++){
                    var dep = document.createElement("option");
                    dep.value = data[i].departmentid;
                    dep.text = data[i].departmentname;
                    selDepartments.appendChild(dep);
                }
                
                fillEmployees();
            }
            
            function fillEmployees(){
                clearList(selEmployees);
                var departmentid = selDepartments.options[selDepartments.selectedIndex].value;//selDepartments.selectedIndex指的是 选择哪个option的下标
                var employees;
                for(var i=0;i<data.length;i++){
                    if (departmentid == data[i].departmentid){
                        employees = data[i].employees;
                        break;
                    }
                }
                for(i=0;i<employees.length;i++){
                    var emp = document.createElement("option");
                    emp.value = employees[i].employeeid;
                    emp.text = employees[i].employeename;
                    selEmployees.appendChild(emp);
                }
            }
            
            function clearList(list){
                while(list.childElementCount > 0){
                    list.removeChild(list.lastChild);
                }
            }
            
            function selectEmployees(){
                for(var i=0;i<selEmployees.options.length;i++){
                    if (selEmployees.options[i].selected){
                        addEmployee(selEmployees.options[i]);
                        selEmployees.options[i].selected = false;
                    }
                }
            }
            
            function deSelectEmployees(){
                var elementsToRemoved = new Array();
                var options = selSelectedEmployees.options;
                for(var i=0;i<options.length;i++){
                    if (options[i].selected){
                        elementsToRemoved.push(options[i]);
                    }
                }
                for(i=0;i<elementsToRemoved.length;i++){
                    selSelectedEmployees.removeChild(elementsToRemoved[i]);
                }
            }
            
            function addEmployee(optEmployee){
                var options = selSelectedEmployees.options;
                var i = 0;
                var insertIndex = -1;
                while(i < options.length){
                    if (optEmployee.value == options[i].value){
                        return;
                    } else if (optEmployee.value < options[i].value) {
                        insertIndex = i;
                        break;
                    }
                    i++;
                }
                var opt = document.createElement("option");
                opt.value = optEmployee.value;
                opt.text = optEmployee.text;
                
                if (insertIndex == -1){
                    selSelectedEmployees.appendChild(opt);
                } else {
                    selSelectedEmployees.insertBefore(opt, options[insertIndex]);
                }
            }
</script>


</head>
<body onload="body_load()">
		<div class="center">
			<div>
				会议预定&gt;<a href="${pageContext.request.contextPath }/MRApplyInfoMR/showmr.do">预定会议</a>
			</div>
			<div>
				<form action="${pageContext.request.contextPath }/MRApplyInfo/add.do" method="post">
					<fieldset>
						<legend>
							<strong>会议信息</strong>
						</legend>
						<div class="center1_middle">
							<table>
								<tr>
									<td>會議申請人：</td>
									<td><input type="text" name="applyer" value="${UserInfo.UI_NAME }" readonly="readonly"></td>
								</tr><br/>
								<tr>
									<td>会议名称：</td>
									<td><input type="text" name="name"></td>
								</tr><br/>
								<tr>
									<td>预计参加人数：</td>
									<td><input type="number" name="count"></td>
								</tr><br/>
								<tr>
									<td>會議預定時間：</td>
									<td><input type="date" name="bookdate"><input type="time" name="booktime"></td>
								</tr><br/>
								<tr>
									<td>预计开始时间：</td>
									<td><input type="date"  name="startdate"><input type="time"  name="starttime"></td>
								</tr><br/>
								<tr>
									<td>预计结束时间：</td>
									<td><input type="date"  name="enddate"><input type="time"  name="endtime"></td>
								</tr><br/>
								<tr>
									<td>会议室名称：</td>
									<td><select id="selMeetingRoom" name="selmr">
										<c:forEach items="${rooms }" var="m">
											<option value="${m.MR_NAME }">${m.MR_NAME }</option>
										</c:forEach>
									</select></td>
								</tr>
								<br />
								<tr>
									<td>会议说明：</td>
									<td><textarea rows="5" cols="60" placeholder="不超过200字"	name="desc"></textarea></td>
								</tr>
								<br />
								<tr>
									<td>选择参会人员：</td>
									<td>
										<div id="divfrom">
											<select id="selDepartments" name="seldepa" onchange="fillEmployees()">
												<c:forEach items="${dept }" var="d">
													<option value="${d.departmentname }">${d.departmentname }</option>
												</c:forEach>
											</select> 
											<select id="selEmployees" multiple="multiple"></select>
										</div>
										<div id="divoperator">
											<input type="button" class="clickbutton" value="&gt;"onclick="selectEmployees()" /> 
											<input type="button" class="clickbutton" value="&lt;"onclick="deSelectEmployees()" />
										</div>
										<div id="divto">
											<select id="selSelectedEmployees" name="selEmp" multiple="multiple"></select>
										</div>
									</td>
								</tr>
								<tr>
									<td><input type="submit" value="预定会议"></td>
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