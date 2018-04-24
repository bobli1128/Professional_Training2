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
@WebServlet(value = { "/PasswordChange.do" })
public class PasswordChangeController extends HttpServlet {
	UserInfoService service = new UserInfoService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int UI_ID = Integer.parseInt(req.getParameter("UI_ID"));
		String newpassword = req.getParameter("newpassword");
		String newpasswordAgain = req.getParameter("newpasswordAgain");

		UserInfo t = new UserInfo();
		t.setUI_ID(UI_ID);
		if(newpassword.length()<6){
        	JOptionPane.showMessageDialog(null, "密码长度应为6位以上！修改失败！请重新修改！");
        	resp.sendRedirect(req.getContextPath()+"/Personals/ChangePassword.jsp");  
        }
		else if (newpassword.equals(newpasswordAgain)) {
			service.Changepwduser1(UI_ID, newpassword);
			  JOptionPane.showMessageDialog(null, "密码修改成功！");
			req.setAttribute("user", t);
			resp.sendRedirect(req.getContextPath() + "/Login.jsp");
		} else {
			JOptionPane.showMessageDialog(null, "两次输入的密码不一致！修改失败！");
			req.setAttribute("user", t);
			resp.sendRedirect(req.getContextPath() + "/Personals/ChangePassword.jsp");
		}
	}

}
