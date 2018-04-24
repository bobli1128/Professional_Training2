package com.zrgj.UI.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zrgj.BLL.MRApplyInfoService;
import com.zrgj.POJO.MRApplyInfo;
import com.zrgj.POJO.UserInfo;



@SuppressWarnings("serial")
@WebServlet(value={"/MRApplyInfo/show.do"})
public class MRApplyInfoShowController extends HttpServlet{
	
	private MRApplyInfoService service=new MRApplyInfoService();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		UserInfo us=(UserInfo) session.getAttribute("UserInfo");
		int id=us.getUI_ID();
		System.out.println(id);
		List<MRApplyInfo> list = null;
		try {
			list = service.GetAllByUserId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(list);
		req.setAttribute("mrainfo",list );
		req.getRequestDispatcher("/MeetingManage/myreserva.jsp").forward(req, resp);
	}
}
