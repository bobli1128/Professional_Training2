package com.zrgj.jdbc.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * JdbcTemplate模板方法类，泛型操作，当前模板处理哪种POJO对象
 * @author Administrator
 *
 * @param <T>
 */
public class JdbcTemplate<T> {
	private Connection con=null;
	/**
	 * 使用构造器将链接对象注入到当前模板中
	 */
	public JdbcTemplate(Connection con){
		this.con=con;
	}
	
	/**
	 * 增删改统一模板方法
	 * 1.参数执行命令语句字符串
	 * 2.执行命令需要的参数数组，数组类型是Object
	 */
	public void update(String sql,Object[] args)throws Exception{
		PreparedStatement ps=con.prepareStatement(sql);
		for(int i=0;i<args.length;i++){
			ps.setObject(i+1, args[i]);
		}
		ps.executeUpdate();
		ps.close();
	}
	
	/**
	 * 查询模板方法，
	 * 1.执行查询操作的sql语句字符串；
	 * 2.执行命令的参数数组，数组中元素类型是Object
	 * 3.执行ORM映射操作的功能类对象
	 */
	public List<T> queryList(String sql,Object[] args,RowMapper<T> rowMapper)throws Exception{
		List<T> list=new ArrayList<T>();
		PreparedStatement ps=con.prepareStatement(sql);
		if(args!=null){
			for(int i=0;i<args.length;i++){
				ps.setObject(i+1, args[i]);
			}
		}
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			list.add(rowMapper.rowMapper(rs));
		}
		rs.close();
		ps.close();
		return list;
	}
}
