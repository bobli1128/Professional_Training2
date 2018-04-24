package com.zrgj.DAL.DAO;

import java.util.List;
import com.zrgj.POJO.dept;
public interface deptDAO {
	public List<dept> read()throws Exception;
	public void insert(dept t) throws Exception;
	public dept readbyid(int departmentid);
	public void update(dept t);
	public void delete(int departmentid);
}