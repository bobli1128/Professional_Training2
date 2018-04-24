package com.zrgj.UI.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zrgj.BLL.Facility_typeService;
import com.zrgj.POJO.Facility_type;
@SuppressWarnings("serial")
@WebServlet(value={"/Facility_type/add.do"})
public class Facility_typeAddController extends HttpServlet{
	private Facility_typeService service=new Facility_typeService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("FT_NAME");
		Facility_type f=new Facility_type();
		f.setFT_NAME(name);
		service.CreateNewFacility_type(f);
		//添加新用户后，页面跳转到显示所有用户的视图，查看添加用户的结果
		resp.sendRedirect(req.getContextPath()+"/Facility_type/show.do");
	}
}
