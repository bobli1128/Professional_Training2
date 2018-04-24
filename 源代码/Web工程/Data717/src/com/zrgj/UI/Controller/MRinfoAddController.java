package com.zrgj.UI.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgj.BLL.MRinfoService;
import com.zrgj.POJO.MRinfo;


@WebServlet(value={"/MRinfo/add.do"})
public class MRinfoAddController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private MRinfoService service=new MRinfoService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		int count=Integer.parseInt(req.getParameter("count"));
		String status=req.getParameter("status");
		String desc=req.getParameter("desc");
		MRinfo t=new MRinfo();
		t.setMR_NAME(name);
		t.setMR_ADDRESS(address);
		t.setMR_COUNT(count);
		t.setMR_STATUS(status);
		t.setMR_DESC(desc);
		try {
			service.CreateNewMR(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//添加新用户后，页面跳转到显示所有用户的视图，查看添加用户的结果
		resp.sendRedirect(req.getContextPath()+"/MRinfo/show.do");
	}

}
