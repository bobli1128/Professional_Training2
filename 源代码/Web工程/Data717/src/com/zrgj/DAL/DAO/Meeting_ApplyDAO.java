package com.zrgj.DAL.DAO;

import java.util.List;

import com.zrgj.POJO.MeetingRoom;
import com.zrgj.POJO.Meeting_Apply;
import com.zrgj.POJO.Member;
import com.zrgj.POJO.UserInfo;

public interface Meeting_ApplyDAO {
	public List<Meeting_Apply> read()throws Exception;
	public Meeting_Apply readbymidandtitle(Meeting_Apply m)throws Exception;
	public Meeting_Apply readbymid(Meeting_Apply m)throws Exception;
	public Meeting_Apply readbyuid(Meeting_Apply m)throws Exception;
	public Meeting_Apply readbymuid(Meeting_Apply m)throws Exception;
	public Meeting_Apply readbycancle(Meeting_Apply m)throws Exception;
	public Meeting_Apply readbymiid(int id)throws Exception;
	public void insert(Meeting_Apply m)throws Exception;
	public void update(Meeting_Apply m)throws Exception;
	public void delete(int id) throws Exception;
	public List<Member> readMemberbyMIName(Meeting_Apply m)throws Exception;
	public List<Member> readMemberbyMRName(MeetingRoom m)throws Exception;
	public List<Member> readMemberbyMUName(UserInfo u)throws Exception;
	public List<Member> readMemberbyMUM(UserInfo u,MeetingRoom mr,Meeting_Apply ma)throws Exception;
}
