package com.zrgj.UI.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgj.BLL.MRinfoService;
import com.zrgj.POJO.MRinfo;



@WebServlet(value={"/MRinfo/show.do"})
public class MRinfoShowController extends HttpServlet {
	private MRinfoService service=new MRinfoService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<MRinfo> list=service.getAllRoom();
		req.setAttribute("rooms",list );
		req.getRequestDispatcher("/BookMeeting/ViewRoom.jsp").forward(req, resp);
	}

}
