package com.njwb.oa.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;


/**
 * jdbc的工具类
 * 负责产生连接
 * 关闭连接
 * @author Administrator
 *
 */
public class JdbcUtil {
	//将来的Connection跟谁要？不是DriverManager,而是DataSource
	private static DataSource ds;//ds是一个接口，dbcp实现
	
	//目的是让不同的线程都拥有一个属于自己的Connection
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	
	static{
		//封装了数据库的连接信息
		// 驱动名   url  userName  pwd--->一个配置文件中  dataSource.properties
		Properties p = new Properties();
		try {
			//p.load(new FileInputStream(new File("src/dataSource.properties")));
			p.load(JdbcUtil.class.getClassLoader().getResourceAsStream("dataSource.properties"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			ds = BasicDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * 分析：线程A 调用UserService
	 * {
	 *     regist(){
	 *        Connecion conn = JdbcUtil.getConnetion()
	 *        
	 *        conn.setAutoCommit(false)
	 *        
	 *        userDao.add();
	 *     
	 *     
	 *     }
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * UserDao{
	 * 	add(){
	 * 		conn = JdbcUtil.getConnection();
	 *   }
	 * 
	 * }
	 * 获取连接
	 * @return
	 */
	public static Connection getConnection(){
		//dao需要Connection
		//service也需要Connection--->threadLocal
		
		Connection conn = threadLocal.get();
		if(null == conn){//一个线程首次访问getConnection
			//向ds要
			try {
				conn = ds.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			//将conn绑定到线程中
			threadLocal.set(conn);
		}
		
		return threadLocal.get();
		
	}
	
	
	/**
	 * 关闭  pstmt  rs
	 * @param pstmt
	 * @param rs
	 */
	public static void close(PreparedStatement pstmt,ResultSet rs){
		if(null != rs){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(null != pstmt){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 事务做完以后 jdbc操作全部结束，关闭Connection,将Connection还给连接池
	 * 
	 * 同时ThreadLocal中的Connection清除
	 * 
	 * 关闭ResultSet
	 */
	public static void close(){
		Connection conn = threadLocal.get();
		//清除threadLocal
		threadLocal.remove();
		
		try {
			conn.close();//close方法已经被重写，不再是直接销毁，而是归还给连接池
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
