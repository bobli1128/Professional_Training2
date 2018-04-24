package com.zrgj.UI.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgj.BLL.MRinfoService;
import com.zrgj.POJO.MRinfo;



@WebServlet(value={"/MRinfo/delete.do"})
public class MRinfoDeleteController extends HttpServlet {
	
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
			service.DeleteOldMR(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.sendRedirect(req.getContextPath()+"/RoomShow.do");
	}

}
