package com.njwb.joybeans.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.njwb.joybeans.pojo.Game;

/**
 * 游戏数据操作层
 * 
 * @author soft01
 * 
 */
public interface GameMapper {
	/**
	 * 按条件查询所有游戏
	 * 
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	List<Game> queryAllGame(Map<String, String> param) throws Exception;

	/**
	 * 按条件查询游戏的总数
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	int queryCnt(Map<String, String> param) throws Exception;

	/**
	 * 添加游戏
	 * 
	 * @param game
	 * @throws SQLException
	 */
	void addGame(Game game) throws Exception;

	/**
	 * 修改游戏
	 * 
	 * @param game
	 * @throws SQLException
	 */
	void updateGame(Game game) throws Exception;

	/**
	 * 通过ID查询某个游戏
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	Game queryGame(String id) throws Exception;

	/**
	 * 查询游戏名是否可用
	 * 
	 * @param gameName
	 * @return
	 * @throws Exception
	 */
	String gameNameIsExist(String gameName) throws Exception;
}
