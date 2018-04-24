package com.zrgj.DAL.DAOImpl;

import java.util.List;

import com.zrgj.DAL.DAO.UserInfoDAO;
import com.zrgj.POJO.UserInfo;
import com.zrgj.jdbc.Util.ConnectionFactory;
import com.zrgj.jdbc.Util.JdbcTemplate;

public class UserInfoDAOImpl implements UserInfoDAO {
private JdbcTemplate<UserInfo> template;
public UserInfoDAOImpl() {
	template=new JdbcTemplate<UserInfo>(ConnectionFactory.getInstance().getConnection());
}
	@Override
	public List<UserInfo> read() throws Exception {
		List<UserInfo> list=null;
		list=template.queryList("select UI_ID,UI_ACCOUNT,UI_PWD,UI_NAME,UI_DEPARTMENT,UI_ROLES,UI_STATUS,UI_TEL,UI_EMAIL from user_info",
				null, new UserInfoRowMapper());
		  return list;
	}
	@Override
	public List<UserInfo> readstatus0() throws Exception {
		List<UserInfo> list=null;
		list=template.queryList("select UI_ID,UI_ACCOUNT,UI_PWD,UI_NAME,UI_DEPARTMENT,UI_ROLES,UI_STATUS,UI_TEL,UI_EMAIL from user_info where UI_STATUS='0'",
				null, new UserInfoRowMapper());
		  return list;
	}
	@Override
	public UserInfo readbynameanduserid(UserInfo u) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo readbyuseridandpassword(UserInfo u) throws Exception {
		return (template.queryList("select UI_ID,UI_ACCOUNT,UI_PWD,UI_NAME,UI_DEPARTMENT,UI_ROLES,UI_STATUS from user_info where UI_ID=? and UI_PWD=?",
				new Object[]{u.getUI_ID(),u.getUI_PWD()}, new UserInfoRowMapper())).get(0);
	}
	@Override
	public UserInfo readbyusernameandpassword(UserInfo u) throws Exception {
		List<UserInfo> list=null;
		list=template.queryList("select UI_ID,UI_ACCOUNT,UI_PWD,UI_NAME,UI_DEPARTMENT,UI_ROLES,UI_STATUS,UI_TEL,UI_EMAIL from user_info where UI_ACCOUNT=? and UI_PWD=?",
				new Object[]{u.getUI_ACCOUNT(),u.getUI_PWD()}, new UserInfoRowMapper());
		return list.get(0);
	}
	@Override
	public void insert(UserInfo u) throws Exception {
	try{
		template.update("insert into user_info(UI_ACCOUNT,UI_PWD,UI_NAME,UI_DEPARTMENT,UI_ROLES,UI_STATUS,UI_TEL,UI_EMAIL) values(?,?,?,?,?,?,?,?)", new Object[]{u.getUI_ACCOUNT(),u.getUI_PWD(),u.getUI_NAME(),u.getUI_DEPARTMENT(),u.getUI_ROLES(),u.getUI_STATUS(),u.getUI_TEL(),u.getUI_EMAIL()});
	}catch(Exception e){
		e.printStackTrace();
	}
	}

	@Override
	public void update(UserInfo u) throws Exception {
		try{
			template.update("update user_info set UI_STATUS='1' where UI_ID=?", 
					new Object[]{u.getUI_ID()});
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	@Override
	public UserInfo readbyuiaccount(UserInfo u) throws Exception {
		List<UserInfo> list=null;
		list=template.queryList("select UI_ID,UI_ACCOUNT,UI_PWD,UI_NAME,UI_DEPARTMENT,UI_ROLES,UI_STATUS,UI_TEL,UI_EMAIL from user_info where UI_ACCOUNT=?",
				new Object[]{u.getUI_ACCOUNT()}, new UserInfoRowMapper());
		if(list.size()==0){return null;}
		else{return list.get(0);}
	}
	@Override
	public List<UserInfo> readbyusernameuseraccountandstatus(UserInfo u) throws Exception {
		List<UserInfo> list=null;
		list=template.queryList("select UI_ID,UI_ACCOUNT,UI_PWD,UI_NAME,UI_DEPARTMENT,UI_ROLES,UI_STATUS,UI_TEL,UI_EMAIL from user_info where UI_NAME=? and UI_ACCOUNT=? and UI_STATUS=?",
				new Object[]{u.getUI_NAME(),u.getUI_ACCOUNT(),u.getUI_STATUS()}, new UserInfoRowMapper());
		  return list;
	}
	@Override
	public List<UserInfo> readbystatus(String status) throws Exception {
		List<UserInfo> list=null;
		list=template.queryList("select UI_ID,UI_ACCOUNT,UI_PWD,UI_NAME,UI_DEPARTMENT,UI_ROLES,UI_STATUS,UI_TEL,UI_EMAIL from user_info where UI_STATUS=?",
				new Object[]{status}, new UserInfoRowMapper());
		return list;
	}
	@Override
	public void delete(int id) {
		try {
			template.update("delete from user_info where UI_ID=?", new Object[]{id});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public UserInfo readbyid(int UI_ID) {
		List<UserInfo> list=null;
		try {
			list=template.queryList("select UI_ID,UI_ACCOUNT,UI_PWD,UI_NAME,UI_DEPARTMENT,UI_ROLES,UI_STATUS,UI_TEL,UI_EMAIL from user_info where UI_ID=?",
					new Object[]{UI_ID}, new UserInfoRowMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(list.size()==0){return null;}
		else{return list.get(0);}
	}
	@Override
	public void Changepwduser1(int UI_ID,String p) {
		
		
		 try {  
	        	 template.update("update user_info set UI_PWD=? where UI_ID=?", new Object[]{p,UI_ID});  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	}
	@Override
	public void updateStatus2(int id) throws Exception {
		template.update("update user_info set UI_STATUS='2' where UI_ID=?", new Object[]{id});
		
	}
	@Override
	public List<UserInfo> getuserbydepa(String depa) throws Exception {
		List<UserInfo> list=null;
		list=template.queryList("select * from user_info where UI_DEPARTMENT=? and UI_STATUS='1'", new Object[]{depa}, new UserInfoRowMapper());
		return list;
	}
	@Override
	public UserInfo readbynameandusername(UserInfo emp) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public UserInfo readbyuseraccountandpassword(UserInfo emp) throws Exception {
		List<UserInfo> list =template.queryList("select UI_ID,UI_ACCOUNT,UI_PWD,UI_NAME,UI_DEPARTMENT,UI_ROLES,UI_STATUS,UI_TEL,UI_EMAIL from user_info where UI_ACCOUNT=? and UI_PWD=?", 
				new Object[]{emp.getUI_ACCOUNT(),emp.getUI_PWD()}, new UserInfoRowMapper());
		UserInfo u =list.get(0);
		return u;
	}
	@Override
	public UserInfo getUseridbyName(String name) throws Exception {
		List<UserInfo> list=null;
		list=template.queryList("select * from user_info where UI_NAME=?", new Object[]{name}, new UserInfoRowMapper());
		UserInfo u=list.get(0);
		return u;
	}
	
	

}
