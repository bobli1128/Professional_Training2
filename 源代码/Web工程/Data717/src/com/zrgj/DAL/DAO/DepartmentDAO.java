package com.zrgj.DAL.DAO;

import java.util.List;

import com.zrgj.POJO.Department;

public interface DepartmentDAO {
	public List<Department> read()throws Exception;
	public void insert(Department d) throws Exception;
	public Department readbyid(int departmentid);
	public void update(Department d);
	public void delete(int departmentid);
	void update(String name, int id);
}
