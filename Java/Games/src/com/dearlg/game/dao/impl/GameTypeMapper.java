package com.dearlg.game.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dearlg.game.entity.GameType;
import com.dearlg.game.util.RowMapper;

public class GameTypeMapper implements RowMapper {

	@Override
	public Object mapperObject(ResultSet rs) throws SQLException {
		GameType gameType = new GameType();
		gameType.setId(rs.getInt("t_typeid"));
		gameType.setName(rs.getString("t_typename"));
		gameType.setTime(rs.getString("t_time"));
		return gameType;
	}
}
