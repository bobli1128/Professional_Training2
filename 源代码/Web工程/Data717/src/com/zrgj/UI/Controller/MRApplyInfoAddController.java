package com.zrgj.UI.Controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.zrgj.BLL.MRApplyInfoService;
import com.zrgj.BLL.MRinfoService;
import com.zrgj.BLL.Meeting_UserInfoService;
import com.zrgj.BLL.UserInfoService;
import com.zrgj.POJO.MRApplyInfo;
import com.zrgj.POJO.MRinfo;
import com.zrgj.POJO.Meeting_UserInfo;
import com.zrgj.POJO.UserInfo;


@WebServlet(value={"/MRApplyInfo/add.do"})
public class MRApplyInfoAddController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MRApplyInfoService service=new MRApplyInfoService();
	MRinfoService mrservice=new MRinfoService();
	UserInfoService uservice=new UserInfoService();
	Meeting_UserInfoService muservice=new Meeting_UserInfoService();
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String applyer=req.getParameter("applyer");
		int count=Integer.parseInt(req.getParameter("count"));
		String depa=req.getParameter("seldepa");
		String meetingroom=req.getParameter("selmr");
		String desc=req.getParameter("desc");
		
		String startdate=req.getParameter("startdate");
		String starttime=req.getParameter("starttime");
		String start=startdate+" "+starttime+":00";
		
		String bookdate=req.getParameter("bookdate");
		String booktime=req.getParameter("booktime");
		String book=bookdate+" "+booktime+":00";
		
		String enddate=req.getParameter("enddate");
		String endtime=req.getParameter("endtime");
		String end=enddate+" "+endtime+":00";
		
		
		Timestamp start_time=Timestamp.valueOf(start);
		Timestamp end_time=Timestamp.valueOf(end);
		Timestamp book_time=Timestamp.valueOf(book);

		MRApplyInfo mrap=new MRApplyInfo();
		MRApplyInfo mra=new MRApplyInfo();
		MRinfo mr=new MRinfo();
		UserInfo us=new UserInfo();
		
		try {
			mrap=service.GetEndTimebyMrName(meetingroom,start_time,end_time);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		try {
			mr=mrservice.getIdbyNAME(meetingroom);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		System.out.println(mrap);
		if(mrap.getMI_ID()==0){
			try {
				us=uservice.readUserIdbyName(applyer);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			mra.setMI_ORDER(applyer);
			mra.setMI_TITLE(name);
			mra.setMI_COUNT(count);
			mra.setMI_START_TIME(start_time);
			mra.setMI_END_TIME(end_time);
			mra.setMI_BOOK_TIME(book_time);
			mra.setMI_ROOM(meetingroom);
			mra.setMI_MEETROOM_ID(mr.getMR_ID());
			mra.setMI_USER_ID(us.getUI_ID());
			mra.setMI_DEPA(depa);
			mra.setMI_CONTENT(desc);
			mra.setMI_DEGREE(0);
			mra.setMI_STATUS("1");
			
			try {
				mrservice.SetMRStatus(meetingroom);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			int id=0;
			try {
				id=service.CreatNewmRA(mra);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			String str[]=req.getParameterValues("selEmp");
			
			int []a=new int[str.length];
			for(int i=0;i<str.length;i++){
				a[i]=Integer.parseInt(str[i]);
			}
			Meeting_UserInfo mu=new Meeting_UserInfo();
			for(int i=0;i<a.length;i++){
				mu.setMI_ID(id);
				mu.setUI_ID(a[i]);
				try {
					muservice.CreateNewMeetingUser(mu);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			resp.sendRedirect(req.getContextPath()+"/MRApplyInfo/show.do");
		}else{
			JOptionPane.showMessageDialog(null, "当前时间的会议室不可用，请选择其他会议室！");
			resp.sendRedirect(req.getContextPath()+"/MeetingManage/bookmeeting.jsp");
		}
		
	}
}
