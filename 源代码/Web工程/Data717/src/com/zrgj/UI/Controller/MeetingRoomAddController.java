package com.zrgj.UI.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgj.BLL.MeetingRoomService;
import com.zrgj.POJO.MeetingRoom;
@WebServlet(value={"/MeetingRoomAdd.do"})
public class MeetingRoomAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MeetingRoomService service=new MeetingRoomService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("MR_NAME");
		String address=req.getParameter("MR_ADDRESS");
		int count=Integer.parseInt(req.getParameter("MR_COUNT"));
		String status=req.getParameter("MR_STATUS");
		String desc=req.getParameter("MR_DESC");
		MeetingRoom m=new MeetingRoom();
		m.setMR_NAME(name);
		m.setMR_ADDRESS(address);
		m.setMR_COUNT(count);
		m.setMR_STATUS(status);
		m.setMR_DESC(desc);
		try {
			service.CreatNewRoom(m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//添加新用户后，页面跳转到显示所有用户的视图，查看添加用户的结果
		resp.sendRedirect(req.getContextPath()+"/RoomShow.do");
	}
}
