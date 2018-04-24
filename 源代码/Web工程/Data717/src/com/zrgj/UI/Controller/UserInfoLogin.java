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
		//�жϵ�¼�û����û����������Ƿ���Ч���жϵ�¼�û��Ƿ���������˵�
		if(u!=null&& "1".equals(u.getUI_STATUS()) ){
			//ʹ�ûỰSession���󱣴��û���Ϣ
			HttpSession session=req.getSession(true);
			session.setAttribute("UserInfo", u);
			//��ת�������Ҳ鿴ҳ��
			resp.sendRedirect(req.getContextPath()+"/Index.jsp");
			
		}else{
			if(u==null){
			JOptionPane.showMessageDialog(null, "������˻���������ȷ�Ϻ����µ�¼��");
			resp.sendRedirect(req.getContextPath()+"/Login.jsp");
			}else{
			if(!("1".equals(u.getUI_STATUS()))){
			JOptionPane.showMessageDialog(null, "�˻���δ����˻��ѹرգ���ȷ�Ϻ����µ�¼��");
			resp.sendRedirect(req.getContextPath()+"/Login.jsp");	
			}
		  }
		}
	}
}
