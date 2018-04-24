package com.zrgj.UI.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgj.BLL.Meeting_ApplyService;
import com.zrgj.POJO.Meeting_Apply;

@WebServlet(value={"/MyMeetingDetails.do"})
public class MyMeetingDetailsController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Meeting_ApplyService service=new Meeting_ApplyService();
	
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{

		int md=Integer.parseInt(req.getParameter("id"));
		Meeting_Apply t=new Meeting_Apply();
		t.setMI_ID(md);
		try {
			req.setAttribute("meetings",service.getMeetingbyID(md));
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("/Personals/MyMeetingDetails.jsp").forward(req,resp);
		
	}
}
