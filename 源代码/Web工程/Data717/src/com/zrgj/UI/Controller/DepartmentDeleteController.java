package com.zrgj.UI.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgj.BLL.DepartmentService;
@SuppressWarnings("serial")
@WebServlet(value={"/DepartmentDelete.do"})
public class DepartmentDeleteController extends HttpServlet {
	//private static final long serialVersionUID=1L;
	
		private DepartmentService service=new DepartmentService();
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int Departmentid=Integer.parseInt(req.getParameter("departmentid"));
//			Department d=new Department();
//			
//			d.setDE_ID(Departmentid);
//			System.out.println(d);
			 service.DeleteOlddept(Departmentid);
			resp.sendRedirect(req.getContextPath()+"/DepartmentShow.Enroll");
		}
}
