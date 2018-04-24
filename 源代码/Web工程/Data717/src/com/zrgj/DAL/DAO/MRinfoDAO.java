package com.zrgj.DAL.DAO;

import java.util.List;

import com.zrgj.POJO.MRinfo;

public interface MRinfoDAO {
	public List<MRinfo> read() throws Exception;
	public MRinfo readByid(int id) throws Exception;
	public MRinfo readIDbyName(String name) throws Exception;
	public MRinfo readMRbyName(String name)throws Exception;
	public void setMrStatusByName(String name)throws Exception;
	public void insert(MRinfo t) throws Exception;
	public void delete(int id) throws Exception;
	public void update(MRinfo t) throws Exception;
}