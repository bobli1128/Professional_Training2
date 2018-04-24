package com.zrgj.DAL.DAO;

import java.util.List;

import com.zrgj.POJO.Facility_type;

public interface Facility_typeDAO {
	public List<Facility_type> read();
	public Facility_type readbyid(int FT_ID);
	public void insert(Facility_type f);
	public void delete(int FT_ID);
	public void update(Facility_type f);
}
