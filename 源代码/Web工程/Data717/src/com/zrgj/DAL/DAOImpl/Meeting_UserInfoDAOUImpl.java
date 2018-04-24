package com.zrgj.DAL.DAOImpl;

import java.util.List;

import com.zrgj.DAL.DAO.Meeting_UserInfoDAO;
import com.zrgj.POJO.Meeting_UserInfo;
import com.zrgj.jdbc.Util.ConnectionFactory;
import com.zrgj.jdbc.Util.JdbcTemplate;

public class Meeting_UserInfoDAOUImpl implements Meeting_UserInfoDAO {
	private JdbcTemplate<Meeting_UserInfo> template=null;
	public Meeting_UserInfoDAOUImpl() {
		template=new JdbcTemplate(ConnectionFactory.getInstance().getConnection());
	}
	@Override
	public void insert(Meeting_UserInfo mu) throws Exception {
		template.update("insert into meeting_user(UI_ID,MI_ID) values(?,?)", 
				new Object[]{mu.getUI_ID(),mu.getMI_ID()});
	}
	@Override
	public List<Meeting_UserInfo> getUiIdByMiId(int id) throws Exception {
		return template.queryList("select * from meeting_user where MI_ID=?", 
				new Object[]{id}, new Meeting_UserInfoRowMapper());
	}
	@Override
	public List<Meeting_UserInfo> getMiIdByUiId(int id) throws Exception {
		return template.queryList("select * from meeting_user where UI_ID=?", 
				new Object[]{id}, new Meeting_UserInfoRowMapper());
	}

}
