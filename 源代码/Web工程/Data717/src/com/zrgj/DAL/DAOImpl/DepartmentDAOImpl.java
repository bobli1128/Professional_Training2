package com.zrgj.DAL.DAOImpl;

import java.util.List;

import com.zrgj.DAL.DAO.DepartmentDAO;
import com.zrgj.POJO.Department;
import com.zrgj.jdbc.Util.ConnectionFactory;
import com.zrgj.jdbc.Util.JdbcTemplate;

public class DepartmentDAOImpl implements DepartmentDAO {
private JdbcTemplate<Department> template=null;
public DepartmentDAOImpl() {
	template=new JdbcTemplate<Department>(ConnectionFactory.getInstance().getConnection());
}
	@SuppressWarnings("finally")
	@Override
	public List<Department> read() throws Exception {
		List<Department> list=null;
		try{
			list=template.queryList("select departmentid,departmentname from department", null, new DepartmentRowMapper());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return list;
		}
	}

	@Override
	public void insert(Department d) throws Exception {
		try{
			template.update("insert into department(departmentname) values(?)", 
					new Object[]{d.getDE_NAME()});
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@SuppressWarnings("finally")
	@Override
	public Department readbyid(int departmentid) {
		Department t=null;
		try{
			t=(template.queryList("select * from department departmentid=?", 
					new Object[]{departmentid}, new DepartmentRowMapper())).get(0);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return t;
		}
	}


	@Override
	public void update(Department d) {
		// TODO Auto-generated method stub
		
	}
	public void update(String name,int id) {
		try{
			template.update("update department set departmentname=? where departmentid=?", 
					new Object[]{name,id});
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int departmentid) {
		try{
			template.update("delete from department where departmentid=?", 
					new Object[]{departmentid});
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
