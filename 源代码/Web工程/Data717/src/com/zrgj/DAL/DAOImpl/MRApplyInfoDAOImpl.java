package com.zrgj.DAL.DAOImpl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.zrgj.DAL.DAO.MRApplyInfoDAO;
import com.zrgj.POJO.MRApplyInfo;
import com.zrgj.jdbc.Util.ConnectionFactory;
import com.zrgj.jdbc.Util.JdbcTemplate;

public class MRApplyInfoDAOImpl implements MRApplyInfoDAO {
	private JdbcTemplate<MRApplyInfo> template;
	public MRApplyInfoDAOImpl() {
		template=new JdbcTemplate(ConnectionFactory.getInstance().getConnection());
	}
	@SuppressWarnings("finally")
	public List<MRApplyInfo> read() throws Exception {
		List<MRApplyInfo> list=null;
		try{
			list=template.queryList("select * from meeting_apply", null,new MRApplyInfoRowMapper());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return list;
		}
	}
	@SuppressWarnings("finally")
	public MRApplyInfo readByid(int id) throws Exception {
		MRApplyInfo mr=null;
		try{
			mr=(template.queryList("select * from meeting_apply where MI_ID=?", new Object[]{id},
					new MRApplyInfoRowMapper())).get(0);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return mr;
		}
	}

	@Override
	public int insert(MRApplyInfo mra) throws Exception {
		try{
			template.update("insert into meeting_apply(MI_TITLE,MI_DEGREE,MI_START_TIME,MI_END_TIME,MI_BOOK_TIME,"
					+ "MI_COUNT,MI_ORDER,MI_ROOM,MI_CONTENT,MI_MEETROOM_ID,MI_DEPA,MI_STATUS,MI_USER_ID) values(?,?,?,?,?,?,?,?,?,?,?,?,?)", 
					new Object[]{mra.getMI_TITLE(),mra.getMI_DEGREE(),mra.getMI_START_TIME(),mra.getMI_END_TIME(),
							mra.getMI_BOOK_TIME(),mra.getMI_COUNT(),mra.getMI_ORDER(),mra.getMI_ROOM(),
							mra.getMI_CONTENT(),mra.getMI_MEETROOM_ID(),mra.getMI_DEPA(),mra.getMI_STATUS(),mra.getMI_USER_ID()});
		}catch(Exception e){
			e.printStackTrace();
		}
		
		int id=(template.queryList("select * from meeting_apply order by MI_ID desc", null, new MRApplyInfoRowMapper())).get(0).getMI_ID();
		return id;
	}

	@Override
	public void delete(int id) throws Exception {
		try{
			template.update("delete from meeting_apply where MI_ID=?", new Object[]{id});
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void update(MRApplyInfo mra) throws Exception {
		try{
			template.update("update meeting_apply set MI_TITLE=?,MI_DEGREE=?,MI_START_TIME=?,MI_END_TIME=?,MI_BOOK_TIME=?,"
					+ "MI_COUNT=?,MI_ORDER=?,MI_ROOM=?,MI_CONTENT=?,MI_MEETROOM_ID=?,MI_DEPA=?",
					new Object[]{mra.getMI_TITLE(),mra.getMI_DEGREE(),mra.getMI_START_TIME(),mra.getMI_END_TIME(),
							mra.getMI_BOOK_TIME(),mra.getMI_COUNT(),mra.getMI_ORDER(),mra.getMI_ROOM(),
							mra.getMI_CONTENT(),mra.getMI_MEETROOM_ID(),mra.getMI_DEPA()});
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public MRApplyInfo readTimeByMrName(String name,Timestamp starttime,Timestamp endtime) throws Exception {
		MRApplyInfo mra=null;
		mra=(template.queryList("select * from meeting_apply where (MI_ROOM=?) and ((MI_START_TIME between ? and ?)or(MI_END_TIME between ? and ?))", 
				new Object[]{name,starttime,endtime,starttime,endtime}, new MRApplyInfoRowMapper())).get(0);
		System.out.println(mra);
		return mra;
	}
	@Override
	public MRApplyInfo readbylist(int id) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar today = Calendar.getInstance();
		String todayStr = sdf.format(today.getTime());
		today.set(Calendar.DAY_OF_YEAR, today.get(Calendar.DAY_OF_YEAR) + 8);
		String AfterSeven = sdf.format(today.getTime());

		return (template.queryList("select * from meeting_apply where (MI_START_TIME between '"+todayStr+"' and '"+AfterSeven+"') and MI_ID=?", new Object[]{id},
					new MRApplyInfoRowMapper())).get(0);
	}
	@Override
	public List<MRApplyInfo> readAllbyUserId(int id) throws Exception {
		List<MRApplyInfo> list=null;
		list=template.queryList("select * from meeting_apply where MI_USER_ID=?", 
				new Object[]{id}, new MRApplyInfoRowMapper());
		return list;
	}
	@Override
	public MRApplyInfo readAllbylist(int id) throws Exception {
		return (template.queryList("select * from meeting_apply where MI_ID=?", new Object[]{id},
				new MRApplyInfoRowMapper())).get(0);
	}
	@Override
	public MRApplyInfo readMTbyName(String name) throws Exception {
		return (template.queryList("select * from meeting_apply where MI_TITLE=?", new Object[]{name},
				new MRApplyInfoRowMapper())).get(0);
	}

}
