package com.zrgj.DAL.DAOImpl;

import com.zrgj.POJO.MRinfo;
import com.zrgj.jdbc.Util.RowMapper;

import java.sql.ResultSet;

public class MRinfoRowMapper implements RowMapper<MRinfo> {

	@Override
	public MRinfo rowMapper(ResultSet rs) throws Exception {
		MRinfo t=new MRinfo();
		try{
			t.setMR_ID(rs.getInt(1));
			t.setMR_ADDRESS(rs.getString(2));
			t.setMR_NAME(rs.getString(3));
			t.setMR_MANAGER(rs.getInt(4));
			t.setMR_COUNT(rs.getInt(5));
			t.setMR_MONTH(rs.getTimestamp(6));
			t.setMR_STATUS(rs.getString(8));
			t.setMR_DESC(rs.getString(7));
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			return t;
		}
		
	}

}
