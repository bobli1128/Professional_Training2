package com.zrgj.DAL.DAOImpl;

import java.sql.ResultSet;

import com.zrgj.POJO.UserInfo;
import com.zrgj.jdbc.Util.RowMapper;

public class UserInfoRowMapper implements RowMapper<UserInfo> {

	@Override
	public UserInfo rowMapper(ResultSet rs) throws Exception {
		UserInfo u=new UserInfo();
		u.setUI_ID(rs.getInt(1));
		u.setUI_ACCOUNT(rs.getString(2));
		u.setUI_PWD(rs.getString(3));
		u.setUI_NAME(rs.getString(4));
		u.setUI_DEPARTMENT(rs.getString(5));
		u.setUI_ROLES(rs.getString(6));
		u.setUI_STATUS(rs.getString(7));
		u.setUI_TEL(rs.getString(8));
		u.setUI_EMAIL(rs.getString(9));
		return u;
	}

}
