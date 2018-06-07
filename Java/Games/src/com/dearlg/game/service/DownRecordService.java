package com.dearlg.game.service;

import com.dearlg.game.entity.DownloadRecord;

public interface DownRecordService {
	/**
	 * 添加下载记录
	 */
	public abstract void add(DownloadRecord downloadRecord);

	/**
	 * 通过手机号查找该用户的下载记录，并返回下载记录
	 * 
	 * @param number
	 * @return
	 */
	public abstract void queryBynumber(String number);
}
