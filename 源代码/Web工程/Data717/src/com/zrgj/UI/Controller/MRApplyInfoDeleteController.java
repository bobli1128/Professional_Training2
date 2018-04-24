package com.zrgj.UI.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgj.BLL.MRApplyInfoService;
import com.zrgj.POJO.MRApplyInfo;


@WebServlet(value={"/MRApplyInfo/delete.do"})
public class MRApplyInfoDeleteController extends HttpServlet{
	private MRApplyInfoService service=new MRApplyInfoService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		MRApplyInfo mra=new MRApplyInfo();
		mra.setMI_ID(id);
		try {
			service.DeleteOldmRA(mra);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.sendRedirect(req.getContextPath()+"/MRApplyInfo/show.do");
	}
	
}
