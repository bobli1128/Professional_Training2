package com.zrgj.DAL.DAOImpl;

import java.sql.ResultSet;

import com.zrgj.POJO.dept;
import com.zrgj.jdbc.Util.RowMapper;

public class deptRowMapper implements RowMapper<dept> {

	@Override
	public dept rowMapper(ResultSet rs) throws Exception {
		dept t=new dept();
		t.setDepartmentid(rs.getInt(1));
		t.setDepartmentname(rs.getString(2));
		return t;
	}

}
