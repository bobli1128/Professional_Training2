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

import com.zrgj.BLL.Meeting_ApplyService;
import com.zrgj.POJO.Member;
import com.zrgj.POJO.UserInfo;
@SuppressWarnings("serial")
@WebServlet(value={"/MeetingApplySearchbyMUName.do"})
public class MeetingApplySearchbyMUNameController extends HttpServlet {
	Meeting_ApplyService service=new Meeting_ApplyService();
	private ObjectMapper objmapper=null;
	public MeetingApplySearchbyMUNameController() {
		objmapper=new ObjectMapper();
		objmapper.setSerializationInclusion(Inclusion.NON_EMPTY);
		objmapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String muname=req.getParameter("muname");
		UserInfo u=new UserInfo();
		u.setUI_NAME(muname);
		List<Member> list=service.readMeetingApplybyMUName(u);
		String jsonstr=objmapper.writeValueAsString(list);
		resp.getWriter().println(jsonstr);
	}
}
