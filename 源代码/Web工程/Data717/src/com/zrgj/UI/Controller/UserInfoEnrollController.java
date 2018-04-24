package com.zrgj.UI.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.zrgj.BLL.UserInfoService;
import com.zrgj.POJO.UserInfo;
@SuppressWarnings("serial")
@WebServlet(value={"/Enroll.Enroll"})
public class UserInfoEnrollController extends HttpServlet {
private UserInfoService service=new UserInfoService();

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String UI_NAME=req.getParameter("UI_NAME");
	String UI_ACCOUNT=req.getParameter("UI_ACCOUNT");
	String UI_PWD=req.getParameter("UI_PWD");
	String UI_TEL=req.getParameter("UI_TEL");
	String UI_EMAIL=req.getParameter("UI_EMAIL");
	String UI_DEPARTMENT=req.getParameter("UI_DEPARTMENT");
	
	UserInfo u=new UserInfo();
	u.setUI_NAME(UI_NAME);
	u.setUI_ACCOUNT(UI_ACCOUNT);
	u.setUI_PWD(UI_PWD);
	u.setUI_TEL(UI_TEL);
	u.setUI_EMAIL(UI_EMAIL);
	u.setUI_DEPARTMENT(UI_DEPARTMENT);
	u.setUI_ROLES("0");
	u.setUI_STATUS("0");
	int flag=0;
	try {
		flag=service.CreatNewUser(u);
	} catch (Exception e) {
		e.printStackTrace();
	}
	if(flag==-1){
		resp.sendRedirect(req.getContextPath()+"/Check.Enroll");
	}else{
		JOptionPane.showMessageDialog(null, "恭喜您，注册成功！您的用户ID为："+flag);
		req.getRequestDispatcher("/Login.jsp").forward(req, resp);
	    //resp.sendRedirect(req.getContextPath()+"/show.do");
	}
  }
}
