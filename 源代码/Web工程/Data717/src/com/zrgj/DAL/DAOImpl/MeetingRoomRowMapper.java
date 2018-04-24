package com.zrgj.DAL.DAOImpl;
import java.sql.ResultSet;

import com.zrgj.POJO.MeetingRoom;
import com.zrgj.jdbc.Util.RowMapper;

public class MeetingRoomRowMapper implements RowMapper<MeetingRoom> {
@SuppressWarnings("finally")
@Override
public MeetingRoom rowMapper(ResultSet rs) throws Exception {
	MeetingRoom mr=new MeetingRoom();
	try{
		mr.setMR_ID(rs.getInt(1));
		mr.setMR_ADDRESS(rs.getString(2));
		mr.setMR_NAME(rs.getString(3));
		mr.setMR_MANAGER(rs.getInt(4));
		mr.setMR_COUNT(rs.getShort(5));
		mr.setMR_MONTH(rs.getInt(6));
		mr.setMR_DESC(rs.getString(7));
		mr.setMR_STATUS(rs.getString(8));
	}catch(Exception e){
		e.printStackTrace();
		System.out.println(mr);
	}finally{
		return mr;
	}
}
}
