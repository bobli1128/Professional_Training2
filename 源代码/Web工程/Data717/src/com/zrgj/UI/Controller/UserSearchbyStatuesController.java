package com.zrgj.UI.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
@SuppressWarnings("serial")
@WebServlet(value={"/UserSearchbyStatues.do"})
public class UserSearchbyStatuesController extends HttpServlet {
private UserInfoService service=new UserInfoService();
private ObjectMapper objmapper=null;
public UserSearchbyStatuesController() {
	objmapper=new ObjectMapper();
	objmapper.setSerializationInclusion(Inclusion.NON_EMPTY);
	objmapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String status=req.getParameter("status");
	int pageindex=0;
	int pagesize=2;
	List<UserInfo> list=service.getUserbyStatues(status);
	String jsonstr=objmapper.writeValueAsString(list);
	System.out.println(jsonstr);
	resp.getWriter().println(jsonstr);
}

}
