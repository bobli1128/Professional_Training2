package com.zrgj.BLL;

import java.util.List;

import com.zrgj.DAL.DAO.deptDAO;
import com.zrgj.POJO.dept;
import com.zrgj.Util.DAOFactoryl;


public class deptService {
	
	private deptDAO dao=null;
	
	public deptService(){
		try{
			dao=DAOFactoryl.getdeptDAO();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List<dept> getAlldept() {
		List<dept> List = null;
		try {
			List= dao.read();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return List;
		
	}
	
	public dept getdeptbyid(dept t){
		return dao.readbyid(t.getDepartmentid());
	}
	
	public void CreateNewdept(dept t) {
		 try {
			dao.insert(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void UpdateOlddept(dept t){
		if(dao.readbyid(t.getDepartmentid())!=null){
			dao.update(t);
		}
	}
	
	public void DeleteOlddept(dept t){
		if(dao.readbyid(t.getDepartmentid())!=null){
			dao.delete(t.getDepartmentid());;
			
		}
	}

	
	
	
}
