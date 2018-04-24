package com.zrgj.DAL.DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.zrgj.POJO.Meeting_UserInfo;
import com.zrgj.jdbc.Util.RowMapper;


public class Meeting_UserInfoRowMapper implements RowMapper<Meeting_UserInfo>{
	@Override
	public Meeting_UserInfo rowMapper(ResultSet rs) throws SQLException{
		Meeting_UserInfo mu=new Meeting_UserInfo();
		try{
			mu.setMU_ID(rs.getInt(1));
			mu.setUI_ID(rs.getInt(2));
			mu.setMI_ID(rs.getInt(3));
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			return mu;
		}
	}
}
