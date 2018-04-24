package com.zrgj.DAL.DAOImpl;

import java.sql.ResultSet;

import com.zrgj.POJO.Facility_type;
import com.zrgj.jdbc.Util.RowMapper;

public class Facility_typeRowMapper implements RowMapper<Facility_type> {

	@Override
	public Facility_type rowMapper(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		Facility_type f=new Facility_type();
		f.setFT_ID(rs.getInt(1));
		f.setFT_NAME(rs.getString(2));
		return f;
	}
 
}
