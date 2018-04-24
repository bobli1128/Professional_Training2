package com.zrgj.DAL.DAO;

import java.util.List;

import com.zrgj.POJO.Meeting_UserInfo;

public interface Meeting_UserInfoDAO {
	public void insert(Meeting_UserInfo mu)throws Exception;
	public List<Meeting_UserInfo> getUiIdByMiId(int id)throws Exception;
	public List<Meeting_UserInfo> getMiIdByUiId(int id)throws Exception;
}
