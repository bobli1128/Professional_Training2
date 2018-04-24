package com.zrgj.BLL;

import java.sql.Timestamp;
import java.util.List;

import com.zrgj.DAL.DAO.MRinfoDAO;
import com.zrgj.POJO.MRinfo;
import com.zrgj.Util.DAOFactory;
import com.zrgj.Util.DAOFactoryl;

public class MRinfoService {
	private MRinfoDAO dao=null;
	
	public MRinfoService(){
		try {
			dao=DAOFactoryl.getMRinfoDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MRinfo> getAllRoom(){
		List<MRinfo> list=null;
		try{
			list=dao.read();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("没有任何会议室信息");
		}finally{
			return list;
		}
	}
	
	public void CreateNewMR1(MRinfo t) throws Exception{
		dao.insert(t);
	}
	
	public MRinfo getMRbyid(MRinfo t) throws Exception{
		return dao.readByid(t.getMR_ID());
	}
	
	public MRinfo getIdbyNAME(String name) throws Exception{
		MRinfo mr=null;
		mr=dao.readIDbyName(name);
		return mr;
	}
	
	public void CreateNewMR(MRinfo t) throws Exception{
		dao.insert(t);
	}
	
	public void UpdateOldMR(MRinfo t) throws Exception{
		if(dao.readByid(t.getMR_ID())!=null){
			dao.update(t);
		}
	}
	
	public void DeleteOldMR(MRinfo t) throws Exception{
		if(dao.readByid(t.getMR_ID())!=null){
			dao.delete(t.getMR_ID());
		}
	}
	
	public void SetMRStatus(String name) throws Exception{
		MRinfo mr=new MRinfo();
		mr=dao.readMRbyName(name);
		if(mr.getMR_STATUS()=="1"){//判断会议室是否可用
			dao.setMrStatusByName(name);
		}
	}
	
}
