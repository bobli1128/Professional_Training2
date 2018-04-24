package com.zrgj.DAL.DAOImpl;

import java.sql.ResultSet;

import com.zrgj.POJO.MRApplyInfo;
import com.zrgj.jdbc.Util.RowMapper;

public class MRApplyInfoRowMapper implements RowMapper<MRApplyInfo>{
	@Override
	public MRApplyInfo rowMapper(ResultSet rs) throws Exception{
		MRApplyInfo mr=new MRApplyInfo();
		try{
			mr.setMI_ID(rs.getInt(1));
			mr.setMI_TITLE(rs.getString(2));
			mr.setMI_DEGREE(rs.getInt(3));
			mr.setMI_CONTENT(rs.getString(4));
			mr.setMI_START_TIME(rs.getTimestamp(5));
			mr.setMI_END_TIME(rs.getTimestamp(6));
			mr.setMI_BOOK_TIME(rs.getTimestamp(7));
			mr.setMI_COUNT(rs.getInt(8));
			mr.setMI_ORDER(rs.getString(9));
			mr.setMI_ROOM(rs.getString(10));
			mr.setMI_STATUS(rs.getString(11));
			mr.setMI_DEPA(rs.getString(12));
			mr.setMI_USER_ID(rs.getInt(13));
			mr.setMI_MEETROOM_ID(rs.getInt(14));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return mr;
		}
	}
}
