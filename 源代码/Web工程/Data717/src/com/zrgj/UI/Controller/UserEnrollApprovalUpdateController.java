package com.zrgj.UI.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgj.BLL.UserInfoService;
import com.zrgj.POJO.UserInfo;
@SuppressWarnings("serial")
@WebServlet(value={"/UserEnrollApprovalUpdate.do"})
public class UserEnrollApprovalUpdateController extends HttpServlet {
private UserInfoService service=new UserInfoService();

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String type=req.getParameter("type");
	if("approved".equals(type)){
		int UI_ID=Integer.parseInt(req.getParameter("id"));
		String UI_STATUS=req.getParameter("UI_STATUS");
		UserInfo u=new UserInfo();
	
		u.setUI_ID(UI_ID);
		u.setUI_STATUS(UI_STATUS);
		try {
			service.UpdateOlduser(u);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		resp.sendRedirect(req.getContextPath()+"/UserEnrollApprovalShow.do");
	}else{
	int UI_ID=Integer.parseInt(req.getParameter("id"));
	UserInfo u=new UserInfo();
	u.setUI_ID(UI_ID);
	try {
		u=service.getUserInfobyid(u);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	req.setAttribute("user", u);
	req.getRequestDispatcher("/ManagePeople/EnrollApproval.jsp").forward(req, resp);
	}
}
}
