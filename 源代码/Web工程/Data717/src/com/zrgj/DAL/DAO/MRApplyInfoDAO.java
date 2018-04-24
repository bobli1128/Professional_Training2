package com.zrgj.DAL.DAO;

import java.sql.Timestamp;
import java.util.List;

import com.zrgj.POJO.MRApplyInfo;


public interface MRApplyInfoDAO {
	public List<MRApplyInfo> read()throws Exception;
	public List<MRApplyInfo> readAllbyUserId(int id)throws Exception;
	public MRApplyInfo readByid(int id) throws Exception;
	public MRApplyInfo readTimeByMrName(String name,Timestamp starttime,Timestamp endtime)throws Exception;
	public MRApplyInfo readbylist(int id)throws Exception;
	public MRApplyInfo readAllbylist(int id)throws Exception;
	public MRApplyInfo readMTbyName(String name)throws Exception;
	public int insert(MRApplyInfo mra) throws Exception;
	public void delete(int id) throws Exception;
	public void update(MRApplyInfo mra) throws Exception;
}
