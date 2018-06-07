package com.njwb.joybeans.service;

import java.util.List;

import com.njwb.joybeans.exception.JoybeansException;
import com.njwb.joybeans.pojo.GameType;
import com.njwb.joybeans.util.PageModel;

/**
 * 游戏类型的业务操作层
 * 
 * @author soft03
 * 
 */
public interface GameTypeService {
	/**
	 * 分页查询所有游戏类型
	 * 
	 * @return
	 * @throws BeanException
	 */
	PageModel<GameType> queryAllGameType(int pageNo, int pageSize, String typeName, String typeStatus) throws JoybeansException;

	/**
	 * 查询所有游戏类型
	 * 
	 * @return
	 * @throws JoybeansException
	 */
	List<GameType> queryAllGameType() throws JoybeansException;

	/**
	 * 增加游戏类型
	 * 
	 * @param gameType
	 * @throws BeanException
	 */
	void addGameType(String typeName, String typeStatus) throws JoybeansException;

	/**
	 * 修改游戏类型
	 * 
	 * @param gameType
	 * @throws BeanException
	 */
	void updateGameType(GameType gameType) throws JoybeansException;

	/**
	 * 通过ID查询游戏类型
	 * 
	 * @param id
	 * @return
	 * @throws JoybeansException
	 */
	GameType queryById(String id) throws JoybeansException;

	/**
	 * 查询游戏类型名是否可用
	 * 
	 * @param gameName
	 * @return
	 * @throws JoybeansException
	 */
	boolean gameTypeNameIsExist(String typeName) throws JoybeansException;

	/**
	 * 查询某游戏类型下是否有未下线的游戏
	 * 
	 * @return
	 * @throws Exception
	 */
	boolean ableModifyStatus(String id) throws JoybeansException;
}
