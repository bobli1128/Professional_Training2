package com.zrgj.UI.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgj.BLL.deptService;
import com.zrgj.POJO.dept;



@SuppressWarnings("serial")
@WebServlet(value={"/MRApllyInfoSelDepa/seldepa.do"})
public class MRApplyInfoSelDepaController extends HttpServlet{
	deptService service=new deptService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<dept> list=service.getAlldept();
		req.setAttribute("dept", list);
		req.getRequestDispatcher("/MeetingManage/bookmeeting.jsp").forward(req, resp);
	}
	
}
