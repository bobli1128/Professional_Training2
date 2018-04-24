package com.zrgj.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns={"*.do","/MeetingManage/*","/Personals/*"})
public class AuthenticationFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)arg0;
		//�ӻỰSession�����л�ȡ�û���Ϣ���ж��Ƿ��¼��¼�û�
		HttpSession session=req.getSession();
		if(session.getAttribute("UserInfo")!=null){
			arg2.doFilter(arg0, arg1);
		}else{
			//�ỰSession������û�м�¼��¼�û���Ϣ��û���û���¼����ת��¼ҳ��
			HttpServletResponse resp=(HttpServletResponse)arg1;
			resp.sendRedirect(req.getContextPath()+"/Login.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
