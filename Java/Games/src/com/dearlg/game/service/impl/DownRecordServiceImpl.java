package com.dearlg.game.service.impl;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.dearlg.game.dao.DownloadRecordDao;
import com.dearlg.game.entity.DownloadRecord;
import com.dearlg.game.factory.ObjectFactory;
import com.dearlg.game.service.DownRecordService;
import com.dearlg.game.transaction.Transaction;

public class DownRecordServiceImpl implements DownRecordService {

	private DownloadRecordDao downloadRecordDao = (DownloadRecordDao) ObjectFactory.getBean("downloadRecordDao");
	private Transaction tx = (Transaction) ObjectFactory.getBean("tx");

	@Override
	public void add(DownloadRecord downloadRecord) {
		try {
			tx.begin();
			downloadRecordDao.add(downloadRecord);
			tx.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void queryBynumber(String number) {
		try {
			List downlist = downloadRecordDao.queryBynumber(number);
			if (downlist != null) {
				System.out.println("手机号码\t\t游戏编号\t\t游戏名称\t\t游戏类型\t\t购买类型\t\t购买金额\t\t下载时间");
				Iterator<DownloadRecord> it = downlist.iterator();
				while (it.hasNext()) {
					DownloadRecord downloadRecord = it.next();
					System.out.println(downloadRecord.getUser().getNumber() + "\t" + downloadRecord.getGame().getId() + "\t\t" + downloadRecord.getGame().getName() + "\t\t"
							+ downloadRecord.getGame().getCategory() + "\t\t" + downloadRecord.getBuyType() + "\t\t" + downloadRecord.getBuyPrice() + "\t\t" + downloadRecord.getTime());
				}
			} else {
				System.out.println("当前无任何下载记录！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
