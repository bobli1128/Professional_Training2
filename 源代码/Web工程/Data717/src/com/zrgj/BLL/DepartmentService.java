package com.zrgj.BLL;

import java.util.List;

import com.zrgj.DAL.DAO.DepartmentDAO;
import com.zrgj.POJO.Department;
import com.zrgj.Util.DAOFactory;

public class DepartmentService {
private DepartmentDAO dao=null;
public DepartmentService() {
	try {
		dao=DAOFactory.getDepartmentDAO();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public List<Department> getAllDepartment() {
	List<Department> list = null;
	try {
		list= dao.read();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
	
}

public Department getDepartmentbyid(Department d){
	return dao.readbyid(d.getDE_ID());
}

public void CreateNewDepartment(Department d) {
	 try {
		dao.insert(d);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void UpdateOldDepartment(String name ,int id){
	
		dao.update(name, id);
	
}

public void DeleteOlddept(int d){
		dao.delete(d);
		
	
  }
}
