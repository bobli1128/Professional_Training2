package com.zrgj.UI.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgj.BLL.DepartmentService;
@WebServlet(value={"/UserEnrollEnter.Enroll"})
public class UserEnrollEnterController extends HttpServlet {
	private DepartmentService service=new DepartmentService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("dept", service.getAllDepartment());
		//resp.sendRedirect(req.getContextPath()+"/ManagePeople/UserEnroll.jsp");
		req.getRequestDispatcher("/ManagePeople/UserEnroll.jsp").forward(req, resp);
	}
	
}
