package com.zrgj.BLL;

import java.util.List;

import com.zrgj.DAL.DAO.Meeting_UserInfoDAO;
import com.zrgj.Util.DAOFactory;
import com.zrgj.Util.DAOFactoryl;
import com.zrgj.POJO.Meeting_UserInfo;

public class Meeting_UserInfoService {
	private Meeting_UserInfoDAO dao=null;
	public Meeting_UserInfoService(){
		try{
			dao=DAOFactoryl.getMeeting_UserInfoDAO();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void CreateNewMeetingUser(Meeting_UserInfo mu) throws Exception{
		dao.insert(mu);
	}
	
	public List<Meeting_UserInfo> readUiIdBYMiId(int id) throws Exception{
		return dao.getUiIdByMiId(id);
	}
	
	public List<Meeting_UserInfo> readMiIdBYUiId(int id) throws Exception{
		return dao.getMiIdByUiId(id);
	}
	
}
