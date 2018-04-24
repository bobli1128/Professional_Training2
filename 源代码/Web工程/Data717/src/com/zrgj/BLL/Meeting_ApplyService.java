package com.zrgj.BLL;

import java.util.List;

import com.zrgj.DAL.DAO.Meeting_ApplyDAO;
import com.zrgj.POJO.MeetingRoom;
import com.zrgj.POJO.Meeting_Apply;
import com.zrgj.POJO.Member;
import com.zrgj.POJO.UserInfo;
import com.zrgj.Util.DAOFactory;

public class Meeting_ApplyService {
	private Meeting_ApplyDAO dao=null;
	public Meeting_ApplyService(){
		try{
			dao=DAOFactory.getMeeting_ApplyDAO();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public List<Meeting_Apply> getAllMeeting() throws Exception{
		return dao.read();
	}
	@SuppressWarnings("finally")
	public Meeting_Apply  getMeeting_Applybymid(Meeting_Apply m){
		Meeting_Apply ma=null;
		try {
			ma=dao.readbymiid(m.getMI_ID());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return ma;
		}
	}
	public void CreatNewMra(Meeting_Apply mra) throws Exception{
		dao.insert(mra);
	}
	public void DeleteOldMra(Meeting_Apply mra) throws Exception{
		if(dao.readbymiid(mra.getMI_ID())!=null){
			dao.delete(mra.getMI_ID());			
		}
	}
	public void UpdateOldMra(Meeting_Apply mra) throws Exception{
		if(dao.readbymiid(mra.getMI_ID())!=null){
			dao.update(mra);
		}
	}
	public List<Member> readMeetingApplybyMIName(Meeting_Apply m){
		List<Member> list=null;
		try {
			list=dao.readMemberbyMIName(m);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Member> readMeetingApplybyMRName(MeetingRoom m){
		List<Member> list=null;
		try {
			list=dao.readMemberbyMRName(m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<Member> readMeetingApplybyMUName(UserInfo u){
		List<Member> list=null;
		try {
			list=dao.readMemberbyMUName(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<Member> readMeeting(UserInfo u,MeetingRoom mr,Meeting_Apply ma){
		List<Member> list=null;
		try {
			list=dao.readMemberbyMUM(u, mr, ma);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("finally")
	public Meeting_Apply getMeetingbyID(int id){
		Meeting_Apply list=null;
		try {
			list=dao.readbymiid(id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return list;
		}
	}
}
