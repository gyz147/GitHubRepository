package com.dearlg.game.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.dearlg.game.dao.GameDao;
import com.dearlg.game.entity.Game;
import com.dearlg.game.util.JdbcTemplate;

public class GameDaoImpl implements GameDao {

	@Override
	public void add(Game game) throws SQLException {
		String sql = "insert into t_game(t_id,t_name,t_typename,t_RmbPrice,t_virtualPrice,t_time)values(?,?,?,?,?,now())";
		JdbcTemplate.executeUpdate(sql, game.getId(), game.getName(), game.getCategory(), game.getRmbPrice(), game.getVirtualPrice());
	}


	@Override
	public void delete(String id) throws SQLException {
		String sql = "delete from t_game where t_id=?";
		JdbcTemplate.executeUpdate(sql, id);
	}


	@SuppressWarnings("unchecked")
	@Override
	public Game select(String id) throws SQLException {
		Game game = null;
		String sql = "select t_id,t_name,t_typename,t_RmbPrice,t_virtualPrice,t_time from t_game where t_id=?";
		List<Game> gamelist = JdbcTemplate.executeQuery(sql, new GameMapper(), id);
		if (gamelist.size() > 0) {
			game = gamelist.get(0);
		}
		return game;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List show() {
		List<Game> gamelist = null;
		String sql = "select t_id,t_name,t_typename,t_RmbPrice,t_virtualPrice,t_time from t_game";
		try {
			gamelist = JdbcTemplate.executeQuery(sql, new GameMapper());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gamelist;
	}
}
