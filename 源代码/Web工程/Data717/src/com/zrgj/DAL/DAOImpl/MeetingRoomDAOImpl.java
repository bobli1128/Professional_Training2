package com.zrgj.DAL.DAOImpl;

import java.util.List;

import com.zrgj.DAL.DAO.MeetingRoomDAO;
import com.zrgj.POJO.MeetingRoom;
import com.zrgj.jdbc.Util.ConnectionFactory;
import com.zrgj.jdbc.Util.JdbcTemplate;

public class MeetingRoomDAOImpl implements MeetingRoomDAO {
private JdbcTemplate<MeetingRoom> template=null;

@SuppressWarnings({ "unchecked", "rawtypes" })
public MeetingRoomDAOImpl() {
	template=new JdbcTemplate(ConnectionFactory.getInstance().getConnection());
}
	@Override
	public List<MeetingRoom> read() throws Exception {
	List<MeetingRoom> list=null;
	list=template.queryList("select MR_ID,MR_ADDRESS,MR_NAME,MR_MANAGER,MR_COUNT,MR_MONTH,MR_DESC,MR_STATUS from meeting_room",
			null, new MeetingRoomRowMapper());
		return list;
	}
	@Override
	public MeetingRoom readByid(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void insert(MeetingRoom m) throws Exception {
		try{
			template.update("insert into meeting_room(MR_ADDRESS,MR_NAME,MR_COUNT,MR_STATUS,MR_DESC) values(?,?,?,?,?)", 
					new Object[]{m.getMR_ADDRESS(),m.getMR_NAME(),m.getMR_COUNT(),m.getMR_STATUS(),m.getMR_DESC()});
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	@Override
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(MeetingRoom m) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
