package com.zrgj.BLL;

import java.util.List;

import com.zrgj.DAL.DAO.MeetingRoomDAO;
import com.zrgj.POJO.MeetingRoom;
import com.zrgj.Util.DAOFactory;

public class MeetingRoomService {
private MeetingRoomDAO dao=null;
public MeetingRoomService() {
	try{
	dao=DAOFactory.getMeetingRoomDAO();
	}catch (Exception e) {
		e.printStackTrace();
	}
}
@SuppressWarnings("finally")
public List<MeetingRoom> GetAllMeetingRooms(){
	List<MeetingRoom> list=null;
	try{
		list=dao.read();
	}catch(Exception e){
		e.getStackTrace();
	}finally{
		return list;
	}
  }
public void CreatNewRoom(MeetingRoom m){
	try {
		dao.insert(m);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
