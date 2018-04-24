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
		//通知浏览器响应内容是html文本，文本编码是utf-8
		arg1.setContentType("text/html;charset=utf-8");
		//过滤器链对象将请求和响应对象向后续的过滤器或者Servlet传递
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		//从过滤器初始化参数中读取编码类型
		encoding=arg0.getInitParameter("encoding");
	}

}
