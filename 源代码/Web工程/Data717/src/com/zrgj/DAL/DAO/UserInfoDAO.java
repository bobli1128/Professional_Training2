package com.zrgj.DAL.DAO;

import java.util.List;

import com.zrgj.POJO.UserInfo;

public interface UserInfoDAO {
	public List<UserInfo> read()throws Exception;
	public List<UserInfo> readstatus0()throws Exception;
	public UserInfo readbynameanduserid(UserInfo u)throws Exception;
	public UserInfo readbyuseridandpassword(UserInfo u)throws Exception;
	public UserInfo readbyusernameandpassword(UserInfo u)throws Exception;
	public UserInfo readbyuiaccount(UserInfo u)throws Exception;
	public List<UserInfo> readbyusernameuseraccountandstatus(UserInfo u)throws Exception;
	public void insert(UserInfo u) throws Exception;
	public void update(UserInfo u) throws Exception;
	public void delete(int id);
	public UserInfo readbyid(int UI_ID);
	public List<UserInfo> readbystatus(String status)throws Exception;
	public void Changepwduser1(int UI_ID,String p)throws Exception;
	public void updateStatus2(int id)throws Exception;
	public List<UserInfo> getuserbydepa(String depa)throws Exception;
	public UserInfo readbynameandusername(UserInfo emp)throws Exception;
	public UserInfo readbyuseraccountandpassword(UserInfo emp)throws Exception;
	public UserInfo getUseridbyName(String name)throws Exception;
}
