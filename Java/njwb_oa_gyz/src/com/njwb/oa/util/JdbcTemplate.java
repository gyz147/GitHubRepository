package com.njwb.oa.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 * jdbc的模版类
 * 公共的模版方法
 * executeUpdate
 * executeQuery
 * @author Administrator
 *
 */
public class JdbcTemplate {
	/**
	 * 执行insert update delete的模版方法
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public static int executeUpdate(String sql,Object ... params) throws SQLException{
		int count = 0;
		//1.加载驱动----连接池实现
		//2.获得连接
		Connection conn = JdbcUtil.getConnection();
		
		//3.获取sql执行器
		PreparedStatement pstmt = null;
		
		pstmt = conn.prepareStatement(sql);
		//设置参数
		setParams(pstmt, params);
		//4.执行sql
		count = pstmt.executeUpdate();
		
		//5.关闭资源  Connection在Service层统一关
		JdbcUtil.close(pstmt, null);
		return count;
	}
	
	
	/**
	 * 执行select的模版方法
	 * @param sql
	 * @param rowMapper
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public static List executeQuery(String sql,RowMapper rowMapper, Object ... params) throws SQLException{
		List dataList = new ArrayList();
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = null;
		
		pstmt = conn.prepareStatement(sql);
		//设置参数
		setParams(pstmt, params);
		
		ResultSet rs = null;
		
		rs = pstmt.executeQuery();
		while(rs.next()){
			Object obj = rowMapper.mapperObject(rs);
			dataList.add(obj);
		}
		
		JdbcUtil.close(pstmt, rs);
		
		return dataList;
	}
	
	private static void setParams(PreparedStatement pstmt,Object ... params) throws SQLException{
		if(null != params && params.length > 0){
			for(int i = 0; i < params.length; i++){
				pstmt.setObject(i + 1, params[i]);
			}
		}
	}
}
