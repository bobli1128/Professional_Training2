package com.zrgj.UI.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zrgj.BLL.MRApplyInfoService;
import com.zrgj.BLL.Meeting_UserInfoService;
import com.zrgj.POJO.MRApplyInfo;
import com.zrgj.POJO.Meeting_UserInfo;
import com.zrgj.POJO.UserInfo;
@WebServlet(value={"/MyMeetings.do"})
public class MyMeetingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MRApplyInfoService service=new MRApplyInfoService();
	Meeting_UserInfoService muservice=new Meeting_UserInfoService();
	
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		HttpSession session=req.getSession();
		UserInfo us=(UserInfo) session.getAttribute("UserInfo");
		Meeting_UserInfo mu=new Meeting_UserInfo();
		List<Meeting_UserInfo> mulist=null;
		List<MRApplyInfo> mralist=new ArrayList<MRApplyInfo>();
		int userId=us.getUI_ID();
		mu.setUI_ID(userId);
		try {
			mulist=muservice.readMiIdBYUiId(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(int i=0;i<mulist.size();i++){
			try {
				mralist.add(service.getAllMRbyUiID(mulist.get(i).getMI_ID()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(mralist);
		req.setAttribute("meetings", mralist);
		req.getRequestDispatcher("/Personals/MyMeetings.jsp").forward(req,resp);
		
	}
}
