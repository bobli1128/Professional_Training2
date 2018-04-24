package com.zrgj.UI.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.zrgj.BLL.UserInfoService;
import com.zrgj.POJO.UserInfo;

@WebServlet(value={"/MRApplyInfoDepaEmp/select.do"})
public class MRApplyInfoSelDepaAndUserConteoller extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserInfoService service=new UserInfoService();
	private ObjectMapper objmapper=null;
	
	public MRApplyInfoSelDepaAndUserConteoller() {
		objmapper=new ObjectMapper();
		objmapper.setSerializationInclusion(Inclusion.NON_EMPTY);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String depa=req.getParameter("depa");
		List<UserInfo> list=null;
		try {
			list=service.getallUserbyDepa(depa);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsonstr=objmapper.writeValueAsString(list);
		System.out.println("jsonstr"+jsonstr);
		resp.getWriter().println(jsonstr);
	}
	
}
