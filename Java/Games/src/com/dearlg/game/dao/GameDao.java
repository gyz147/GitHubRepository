package com.dearlg.game.dao;

import java.sql.SQLException;
import java.util.List;

import com.dearlg.game.entity.Game;

/**
 * 对游戏数据进行CRUD的接口
 * 
 * @author soft01
 * 
 */
public interface GameDao {
	/**
	 * 游戏下载列表
	 */
	@SuppressWarnings("unchecked")
	public abstract List show();

	/**
	 * 添加一款游戏
	 * @throws SQLException 
	 */
	public abstract void add(Game game) throws SQLException;

	/**
	 * 通过游戏ID 删除一款游戏
	 * @throws SQLException 
	 */
	public abstract void delete(String id) throws SQLException;

	/**
	 * 通过游戏编号查询一款游戏
	 * @throws SQLException 
	 */
	public abstract Game select(String id) throws SQLException;

}
