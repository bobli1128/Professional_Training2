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
 * DAO工厂类，以第三方的形式创建DAO对象，实现业务逻辑与数据访问之间的解耦，将业务逻辑层需要用的数据访问对象从外部注入到
 * 业务逻辑层中，从而业务逻辑层不需要知道具体是哪一个数据访问对象实现数据访问功能
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
	 * 静态代码段，相当于匿名函数，应用程序运行过程中只运行一次
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
	 * 静态工厂方法
	 * @return
	 * @throws Exception
	 */
	public static Facility_typeDAO getFacility_typeDAO() throws Exception{
		//获取数据访问实现类的全类名
		String clsname=pro1.getProperty("Facility_typeDAO");
		//获取数据访问实现类的类结构
		Class cls=Class.forName(clsname);
		//创建数据访问实现类的对象
		dao1=(Facility_typeDAO) cls.newInstance();
		return dao1;
	}
//	public static UserInfoDAO getUserInfoDAO() throws Exception{
//		//获取数据访问实现类的全类名
//		String clsname=pro.getProperty("UserInfoDAO");
//		//获取数据访问实现类的类结构
//		Class cls=Class.forName(clsname);
//		//创建数据访问实现类的对象
//		dao=(UserInfoDAO) cls.newInstance();
//		return dao;
//	}
	public static MeetingRoomDAO getMeetingRoomDAO() throws Exception{
		//获取数据访问实现类的全类名
		String clsname=pro2.getProperty("MeetingRoomDAO");
		//获取数据访问实现类的类结构
		Class cls=Class.forName(clsname);
		//创建数据访问实现类的对象
		dao2=(MeetingRoomDAO) cls.newInstance();
		return dao2;
	}
	public static UserInfoDAO getUserInfoDAO() throws Exception{
		//获取数据访问实现类的全类名
		String clsname=pro3.getProperty("UserInfoDAO");
		//获取数据访问实现类的类结构
		Class cls=Class.forName(clsname);
		//创建数据访问实现类的对象
		dao3=(UserInfoDAO) cls.newInstance();
		return dao3;
	}
	public static Meeting_ApplyDAO getMeeting_ApplyDAO() throws Exception{
		//获取数据访问实现类的全类名
		String clsname=pro4.getProperty("Meeting_ApplyDAO");
		//获取数据访问实现类的类结构
		Class cls=Class.forName(clsname);
		//创建数据访问实现类的对象
		dao4=(Meeting_ApplyDAO) cls.newInstance();
		return dao4;
	}
	public static DepartmentDAO getDepartmentDAO() throws Exception{
		//获取数据访问实现类的全类名
		String clsname=pro5.getProperty("DepartmentDAO");
		//获取数据访问实现类的类结构
		Class cls=Class.forName(clsname);
		//创建数据访问实现类的对象
		dao5=(DepartmentDAO) cls.newInstance();
		return dao5;
	}
}
