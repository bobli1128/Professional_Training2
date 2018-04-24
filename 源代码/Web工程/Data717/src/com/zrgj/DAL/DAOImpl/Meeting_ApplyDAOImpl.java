package com.zrgj.DAL.DAOImpl;

import java.util.List;

import com.zrgj.DAL.DAO.Meeting_ApplyDAO;
import com.zrgj.POJO.MeetingRoom;
import com.zrgj.POJO.Meeting_Apply;
import com.zrgj.POJO.Member;
import com.zrgj.POJO.UserInfo;
import com.zrgj.jdbc.Util.ConnectionFactory;
import com.zrgj.jdbc.Util.JdbcTemplate;

public class Meeting_ApplyDAOImpl implements Meeting_ApplyDAO{
	private JdbcTemplate<Meeting_Apply> template;
	private JdbcTemplate<Member> template1;
	private JdbcTemplate<MeetingRoom> templatemr;
	private JdbcTemplate<UserInfo> templateu;
	public Meeting_ApplyDAOImpl(){
		template =new JdbcTemplate<Meeting_Apply>(ConnectionFactory.getInstance().getConnection());
		template1=new JdbcTemplate<Member>(ConnectionFactory.getInstance().getConnection());
		templatemr=new JdbcTemplate<MeetingRoom>(ConnectionFactory.getInstance().getConnection());
	    templateu=new JdbcTemplate<UserInfo>(ConnectionFactory.getInstance().getConnection());
	}

	@SuppressWarnings("finally")
	@Override
	public List<Meeting_Apply> read() throws Exception {
		List<Meeting_Apply> list=null;
		try{
			list=template.queryList("select * from meeting_apply", null,new Meeting_ApplyRowMapper());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return list;
		}
	}

	@Override
	public Meeting_Apply readbymidandtitle(Meeting_Apply m) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Meeting_Apply readbymid(Meeting_Apply m) throws Exception {
		// TODO Auto-generated method stub
		return (template.queryList("select MI_TITLE,MI_START_TIME,MI_END_TIME from Meeting_Apply where MI_ID=?", new Object[]{m.getMI_TITLE(),m.getMI_START_TIME(),m.getMI_END_TIME()}, new Meeting_ApplyRowMapper())).get(0); 
	}

	@Override
	public void insert(Meeting_Apply m) throws Exception {
//		try{
//			template.update("insert into meeting_apply(MI_TITLE,MI_START_TIME,MI_END_TIME,MI_COUNT,MI_OPTION_STATE) values(?,?,?,?,?)", 
//					new Object[]{m.getMI_TITLE(),m.getMI_START_TIME(),m.getMI_END_TIME(),m.getMI_COUNT(),m.getMI_OPTION_STATE()});
//		}catch(Exception e){
//			e.printStackTrace();
//		}
	}

	@Override
	public void update(Meeting_Apply m) throws Exception {

//		try{
//			template.update("update meeting_apply set MI_USER_ID=?,MU_ID=?,MI_MEETING_ID=?,MI_TITLE=?,MI_DEGREE=?,"
//					+ "MI_CONTENT=?,MI_START_TIME=?,MI_END_TIME=?,MI_COUNT=?,MI_STATE=?,MI_OPTION_STATE=?,MI_OPINION=?",
//					new Object[]{m.getMI_USER_ID(),m.getMU_ID(),m.getMI_MEETROOM_ID(),
//							m.getMI_TITLE(),m.getMI_DEGREE(),m.getMI_CONTENT(),m.getMI_START_TIME(),m.getMI_END_TIME(),
//							m.getMI_COUNT(),m.getMI_STATE(),m.getMI_OPTION_STATE(),m.getMI_OPINION()});
//		}catch(Exception e){
//			e.printStackTrace();
//		}
	}

	@Override
	public Meeting_Apply readbyuid(Meeting_Apply m) throws Exception {
		// TODO Auto-generated method stub
		return (template.queryList("select MI_TITLE,MI_START_TIME,MI_END_TIME from Meeting_Apply where MI_USER_ID=?", new Object[]{m.getMI_TITLE(),m.getMI_START_TIME(),m.getMI_END_TIME()}, new Meeting_ApplyRowMapper())).get(0); 
	}

	@Override
	public Meeting_Apply readbymuid(Meeting_Apply m) throws Exception {
		// TODO Auto-generated method stub
		return (template.queryList("select MI_TITLE,MI_START_TIME,MI_END_TIME from Meeting_Apply where UI_ID=?", new Object[]{m.getMI_TITLE(),m.getMI_START_TIME(),m.getMI_END_TIME()}, new Meeting_ApplyRowMapper())).get(0); 

	}

	@Override
	public Meeting_Apply readbycancle(Meeting_Apply m) throws Exception {
		// TODO Auto-generated method stub
		return (template.queryList("select MI_TITLE,MI_START_TIME,MI_END_TIME from Meeting_Apply where MI_OPINION=?", new Object[]{m.getMI_TITLE(),m.getMI_START_TIME(),m.getMI_END_TIME()}, new Meeting_ApplyRowMapper())).get(0); 
	}

	@Override
	public void delete(int id) throws Exception {
		try{
			template.update("delete from meeting_apply where MI_ID=?", new Object[]{id});
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@SuppressWarnings("finally")
	@Override
	public Meeting_Apply readbymiid(int id) throws Exception {
		Meeting_Apply mr=null;
		try{
			mr=(template.queryList("select * from meeting_apply where MI_ID=?", new Object[]{id},
					new Meeting_ApplyRowMapper())).get(0);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return mr;
		}
	}

	@SuppressWarnings("null")
	@Override
	public List<Member> readMemberbyMIName(Meeting_Apply m) throws Exception {
		List<Member> list=null;
		List<Meeting_Apply> list1=null;
		Meeting_Apply m1=null;
		list1=template.queryList("select MI_ID,MI_TITLE,MI_DEGREE,MI_CONTENT,MI_START_TIME,MI_END_TIME,MI_BOOK_TIME,MI_COUNT,"+
		"MI_ORDER,MI_ROOM,MI_STATUS,MI_DEPA,MI_USER_ID,MI_MEETROOM_ID from meeting_apply where MI_TITLE=?",
		new Object[]{m.getMI_TITLE()}, new Meeting_ApplyRowMapper());
		
		if(list1.size()==0){return null;}
		else{
			for(int i=0;i<list1.size();i++){
		m1=list1.get(i);
		List<Member> mem=null;
		mem=template1.queryList("select MI_TITLE,MR_ADDRESS,MI_START_TIME,MI_END_TIME,MI_BOOK_TIME,UI_NAME from meeting_apply "+
       "inner join user_info on UI_ID=MI_USER_ID inner join meeting_room on MR_ID=MI_MEETROOM_ID where UI_ID=? and MR_ID=? and MI_TITLE=?",
       new Object[]{m1.getMI_USER_ID(),m1.getMI_MEETROOM_ID(),m1.getMI_TITLE()},new MemberRowMapper());
		if(i==0){
			list=mem;
			}else{
			if(mem.size()!=0){list.addAll(mem);}
		}
		}
		}
		if(list.size()!=0){
			return list;
		}else{
			return null;
		}
		
	}

	@Override
	public List<Member> readMemberbyMRName(MeetingRoom m) throws Exception {
		List<Member> list=null;
		List<MeetingRoom> list1=null;
		MeetingRoom m1=null;
		Meeting_Apply m2=null;
		list1=templatemr.queryList("select * from meeting_room where MR_NAME=?", new Object[]{m.getMR_NAME()}, new MeetingRoomRowMapper());
		if(list1.size()==0){return null;}
		else{
			for(int i=0;i<list1.size();i++ ){
				m1=list1.get(i);
			List<Meeting_Apply> list2=null;
		list2=template.queryList("select * from meeting_apply where MI_MEETROOM_ID=?", new Object[]{m1.getMR_ID()}, new Meeting_ApplyRowMapper());
		if(list2.size()!=0){
			for(int j=0;j<list2.size();j++){
				m2=list2.get(j);
		List<Member> mem=null;
		mem=template1.queryList("select MI_TITLE,MR_ADDRESS,MI_START_TIME,MI_END_TIME,MI_BOOK_TIME,UI_NAME from meeting_apply "+
       "inner join user_info on UI_ID=MI_USER_ID inner join meeting_room on MR_ID=MI_MEETROOM_ID where UI_ID=? and MR_ID=? and MI_ID=?",
       new Object[]{m2.getMI_USER_ID(),m2.getMI_MEETROOM_ID(),m2.getMI_ID()},new MemberRowMapper());
		if(i==0&&j==0){
			list=mem;
			}else{
			if(mem.size()!=0){list.addAll(mem);}
			}
		}
			}
		}
		}
		if(list!=null){
			return list;
		}else{
			return null;
		}
	}

	@Override
	public List<Member> readMemberbyMUName(UserInfo u) throws Exception {
		List<Member> list=null;
		List<UserInfo> list1=null;
		UserInfo u1=null;
		Meeting_Apply m2=null;
		list1=templateu.queryList("select * from user_info where UI_NAME=?", new Object[]{u.getUI_NAME()}, new UserInfoRowMapper());
		if(list1.size()==0){return null;}
		else{
			for(int i=0;i<list1.size();i++){
				u1=list1.get(i);
				List<Meeting_Apply> list2=null;
		list2=template.queryList("select * from meeting_apply where MI_USER_ID=?", new Object[]{u1.getUI_ID()}, new Meeting_ApplyRowMapper());
		if(list2.size()!=0){
		for(int j=0;j<list2.size();j++){
			m2=list2.get(j);
			List<Member>  mem=null;
		mem=template1.queryList("select MI_TITLE,MR_ADDRESS,MI_START_TIME,MI_END_TIME,MI_BOOK_TIME,UI_NAME from meeting_apply "+
       "inner join user_info on UI_ID=MI_USER_ID inner join meeting_room on MR_ID=MI_MEETROOM_ID where UI_ID=? and MR_ID=? and MI_ID=?",
       new Object[]{m2.getMI_USER_ID(),m2.getMI_MEETROOM_ID(),m2.getMI_ID()},new MemberRowMapper());
		if(i==0&&j==0){
			list=mem;
			}else{
			if(mem.size()!=0){list.addAll(mem);}
			}
		}
		}
			}
		
		}
		if(list!=null){
			return list;
		}else{
			return null;
		}
	}

	@Override
	public List<Member> readMemberbyMUM(UserInfo u, MeetingRoom mr, Meeting_Apply ma) throws Exception {
		List<Member> list=null;
		List<UserInfo> listu=null;
		List<MeetingRoom> listmr=null;
		MeetingRoom mrm=null;
		UserInfo u1=null;
		listmr=templatemr.queryList("select * from meeting_room where MR_NAME=?", new Object[]{mr.getMR_NAME()}, new MeetingRoomRowMapper());
		listu=templateu.queryList("select * from user_info where UI_NAME=?", new Object[]{u.getUI_NAME()}, new UserInfoRowMapper());
		if(listmr.size()==0||listu.size()==0){return list;}
		else{
		for(int i=0;i<listmr.size();i++){
			mrm=listmr.get(i);
			if(mrm!=null){
			for(int j=0;j<listu.size();j++){
		             u1=listu.get(j);
		             if(u1!=null){
		            	 List<Member> mem=null;
		mem=template1.queryList("select MI_TITLE,MR_ADDRESS,MI_START_TIME,MI_END_TIME,MI_BOOK_TIME,UI_NAME from meeting_apply "+
			       " inner join user_info on UI_ID=MI_USER_ID inner join meeting_room on MR_ID=MI_MEETROOM_ID where UI_ID=? and MR_ID=?"+
				" and MI_TITLE=? and MI_BOOK_TIME=? and MI_START_TIME=? and MI_END_TIME=?",
			       new Object[]{u1.getUI_ID(),mrm.getMR_ID(),ma.getMI_TITLE(),ma.getMI_BOOK_TIME(),ma.getMI_START_TIME(),ma.getMI_END_TIME()},new MemberRowMapper());
		if(i==0&&j==0){
			list=mem;
			}else{
			if(mem.size()!=0){list.addAll(mem);}
			}
		             }
					}
			}
		}
		}
		//if(list.size()!=0){
			return list;
		//}else{
			//return null;
		//}
	}
	

}
