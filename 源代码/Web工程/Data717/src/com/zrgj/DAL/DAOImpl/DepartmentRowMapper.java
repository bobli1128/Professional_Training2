package com.zrgj.DAL.DAOImpl;

import java.sql.ResultSet;

import com.zrgj.POJO.Department;
import com.zrgj.jdbc.Util.RowMapper;

public class DepartmentRowMapper implements RowMapper<Department> {

	@Override
	public Department rowMapper(ResultSet rs) throws Exception {
		Department d=new Department();
		d.setDE_ID(rs.getInt(1));
		d.setDE_NAME(rs.getString(2));
		return d;
	}

}
