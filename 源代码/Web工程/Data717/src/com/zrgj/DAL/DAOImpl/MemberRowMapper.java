package com.zrgj.DAL.DAOImpl;

import java.sql.ResultSet;

import com.zrgj.POJO.Member;
import com.zrgj.jdbc.Util.RowMapper;

public class MemberRowMapper implements RowMapper<Member> {

	@Override
	public Member rowMapper(ResultSet rs) throws Exception {
		Member m=new Member();
		m.setMI_NAME(rs.getString(1));
		m.setMR_ADDRESS(rs.getString(2));
        m.setMI_START_TIME(rs.getString(3));
        m.setMI_END_TIME(rs.getString(4));
        m.setMI_BOOK_TIME(rs.getString(5));
        m.setUI_NAME(rs.getString(6));
		return m;
	}

}
