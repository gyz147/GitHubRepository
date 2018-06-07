package com.dearlg.game.dao.impl;

import java.sql.SQLException;

public interface GameTypeDao {
	/**
	 * 查着用户输入的类别名是否合法
	 * 
	 * @param name
	 * @return
	 */
	public abstract boolean queryByName(String name) throws SQLException;
}
