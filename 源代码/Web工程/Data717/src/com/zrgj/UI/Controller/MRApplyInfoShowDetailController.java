package com.zrgj.UI.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgj.BLL.MRApplyInfoService;
import com.zrgj.POJO.MRApplyInfo;



@WebServlet(value={"/MRApplyInfo/showdetail.do"})
public class MRApplyInfoShowDetailController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MRApplyInfoService service=new MRApplyInfoService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		MRApplyInfo mra=new MRApplyInfo();
		mra.setMI_ID(id);
		try {
			mra=service.getmRAbyid(mra);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("mrapp", mra);
		req.getRequestDispatcher("/MeetingManage/MRApplyInfoShowDetail.jsp").forward(req, resp);
	}
}
