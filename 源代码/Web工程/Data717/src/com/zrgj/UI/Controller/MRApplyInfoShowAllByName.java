package com.zrgj.UI.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgj.BLL.MRApplyInfoService;
import com.zrgj.POJO.MRApplyInfo;

@WebServlet(value={"/MRApplyInfoShowByName/show.do"})
public class MRApplyInfoShowAllByName extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MRApplyInfoService service=new MRApplyInfoService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		System.out.println(name);
		MRApplyInfo mra=new MRApplyInfo();
		mra.setMI_TITLE(name);
		try {
			mra=service.GetMTbyName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("mrapp", mra);
		req.getRequestDispatcher("/MeetingManage/MRApplyInfoShowDetail.jsp").forward(req, resp);
	}
	
}
