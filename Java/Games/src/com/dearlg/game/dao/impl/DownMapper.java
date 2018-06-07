package com.dearlg.game.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.dearlg.game.entity.DownloadRecord;
import com.dearlg.game.entity.Game;
import com.dearlg.game.entity.User;
import com.dearlg.game.util.JdbcTemplate;
import com.dearlg.game.util.RowMapper;

public class DownMapper implements RowMapper {

	@SuppressWarnings("unchecked")
	@Override
	public Object mapperObject(ResultSet rs) throws SQLException {
		DownloadRecord downloadRecord = new DownloadRecord();
		User user = null;
		String sql = "select t_number,t_password,t_name,t_sex,t_address,t_account,t_VirtualAccount,t_time from t_user where t_number = ?";
		List<User> userList = JdbcTemplate.executeQuery(sql, new UserMapper(), rs.getString("t_number"));
		if (userList.size() > 0) {
			user = userList.get(0);
		}
		Game game = null;
		sql = "select t_id,t_name,t_typename,t_RmbPrice,t_virtualPrice,t_time from t_game where t_id=?";
		List<Game> gamelist = JdbcTemplate.executeQuery(sql, new GameMapper(), rs.getString("t_id"));
		if (gamelist.size() > 0) {
			game = gamelist.get(0);
		}
		downloadRecord.setUser(user);
		downloadRecord.setGame(game);
		downloadRecord.setBuyType(rs.getString("t_buyType"));
		downloadRecord.setBuyPrice(rs.getDouble("t_buyPrice"));
		downloadRecord.setTime(rs.getString("t_time"));
		return downloadRecord;
	}

}
