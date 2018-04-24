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
import com.zrgj.POJO.Meeting_Apply;
import com.zrgj.POJO.Member;
@SuppressWarnings("serial")
@WebServlet(value={"/MeetingApplySearchbyMIName.do"})
public class MeetingApplySearchbyMINameController extends HttpServlet {
Meeting_ApplyService service=new Meeting_ApplyService();
private ObjectMapper objmapper=null;
public MeetingApplySearchbyMINameController() {
	objmapper=new ObjectMapper();
	objmapper.setSerializationInclusion(Inclusion.NON_EMPTY);
	objmapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String miname=req.getParameter("miname");
	Meeting_Apply m=new Meeting_Apply();
	m.setMI_TITLE(miname);
	List<Member> list=service.readMeetingApplybyMIName(m);
	String jsonstr=objmapper.writeValueAsString(list);
	resp.getWriter().println(jsonstr);
}

}
