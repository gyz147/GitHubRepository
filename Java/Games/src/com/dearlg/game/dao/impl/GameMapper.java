package com.dearlg.game.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dearlg.game.entity.Game;
import com.dearlg.game.util.RowMapper;

public class GameMapper implements RowMapper {

	@Override
	public Object mapperObject(ResultSet rs) throws SQLException {
		Game game = new Game();
		game.setId(rs.getString("t_id"));
		game.setName(rs.getString("t_name"));
		game.setCategory(rs.getString("t_typename"));
		game.setRmbPrice(rs.getDouble("t_RmbPrice"));
		game.setVirtualPrice(rs.getDouble("t_virtualPrice"));
		game.setTime(rs.getString("t_time"));
		return game;
	}

}
