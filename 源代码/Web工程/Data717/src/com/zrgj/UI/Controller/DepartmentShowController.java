package com.zrgj.UI.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgj.BLL.DepartmentService;
//@SuppressWarnings("serial")
@SuppressWarnings("serial")
@WebServlet(value={"/DepartmentShow.Enroll"})
public class DepartmentShowController extends HttpServlet {
	private DepartmentService service=new DepartmentService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("dept", service.getAllDepartment());
		req.getRequestDispatcher("/ManagePeople/DepartManage.jsp").forward(req, resp);
	}
}
