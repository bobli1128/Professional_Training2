package com.zrgj.jdbc.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * JdbcTemplateģ�巽���࣬���Ͳ�������ǰģ�崦������POJO����
 * @author Administrator
 *
 * @param <T>
 */
public class JdbcTemplate<T> {
	private Connection con=null;
	/**
	 * ʹ�ù����������Ӷ���ע�뵽��ǰģ����
	 */
	public JdbcTemplate(Connection con){
		this.con=con;
	}
	
	/**
	 * ��ɾ��ͳһģ�巽��
	 * 1.����ִ����������ַ���
	 * 2.ִ��������Ҫ�Ĳ������飬����������Object
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
	 * ��ѯģ�巽����
	 * 1.ִ�в�ѯ������sql����ַ�����
	 * 2.ִ������Ĳ������飬������Ԫ��������Object
	 * 3.ִ��ORMӳ������Ĺ��������
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
