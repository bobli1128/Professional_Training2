package com.zrgj.DAL.DAOImpl;

import java.sql.ResultSet;
import com.zrgj.POJO.Meeting_Apply;
import com.zrgj.jdbc.Util.RowMapper;

public class Meeting_ApplyRowMapper implements RowMapper<Meeting_Apply> {

	@Override
	public Meeting_Apply rowMapper(ResultSet rs) throws Exception {
		Meeting_Apply ma=new Meeting_Apply();
		ma.setMI_ID(rs.getInt(1));
		ma.setMI_TITLE(rs.getString(2));
	    ma.setMI_DEGREE(rs.getInt(3));
		ma.setMI_CONTENT(rs.getString(4));
		ma.setMI_BOOK_TIME(rs.getTimestamp(5));
		ma.setMI_END_TIME(rs.getTimestamp(6));
		ma.setMI_BOOK_TIME(rs.getTimestamp(7));
		ma.setMI_COUNT(rs.getInt(8));
		ma.setMI_ORDER(rs.getString(9));
		ma.setMI_ROOM(rs.getString(10));
		ma.setMI_STATUS(rs.getString(11));
		ma.setMI_DEPA(rs.getString(12));
		ma.setMI_USER_ID(rs.getInt(13));
		ma.setMI_MEETROOM_ID(rs.getInt(14));
		return ma;
	
	}
	

}
