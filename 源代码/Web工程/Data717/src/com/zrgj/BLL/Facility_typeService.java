package com.zrgj.BLL;

import java.util.List;

import com.zrgj.DAL.DAO.Facility_typeDAO;
import com.zrgj.POJO.Facility_type;
import com.zrgj.Util.DAOFactory;

public class Facility_typeService {
private Facility_typeDAO dao=null;
	
	public Facility_typeService(){
		try{
			dao=DAOFactory.getFacility_typeDAO();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List<Facility_type> getAllFacility_type(){
		return dao.read();
	}
	
	public Facility_type getFacility_typebyid(Facility_type f){
		return dao.readbyid(f.getFT_ID());
	}
	
	public void CreateNewFacility_type(Facility_type f){
		dao.insert(f);
	}
	
	public void UpdateOldFacility_type(Facility_type f){
		if(dao.readbyid(f.getFT_ID())!=null){
			dao.update(f);
		}
	}
	
	public void DeleteOldFacility_type(Facility_type f){
		if(dao.readbyid(f.getFT_ID())!=null){
			dao.delete(f.getFT_ID());;
		}
	}
}
