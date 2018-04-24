package com.zrgj.UI.Controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgj.BLL.MRinfoService;
import com.zrgj.POJO.MRinfo;


/**
 * ���¿�����������������ڸ��²��������л�������β���
 * ��һ�β�����ͨ�������ӽ��뵽�������У���ȡ��Ҫ���µļ�¼���ݣ��������µļ�¼������ʾ����ͼ�У�
 * �ڶ��β������û��༭�����ݺ�������ύ���������ݿ�ĸ��²�����
 * ��һ����GET��ʽ�����ύ���ڶ�����POST��ʽ�����ύ
 * @author Administrator
 *
 */
@WebServlet(value={"/MRinfo/update.do"})
public class MRinfoUpdateController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MRinfoService service=new MRinfoService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		MRinfo t=new MRinfo();
		t.setMR_ID(id);
		try {
			t=service.getMRbyid(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("MRinfo", t);
		req.getRequestDispatcher("/MeetingManage/meetingedit.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String managerId = req.getParameter("manager");
		String idStr = req.getParameter("id");
		String countStr =req.getParameter("count");
		
		String date = req.getParameter("date");
		String time=req.getParameter("time");
		String addtime=date+" "+time+":00";
		Timestamp add_time=Timestamp.valueOf(addtime);
		String status=req.getParameter("status");
		String desc=req.getParameter("desc");
		int manager=Integer.parseInt(managerId);
		int id=Integer.parseInt(idStr);
		int count=Integer.parseInt(countStr);
		MRinfo t=new MRinfo();
		t.setMR_ID(id);
		t.setMR_NAME(name);
		t.setMR_ADDRESS(address);
		t.setMR_COUNT(count);
		t.setMR_MANAGER(manager);
		t.setMR_MONTH(add_time);
		t.setMR_STATUS(status);
		t.setMR_DESC(desc);
		try {
			service.UpdateOldMR(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.sendRedirect(req.getContextPath()+"/RoomShow.do");
	}

}
