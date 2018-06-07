package com.dearlg.game.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.dearlg.game.dao.DownloadRecordDao;
import com.dearlg.game.entity.DownloadRecord;
import com.dearlg.game.util.JdbcTemplate;

public class DownloadRecordDaoImpl implements DownloadRecordDao {

	@Override
	public void add(DownloadRecord downloadRecord) throws SQLException {
		String sql = "insert into t_record(t_number,t_id,t_name,t_buyType,t_buyPrice,t_time)values(?,?,?,?,?,now())";
		JdbcTemplate.executeUpdate(sql, downloadRecord.getUser().getNumber(), downloadRecord.getGame().getId(), downloadRecord.getGame().getName(), downloadRecord.getBuyType(), downloadRecord
				.getBuyPrice());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List queryBynumber(String number) throws SQLException {
		String sql = "select t_number,t_id,t_name,t_buyType,t_buyPrice,t_time from t_record where t_number=?";
		List<DownloadRecord> downrecordlist = JdbcTemplate.executeQuery(sql, new DownMapper(), number);
		if (downrecordlist.size() == 0) {
			downrecordlist = null;
		}
		return downrecordlist;
	}

}
