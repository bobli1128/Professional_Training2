package com.zrgj.DAL.DAOImpl;

import java.sql.ResultSet;

import com.zrgj.POJO.DepaJoinUser;
import com.zrgj.jdbc.Util.RowMapper;

public class DepaJoinUserRowMapper implements RowMapper<DepaJoinUser>{
	@Override
	public DepaJoinUser rowMapper(ResultSet rs) throws Exception {
		DepaJoinUser t=new DepaJoinUser();
		t.setDepartmentid(rs.getInt(10));
		t.setDepartmentname(rs.getString(11));
		t.setUI_ID(rs.getInt(1));
		t.setUI_ACCOUNT(rs.getString(2));
		t.setUI_PWD(rs.getString(3));
		t.setUI_NAME(rs.getString(4));
		t.setUI_DEPARTMENT(rs.getString(5));
		t.setUI_ROLES(rs.getString(6));
		t.setUI_STATUS(rs.getString(7));
		t.setUI_TEL(rs.getString(8));
		t.setUI_EMAIL(rs.getString(9));
		return t;
	}
}
