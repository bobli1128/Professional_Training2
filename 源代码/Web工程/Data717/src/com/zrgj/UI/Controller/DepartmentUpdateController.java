package com.zrgj.UI.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgj.BLL.DepartmentService;
@SuppressWarnings("serial")
@WebServlet(value={"/DepartmentUpdate.do"})
public class DepartmentUpdateController extends HttpServlet {
private DepartmentService service=new DepartmentService();

//@Override
//protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	int Departmentid=Integer.parseInt(req.getParameter("departmentid"));
//	Department d=new Department();
//	d.setDE_ID(Departmentid);
//	d=service.getDepartmentbyid(d);
//	req.setAttribute("dept", d);
//	req.getRequestDispatcher("/ManagePeople/DepartManage.jsp").forward(req, resp);
//}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int Departmentid=Integer.parseInt(req.getParameter("departmentid"));
	String Departmentname=req.getParameter("departmentname");
//	
//	Department d=new Department();
//
//	d.setDE_ID(Departmentid);
//	d.setDE_NAME(Departmentname);
//	System.out.println(d);
	//service.UpdateOldDepartment(d);
	service.UpdateOldDepartment(Departmentname, Departmentid);
	resp.sendRedirect(req.getContextPath()+"/DepartmentShow.Enroll");
}

}
