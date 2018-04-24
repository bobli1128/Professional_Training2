package com.zrgj.UI.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgj.BLL.DepartmentService;
import com.zrgj.POJO.Department;
@WebServlet(value={"/DepartmentAdd.do"})
public class DepartmentAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DepartmentService service=new DepartmentService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Departmentname=req.getParameter("departmentname");
		Department d=new Department();
		d.setDE_NAME(Departmentname);
		service.CreateNewDepartment(d);
		resp.sendRedirect(req.getContextPath()+"/DepartmentShow.Enroll");
	}
	
}
