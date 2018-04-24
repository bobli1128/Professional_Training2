package com.zrgj.UI.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.zrgj.BLL.UserInfoService;
import com.zrgj.POJO.UserInfo;
@SuppressWarnings("serial")
@WebServlet(value={"/Login.login"})
public class UserInfoLogin extends HttpServlet {
	private UserInfoService service=new UserInfoService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		UserInfo u=new UserInfo();
		u.setUI_ACCOUNT(username);
		u.setUI_PWD(password);
		u=service.login(u);
		//判断登录用户的用户名和密码是否有效，判断登录用户是否属于已审核的
		if(u!=null&& "1".equals(u.getUI_STATUS()) ){
			//使用会话Session对象保存用户信息
			HttpSession session=req.getSession(true);
			session.setAttribute("UserInfo", u);
			//跳转到会议室查看页面
			resp.sendRedirect(req.getContextPath()+"/Index.jsp");
			
		}else{
			if(u==null){
			JOptionPane.showMessageDialog(null, "密码或账户名错误，请确认后重新登录！");
			resp.sendRedirect(req.getContextPath()+"/Login.jsp");
			}else{
			if(!("1".equals(u.getUI_STATUS()))){
			JOptionPane.showMessageDialog(null, "账户名未经审核或已关闭，请确认后重新登录！");
			resp.sendRedirect(req.getContextPath()+"/Login.jsp");	
			}
		  }
		}
	}
}
