package com.dearlg.game.dao;

import java.sql.SQLException;
import java.util.List;

import com.dearlg.game.entity.DownloadRecord;

/**
 * 用户下载记录数据的操作接口
 * 
 * @author soft01
 * 
 */
public interface DownloadRecordDao {
	/**
	 * 添加一条下载记录
	 */
	public abstract void add(DownloadRecord downloadRecord) throws SQLException;

	/**
	 * 通过手机号查找该用户的下载记录，并返回下载记录
	 * 
	 * @param number
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public abstract List queryBynumber(String number) throws SQLException;

}
