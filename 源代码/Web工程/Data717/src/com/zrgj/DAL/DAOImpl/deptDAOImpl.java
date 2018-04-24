package com.zrgj.DAL.DAOImpl;

import java.util.List;

import com.zrgj.DAL.DAO.deptDAO;
import com.zrgj.POJO.dept;
import com.zrgj.jdbc.Util.ConnectionFactory;
import com.zrgj.jdbc.Util.JdbcTemplate;

public class deptDAOImpl implements deptDAO {

	private JdbcTemplate<dept> template=null;
	public deptDAOImpl(){
		template=new JdbcTemplate(ConnectionFactory.getInstance().getConnection());
	}
	@Override
	public List<dept> read() {
		List<dept> list=null;
		try{
			list=template.queryList("select * from department", null, new deptRowMapper());
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("没有部门信息");
		}finally{
			return list;
		}
		
	}

	@Override
	public dept readbyid(int id) {
		dept t=null;
		try{
			t=(template.queryList("select * from department where departmentid=?", 
					new Object[]{id}, new deptRowMapper())).get(0);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return t;
		}
	}

	@Override
	public void insert(dept t) {
		try{
			template.update("insert into department(departmentname) values(?)", 
					new Object[]{t.getDepartmentname()});
			System.out.println(t);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try{
			template.update("delete from department where departmentid=?", 
					new Object[]{id});
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void update(dept t) {
		try{
			template.update("update department set departmentname=? where departmentid=?", 
					new Object[]{t.getDepartmentname(),t.getDepartmentid()});
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
