package com.zrgj.DAL.DAOImpl;

import java.util.List;

import com.zrgj.DAL.DAO.MRinfoDAO;
import com.zrgj.POJO.MRinfo;
import com.zrgj.jdbc.Util.ConnectionFactory;
import com.zrgj.jdbc.Util.JdbcTemplate;

public class MRinfoDAOImpl implements MRinfoDAO {
private JdbcTemplate<MRinfo> template=null;
	
	public MRinfoDAOImpl() {
		template=new JdbcTemplate(ConnectionFactory.getInstance().getConnection());
	}
	@Override
	public List<MRinfo> read() throws Exception {
		List<MRinfo> list=null;
		list=template.queryList("select * from meeting_room",
				null, new MRinfoRowMapper());
		return list;
	}
	@Override
	public void insert(MRinfo t) {
		try{
			template.update("insert into meeting_room(MR_ADDRESS,MR_NAME,MR_COUNT,MR_STATUS,MR_DESC) values(?,?,?,?,?)", 
					new Object[]{t.getMR_ADDRESS(),t.getMR_NAME(),t.getMR_COUNT(),t.getMR_STATUS(),t.getMR_DESC()});
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@SuppressWarnings("finally")
	public MRinfo readByid(int id) {
		MRinfo t=null;
		try{
			t=(template.queryList("select MR_ID,MR_ADDRESS,MR_NAME,MR_MANAGER,MR_COUNT,MR_MONTH,MR_DESC,MR_STATUS from meeting_room where MR_ID=?", 
					new Object[]{id}, new MRinfoRowMapper())).get(0);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return t;
		}
	}

	public void delete(int id) {
		try{
			template.update("delete from meeting_room where MR_ID=?", 
					new Object[]{id});
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void update(MRinfo t) {
		try{
			template.update("update meeting_room set MR_NAME=?,MR_ADDRESS=?,MR_MANAGER=?,MR_COUNT=?,MR_MONTH=?,MR_STATUS=?,MR_DESC=? where MR_ID=?", 
					new Object[]{t.getMR_NAME(),t.getMR_ADDRESS(),t.getMR_MANAGER(),t.getMR_COUNT(),t.getMR_MONTH(),t.getMR_STATUS(),t.getMR_DESC(),
							t.getMR_ID()});
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public MRinfo readIDbyName(String name) throws Exception {
		MRinfo mr=null;
		try{
			mr=(template.queryList("select * from meeting_room where MR_NAME=?", new Object[]{name}, new MRinfoRowMapper())).get(0);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return mr;
		}
	}
	@Override
	public void setMrStatusByName(String name) throws Exception {
		template.update("update meeting_room set MR_STATUS='0' where MR_NAME=?", new Object[]{name});
	}
	@Override
	public MRinfo readMRbyName(String name) throws Exception {
		return (template.queryList("select * from meeting_room where MR_NAME=?", new Object[]{name}, new MRinfoRowMapper())).get(0);
	}
	
}
