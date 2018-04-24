package com.zrgj.DAL.DAOImpl;

import java.util.List;

import com.zrgj.DAL.DAO.Facility_typeDAO;
import com.zrgj.POJO.Facility_type;
import com.zrgj.jdbc.Util.ConnectionFactory;
import com.zrgj.jdbc.Util.JdbcTemplate;

public class Facility_typeDAOImpl implements Facility_typeDAO {
	private JdbcTemplate<Facility_type> template=null;
	public Facility_typeDAOImpl() {
		template=new JdbcTemplate(ConnectionFactory.getInstance().getConnection());
	}
	@Override
	public List<Facility_type> read() {
		List<Facility_type> list=null;
		try{
			list=template.queryList("select FT_ID,FT_NAME from Facility_type", null, new Facility_typeRowMapper());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return list;
		}
	}

	@Override
	public Facility_type readbyid(int FT_ID) {
		Facility_type f=null;
		try{
			f=(template.queryList("select FT_ID,FT_NAME from Facility_type where FT_ID=?", 
					new Object[]{FT_ID}, new Facility_typeRowMapper())).get(0);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return f;
		}
	}

	@Override
	public void insert(Facility_type f) {
		try{
			template.update("insert into Facility_type(FT_NAME) values(?)", 
					new Object[]{f.getFT_NAME()});
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int FT_ID) {
		try{
			template.update("delete from Facility_type where FT_ID=?", 
					new Object[]{FT_ID});
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void update(Facility_type f) {
		try{
			template.update("update Facility_type set FT_NAME=? where FT_ID=?", 
					new Object[]{f.getFT_NAME(),f.getFT_ID()});
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
