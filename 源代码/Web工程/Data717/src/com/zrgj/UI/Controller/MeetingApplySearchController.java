package com.zrgj.UI.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.zrgj.BLL.Meeting_ApplyService;
import com.zrgj.POJO.MeetingRoom;
import com.zrgj.POJO.Meeting_Apply;
import com.zrgj.POJO.Member;
import com.zrgj.POJO.UserInfo;
@SuppressWarnings("serial")
@WebServlet(value={"/MeetingApplySearch.do"})
public class MeetingApplySearchController extends HttpServlet {
	Meeting_ApplyService service=new Meeting_ApplyService();
	private ObjectMapper objmapper=null;
	public MeetingApplySearchController() {
		objmapper=new ObjectMapper();
		objmapper.setSerializationInclusion(Inclusion.NON_EMPTY);
		objmapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String MI_NAME=req.getParameter("MI_NAME");
		String MR_NAME=req.getParameter("MR_NAME");
		String MU_NAME=req.getParameter("MU_NAME");
		String MA_TIME=req.getParameter("MA_START");
		String MI_START=req.getParameter("MI_START");
		String MI_END=req.getParameter("MI_END");
		
		String MI_STARTT=req.getParameter("MI_STARTT");
		String MI_ENDT=req.getParameter("MI_ENDT");
		String MA_ENDT=req.getParameter("MA_ST");
		
		String miStart=MI_START+" "+MI_STARTT+":00";
		String miEnd=MI_END+" "+MI_ENDT+":00";
		String maEnd=MA_TIME+" "+MA_ENDT+":00";
		
		Timestamp start_time=Timestamp.valueOf(miStart);
		Timestamp end_time=Timestamp.valueOf(miEnd);
		Timestamp ma_time=Timestamp.valueOf(maEnd);
		
		UserInfo u=new UserInfo();
		List<Member> list=null;
		MeetingRoom mr=new MeetingRoom();
		Meeting_Apply ma=new Meeting_Apply();
		u.setUI_NAME(MU_NAME);
		mr.setMR_NAME(MR_NAME);
		ma.setMI_TITLE(MI_NAME);
		ma.setMI_BOOK_TIME(ma_time);
		ma.setMI_START_TIME(start_time);
		ma.setMI_END_TIME(end_time);
		list=service.readMeeting(u, mr, ma);
		
		if(list==null){
			JOptionPane.showMessageDialog(null, "该会议不存在！");
		}else{
		req.setAttribute("SearchMeet", service.readMeeting(u, mr, ma));
		}
		req.getRequestDispatcher("/MeetingManage/SearchMeeting.jsp").forward(req, resp);
		
	}
	
}
