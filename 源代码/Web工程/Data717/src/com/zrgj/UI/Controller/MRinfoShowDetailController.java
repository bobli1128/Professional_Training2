package com.zrgj.UI.Controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgj.BLL.MRinfoService;
import com.zrgj.POJO.MRinfo;



/**
 * 使用Servlet作为控制器，调用业务逻辑对象获取业务数据，并将业务数据传递给视图
 * @author Administrator
 *
 */
@WebServlet(value={"/MRinfo/showdetail.do"})
public class MRinfoShowDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MRinfoService service=new MRinfoService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		MRinfo mr=new MRinfo();
		mr.setMR_ID(id);
		try {
			mr=service.getMRbyid(mr);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		req.setAttribute("mrap", mr);
		req.getRequestDispatcher("/MeetingManage/MRinfoShowDetail.jsp").forward(req, resp);
	}

}
