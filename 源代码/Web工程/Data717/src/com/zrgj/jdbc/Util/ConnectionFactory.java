package com.zrgj.jdbc.Util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
	private static Connection con=null;
	private static ConnectionFactory instance=new ConnectionFactory();
	
	private ConnectionFactory(){
		Properties pro=new Properties();
		InputStream is=ConnectionFactory.class.getClassLoader().getResourceAsStream("db.properties");
		try{
			pro.load(is);
			Class.forName(pro.getProperty("driverClass"));
			con=DriverManager.getConnection(pro.getProperty("url"),
					pro.getProperty("username"), pro.getProperty("password"));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static ConnectionFactory getInstance(){
		return instance;
	}
	
	public Connection getConnection(){
		return con;
	}
}
