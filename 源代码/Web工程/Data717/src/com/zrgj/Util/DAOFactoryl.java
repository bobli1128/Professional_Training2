package com.zrgj.Util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.zrgj.DAL.DAO.UserInfoDAO;
import com.zrgj.DAL.DAO.deptDAO;
import com.zrgj.DAL.DAO.MRApplyInfoDAO;
import com.zrgj.DAL.DAO.MRinfoDAO;
import com.zrgj.DAL.DAO.Meeting_UserInfoDAO;


/**
 * DAO�����࣬�Ե���������ʽ����DAO����ʵ��ҵ���߼������ݷ���֮��Ľ����ҵ���߼�����Ҫ�õ����ݷ��ʶ�����ⲿע�뵽
 * ҵ���߼����У��Ӷ�ҵ���߼��㲻��Ҫ֪����������һ�����ݷ��ʶ���ʵ�����ݷ��ʹ���
 * @author Administrator
 *
 */
public class DAOFactoryl {
	private static UserInfoDAO dao=null;
	private static MRinfoDAO dao1=null;
	private static MRApplyInfoDAO dao2=null;
	private static deptDAO dao3=null;
	private static Meeting_UserInfoDAO dao4=null;
	private static Properties pro=null;
	
	/**
	 * ��̬����Σ��൱������������Ӧ�ó������й�����ֻ����һ��
	 */
	static{
		InputStream is=DAOFactory.class.getClassLoader().getResourceAsStream("dao.properties");
		pro=new Properties();
		try {
			pro.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��̬��������
	 * @return
	 * @throws Exception
	 */
	public static UserInfoDAO getUserInfoDAO() throws Exception{
		//��ȡ���ݷ���ʵ�����ȫ����
		String clsname=pro.getProperty("userInfoDAO");
		//��ȡ���ݷ���ʵ�������ṹ
		Class cls=Class.forName(clsname);
		//�������ݷ���ʵ����Ķ���
		dao=(UserInfoDAO) cls.newInstance();
		
		return dao;
	}
	
	public static MRinfoDAO getMRinfoDAO() throws Exception{
		String clsname1=pro.getProperty("mRinfoDAO");
		Class cls1=Class.forName(clsname1);
		dao1=(MRinfoDAO) cls1.newInstance();
		return dao1;
	}
	public static MRApplyInfoDAO getMRApplyInfoDAO() throws Exception{
		String clsname=pro.getProperty("mRApplyInfoDAO");
		Class cls=Class.forName(clsname);
		dao2=(MRApplyInfoDAO) cls.newInstance();
		return dao2;
	}
	
	public static deptDAO getdeptDAO() throws Exception{
		String clsname=pro.getProperty("DeptDAO");
		Class cls=Class.forName(clsname);
		dao3=(deptDAO) cls.newInstance();
		return dao3;
	}
	
	public static Meeting_UserInfoDAO getMeeting_UserInfoDAO() throws Exception{
		String clsname=pro.getProperty("MeetingUserInfoDao");
		Class cls=Class.forName(clsname);
		dao4=(Meeting_UserInfoDAO) cls.newInstance();
		return dao4;
	}
	
}
