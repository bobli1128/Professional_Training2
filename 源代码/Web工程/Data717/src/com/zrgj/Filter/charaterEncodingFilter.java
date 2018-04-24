package com.zrgj.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
@WebFilter(urlPatterns={"*.do","*.Enroll","*.login","*.jsp"},initParams={@WebInitParam(name="encoding",value="utf-8")})
public class charaterEncodingFilter implements Filter {
	private String encoding=null;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		arg0.setCharacterEncoding(encoding);
		arg1.setCharacterEncoding("utf-8");
		//֪ͨ�������Ӧ������html�ı����ı�������utf-8
		arg1.setContentType("text/html;charset=utf-8");
		//�������������������Ӧ����������Ĺ���������Servlet����
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		//�ӹ�������ʼ�������ж�ȡ��������
		encoding=arg0.getInitParameter("encoding");
	}

}
