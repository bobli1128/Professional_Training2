package com.zrgj.Util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.zrgj.DAL.DAO.DepartmentDAO;
import com.zrgj.DAL.DAO.Facility_typeDAO;
import com.zrgj.DAL.DAO.MeetingRoomDAO;
import com.zrgj.DAL.DAO.Meeting_ApplyDAO;
import com.zrgj.DAL.DAO.UserInfoDAO;
import com.zrgj.POJO.Facility_type;
import com.zrgj.POJO.Meeting_Apply;

/**
 * DAO�����࣬�Ե���������ʽ����DAO����ʵ��ҵ���߼������ݷ���֮��Ľ����ҵ���߼�����Ҫ�õ����ݷ��ʶ�����ⲿע�뵽
 * ҵ���߼����У��Ӷ�ҵ���߼��㲻��Ҫ֪����������һ�����ݷ��ʶ���ʵ�����ݷ��ʹ���
 * @author Administrator
 *
 */
public class DAOFactory {
	private static Facility_typeDAO dao1=null;
	private static MeetingRoomDAO dao2=null;
	private static UserInfoDAO dao3=null;
	private static Meeting_ApplyDAO dao4=null;
	private static DepartmentDAO dao5=null;
	private static Properties pro1=null;
	private static Properties pro=null;
	private static Properties pro2=null;
	private static Properties pro3=null;
	private static Properties pro4=null;
	private static Properties pro5=null;
	
	
	/**
	 * ��̬����Σ��൱������������Ӧ�ó������й�����ֻ����һ��
	 */
	static{
		InputStream is=DAOFactory.class.getClassLoader().getResourceAsStream("dao.properties");
		pro1=new Properties();
		try {
			pro1.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static{
		InputStream is=DAOFactory.class.getClassLoader().getResourceAsStream("dao.properties");
		pro=new Properties();
		try {
			pro.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static{
		InputStream is=DAOFactory.class.getClassLoader().getResourceAsStream("dao.properties");
		pro2=new Properties();
		try {
			pro2.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static{
		InputStream is=DAOFactory.class.getClassLoader().getResourceAsStream("dao.properties");
		pro3=new Properties();
		try {
			pro3.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static{
		InputStream is=DAOFactory.class.getClassLoader().getResourceAsStream("dao.properties");
		pro4=new Properties();
		try {
			pro4.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static{
		InputStream is=DAOFactory.class.getClassLoader().getResourceAsStream("dao.properties");
		pro5=new Properties();
		try {
			pro5.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ��̬��������
	 * @return
	 * @throws Exception
	 */
	public static Facility_typeDAO getFacility_typeDAO() throws Exception{
		//��ȡ���ݷ���ʵ�����ȫ����
		String clsname=pro1.getProperty("Facility_typeDAO");
		//��ȡ���ݷ���ʵ�������ṹ
		Class cls=Class.forName(clsname);
		//�������ݷ���ʵ����Ķ���
		dao1=(Facility_typeDAO) cls.newInstance();
		return dao1;
	}
//	public static UserInfoDAO getUserInfoDAO() throws Exception{
//		//��ȡ���ݷ���ʵ�����ȫ����
//		String clsname=pro.getProperty("UserInfoDAO");
//		//��ȡ���ݷ���ʵ�������ṹ
//		Class cls=Class.forName(clsname);
//		//�������ݷ���ʵ����Ķ���
//		dao=(UserInfoDAO) cls.newInstance();
//		return dao;
//	}
	public static MeetingRoomDAO getMeetingRoomDAO() throws Exception{
		//��ȡ���ݷ���ʵ�����ȫ����
		String clsname=pro2.getProperty("MeetingRoomDAO");
		//��ȡ���ݷ���ʵ�������ṹ
		Class cls=Class.forName(clsname);
		//�������ݷ���ʵ����Ķ���
		dao2=(MeetingRoomDAO) cls.newInstance();
		return dao2;
	}
	public static UserInfoDAO getUserInfoDAO() throws Exception{
		//��ȡ���ݷ���ʵ�����ȫ����
		String clsname=pro3.getProperty("UserInfoDAO");
		//��ȡ���ݷ���ʵ�������ṹ
		Class cls=Class.forName(clsname);
		//�������ݷ���ʵ����Ķ���
		dao3=(UserInfoDAO) cls.newInstance();
		return dao3;
	}
	public static Meeting_ApplyDAO getMeeting_ApplyDAO() throws Exception{
		//��ȡ���ݷ���ʵ�����ȫ����
		String clsname=pro4.getProperty("Meeting_ApplyDAO");
		//��ȡ���ݷ���ʵ�������ṹ
		Class cls=Class.forName(clsname);
		//�������ݷ���ʵ����Ķ���
		dao4=(Meeting_ApplyDAO) cls.newInstance();
		return dao4;
	}
	public static DepartmentDAO getDepartmentDAO() throws Exception{
		//��ȡ���ݷ���ʵ�����ȫ����
		String clsname=pro5.getProperty("DepartmentDAO");
		//��ȡ���ݷ���ʵ�������ṹ
		Class cls=Class.forName(clsname);
		//�������ݷ���ʵ����Ķ���
		dao5=(DepartmentDAO) cls.newInstance();
		return dao5;
	}
}
