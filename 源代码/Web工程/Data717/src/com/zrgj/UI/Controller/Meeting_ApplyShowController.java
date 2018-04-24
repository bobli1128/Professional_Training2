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

@SuppressWarnings("serial")
@WebServlet(value={"/MeetingApplyShow.do"})
public class Meeting_ApplyShowController extends HttpServlet {
	private Meeting_ApplyService service=new Meeting_ApplyService();
	private ObjectMapper objmapper=null;
	public Meeting_ApplyShowController() {
		objmapper=new ObjectMapper();
		objmapper.setSerializationInclusion(Inclusion.NON_EMPTY);
		objmapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
	}
//	protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
//		try {
//			req.setAttribute("meetings",service.getAllMeeting());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		req.getRequestDispatcher("/show.jsp").forward(req, resp);
//	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Meeting_Apply> list = null;
		try {
			list = service.getAllMeeting();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String mra=objmapper.writeValueAsString(list);
		req.setAttribute("meetings",list );
		resp.getWriter().println(mra);
	}
}
