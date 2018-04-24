package com.zrgj.UI.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgj.BLL.MeetingRoomService;
@SuppressWarnings("serial")
@WebServlet(value={"/RoomShow.do"})
public class MeetingRoomShowController extends HttpServlet {
private MeetingRoomService service=new MeetingRoomService();

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setAttribute("rooms", service.GetAllMeetingRooms());
	req.getRequestDispatcher("/MeetingManage/ViewOffice.jsp").forward(req, resp);
}

}
