package com.dearlg.game.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.dearlg.game.entity.GameType;
import com.dearlg.game.util.JdbcTemplate;

public class GameTypeDaoImpl implements GameTypeDao {

	@SuppressWarnings("unchecked")
	@Override
	public boolean queryByName(String name) throws SQLException {
		boolean result = false;
		// GameType gameType = null;
		String sql = "select t_typeid,t_typename,t_time from t_gametype where t_typename=?";
		List<GameType> gametypelist = JdbcTemplate.executeQuery(sql, new GameTypeMapper(), name);
		if (gametypelist.size() > 0) {
			result = true;
		}
		return result;
	}
}
