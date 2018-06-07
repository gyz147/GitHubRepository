package com.njwb.joybeans.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.njwb.joybeans.pojo.GameType;

/**
 * 游戏类型数据操作层
 * 
 * @author soft01
 * 
 */
public interface GameTypeMapper {
	/**
	 * 按分页条件查询所有游戏类型
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<GameType> queryAllGameType(Map<String, String> param) throws Exception;

	/**
	 * 查询所有游戏类型
	 * 
	 * @return
	 * @throws Exception
	 */
	List<GameType> queryAllGameType2() throws Exception;

	/**
	 * 查询游戏类型的总数
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	int queryCnt(Map<String, String> param) throws Exception;

	/**
	 * 增加游戏类型
	 * 
	 * @param gameType
	 * @throws SQLException
	 */
	void addGameType(GameType gameType) throws Exception;

	/**
	 * 修改游戏类型
	 * 
	 * @param gameType
	 * @throws SQLException
	 */
	void updateGameType(GameType gameType) throws Exception;

	/**
	 * 通过ID查询游戏类型
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	GameType queryById(String id) throws Exception;

	/**
	 * 查询游戏类型名是否可用
	 * 
	 * @param gameName
	 * @return
	 * @throws Exception
	 */
	String gameTypeNameIsExist(String typeName) throws Exception;

	/**
	 * 查询某游戏类型下是否有未下线的游戏
	 * 
	 * @return
	 * @throws Exception
	 */
	String ableModifyStatus(String id) throws Exception;
}
