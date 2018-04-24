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
 * DAO工厂类，以第三方的形式创建DAO对象，实现业务逻辑与数据访问之间的解耦，将业务逻辑层需要用的数据访问对象从外部注入到
 * 业务逻辑层中，从而业务逻辑层不需要知道具体是哪一个数据访问对象实现数据访问功能
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
	 * 静态代码段，相当于匿名函数，应用程序运行过程中只运行一次
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
	 * 静态工厂方法
	 * @return
	 * @throws Exception
	 */
	public static UserInfoDAO getUserInfoDAO() throws Exception{
		//获取数据访问实现类的全类名
		String clsname=pro.getProperty("userInfoDAO");
		//获取数据访问实现类的类结构
		Class cls=Class.forName(clsname);
		//创建数据访问实现类的对象
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
