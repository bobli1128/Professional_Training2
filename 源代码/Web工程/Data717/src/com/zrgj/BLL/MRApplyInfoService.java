package com.zrgj.BLL;

import java.sql.Timestamp;
import java.util.List;

import com.zrgj.DAL.DAO.MRApplyInfoDAO;
import com.zrgj.POJO.MRApplyInfo;
import com.zrgj.Util.DAOFactory;
import com.zrgj.Util.DAOFactoryl;


public class MRApplyInfoService {
	private MRApplyInfoDAO dao=null;
	public MRApplyInfoService(){
		try{
			dao=DAOFactoryl.getMRApplyInfoDAO();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public List<MRApplyInfo> getALLmRA() throws Exception{
		List<MRApplyInfo> list=null;
		try{
			list=dao.read();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("没有任何会议预定记录！");
		}
		return list;
	}
	
	public MRApplyInfo getMRbyUiID(int id) throws Exception{
		return dao.readbylist(id);
	}
	
	public MRApplyInfo getAllMRbyUiID(int id) throws Exception{
		return dao.readAllbylist(id);
	}
	
	public MRApplyInfo getmRAbyid(MRApplyInfo mra) throws Exception{
		return dao.readByid(mra.getMI_ID());
	}
	
	public int CreatNewmRA(MRApplyInfo mra) throws Exception{
		int id=dao.insert(mra);
		return id;
	}
	
	public void DeleteOldmRA(MRApplyInfo mra) throws Exception{
		if(dao.readByid(mra.getMI_ID())!=null){
			dao.delete(mra.getMI_ID());			
		}
	}
	
	public void UpdateOldmRA(MRApplyInfo mra) throws Exception{
		if(dao.readByid(mra.getMI_ID())!=null){
			dao.update(mra);
		}
	}
	
	public MRApplyInfo GetEndTimebyMrName(String name,Timestamp starttime,Timestamp endtime) throws Exception{
		MRApplyInfo mra=null;
		mra=dao.readTimeByMrName(name,starttime,endtime);
		return mra;
	}
	
	public List<MRApplyInfo> GetAllByUserId(int id) throws Exception{
		return dao.readAllbyUserId(id);
	}
	
	public MRApplyInfo GetMTbyName(String name) throws Exception{
		return dao.readMTbyName(name);
	}
	
}
