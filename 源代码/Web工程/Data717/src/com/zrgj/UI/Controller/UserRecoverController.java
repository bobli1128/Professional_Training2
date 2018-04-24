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
@WebServlet(value={"/RecoverUser.do"})
public class UserRecoverController extends HttpServlet {
	private UserInfoService service=new UserInfoService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int UI_ID=Integer.parseInt(req.getParameter("id"));
		UserInfo u=new UserInfo();
		u.setUI_ID(UI_ID);
		service.UpdateOlduser(u);
		resp.sendRedirect(req.getContextPath()+"/ManagePeople/SearchEmployee.jsp");
	}
}
