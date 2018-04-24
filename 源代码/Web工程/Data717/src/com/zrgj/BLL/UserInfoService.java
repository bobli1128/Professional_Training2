package com.zrgj.BLL;

import java.util.List;

import com.zrgj.DAL.DAO.UserInfoDAO;
import com.zrgj.POJO.UserInfo;
import com.zrgj.Util.DAOFactory;

public class UserInfoService {
	private UserInfoDAO dao=null;
	public UserInfoService() {
		try{
			dao=DAOFactory.getUserInfoDAO();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public List<UserInfo> getAllUser() throws Exception{
		return dao.read();
	}
	public UserInfo getUserInfobyid(UserInfo u){
		return null;
	}
	@SuppressWarnings("finally")
	public UserInfo login(UserInfo u){
		UserInfo u1=null;
		try{
			u1=dao.readbyusernameandpassword(u);
		}catch(Exception e){
		}finally{
			return u1;
		}
	}
	public int CreatNewUser(UserInfo u) throws Exception{
            UserInfo u1=null;
			u1=dao.readbyuiaccount(u);
			if(u1==null){
		       dao.insert(u);
		       u1=dao.readbyuiaccount(u);
		       return u1.getUI_ID();
	        	}
			else{
				return -1; 
			}
	}
	@SuppressWarnings("finally")
	public UserInfo IsUniql(UserInfo u){
		UserInfo u1=null;
		
		try{
			u1=dao.readbyuiaccount(u);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return u1;
		}
	}
	@SuppressWarnings("finally")
	public List<UserInfo> GetUserbyNameAccountandStatus(UserInfo u){
		List<UserInfo> u1=null;
		try{
			u1=dao.readbyusernameuseraccountandstatus(u);
		}catch(Exception e){
		}finally{
			return u1;
		}
	}
	@SuppressWarnings("finally")
	public List<UserInfo> getUserbyStatues(String status){
		List<UserInfo> list=null;
		try {
			list=dao.readbystatus(status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return list;
		}
	}
	public void DeleteOlduser(UserInfo u) {
		if(dao.readbyid(u.getUI_ID())!=null){
			dao.delete(u.getUI_ID());;
			
		}
		
	}
	public void UpdateOlduser(UserInfo u){
		if(dao.readbyid(u.getUI_ID())!=null){
			try {
				dao.update(u);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void Changepwduser1(int UI_ID,String p) {
		if(dao.readbyid(UI_ID)!=null){
			try {
				dao.Changepwduser1(UI_ID,p);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public List<UserInfo> getNoneAppUser() throws Exception{
		return dao.readstatus0();
	}
	public void CloseUser(int id){
		try {
			dao.updateStatus2(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public UserInfo readUserIdbyName(String name) throws Exception{
		UserInfo us=new UserInfo();
		us=dao.getUseridbyName(name);
		return us;
	}
	
	public List<UserInfo> getallUserbyDepa(String depa) throws Exception{
		List<UserInfo> list=null;
		list=dao.getuserbydepa(depa);
		return list;
	}
}
