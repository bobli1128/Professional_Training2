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
@WebServlet(value={"/SearchEmployee.do"})
public class UserSearchController extends HttpServlet {
	private UserInfoService service=new UserInfoService();
	UserInfo u=new UserInfo();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String UI_NAME=req.getParameter("UI_NAME");
		String UI_ACCOUNT=req.getParameter("UI_ACCOUNT");
		String UI_STATUS=req.getParameter("UI_STATUS");
		u.setUI_NAME(UI_NAME);
		u.setUI_ACCOUNT(UI_ACCOUNT);
		u.setUI_STATUS(UI_STATUS);
		service.GetUserbyNameAccountandStatus(u);
		req.setAttribute("SearchUser", service.GetUserbyNameAccountandStatus(u));
		req.getRequestDispatcher("/ManagePeople/SearchEmployee.jsp").forward(req, resp);
	}
}
