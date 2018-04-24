package com.zrgj.UI.Controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgj.BLL.MRinfoService;
import com.zrgj.POJO.MRinfo;


/**
 * 更新控制器，这个控制器在更新操作过程中会产生两次操作
 * 第一次操作是通过超链接进入到控制器中，获取需要更新的记录数据，并将更新的记录数据显示在视图中；
 * 第二次操作是用户编辑完数据后产生表单提交，进行数据库的更新操作；
 * 第一次是GET方式请求提交，第二次是POST方式请求提交
 * @author Administrator
 *
 */
@WebServlet(value={"/MRinfo/update.do"})
public class MRinfoUpdateController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MRinfoService service=new MRinfoService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		MRinfo t=new MRinfo();
		t.setMR_ID(id);
		try {
			t=service.getMRbyid(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("MRinfo", t);
		req.getRequestDispatcher("/MeetingManage/meetingedit.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String managerId = req.getParameter("manager");
		String idStr = req.getParameter("id");
		String countStr =req.getParameter("count");
		
		String date = req.getParameter("date");
		String time=req.getParameter("time");
		String addtime=date+" "+time+":00";
		Timestamp add_time=Timestamp.valueOf(addtime);
		String status=req.getParameter("status");
		String desc=req.getParameter("desc");
		int manager=Integer.parseInt(managerId);
		int id=Integer.parseInt(idStr);
		int count=Integer.parseInt(countStr);
		MRinfo t=new MRinfo();
		t.setMR_ID(id);
		t.setMR_NAME(name);
		t.setMR_ADDRESS(address);
		t.setMR_COUNT(count);
		t.setMR_MANAGER(manager);
		t.setMR_MONTH(add_time);
		t.setMR_STATUS(status);
		t.setMR_DESC(desc);
		try {
			service.UpdateOldMR(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.sendRedirect(req.getContextPath()+"/RoomShow.do");
	}

}
