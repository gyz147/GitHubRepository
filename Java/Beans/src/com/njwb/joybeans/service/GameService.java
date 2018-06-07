package com.njwb.joybeans.service;

import com.njwb.joybeans.exception.JoybeansException;
import com.njwb.joybeans.pojo.Game;
import com.njwb.joybeans.util.PageModel;

/**
 * 游戏的业务操作层
 * 
 * @author soft01
 * 
 */
public interface GameService {
	/**
	 * 分页按条件查询所有游戏
	 * 
	 * @param gameName
	 * @param gameType
	 * @return
	 */
	PageModel<Game> queryAllGame(int pageNo, int pageSize, String gameName, String gameType) throws JoybeansException;

	/**
	 * 添加游戏
	 * 
	 * @param game
	 * @throws BeanException
	 */
	void addGame(Game game) throws JoybeansException;

	/**
	 * 通过ID查询某个游戏
	 * 
	 * @param id
	 * @return
	 * @throws JoybeansException
	 */
	Game queryById(String id) throws JoybeansException;

	/**
	 * 修改游戏
	 * 
	 * @param game
	 * @throws BeanException
	 */
	void updateGame(Game game) throws JoybeansException;

	/**
	 * 查询游戏名是否可用
	 * 
	 * @param gameName
	 * @return
	 * @throws JoybeansException
	 */
	boolean gameNameIsExist(String gameName) throws JoybeansException;

}
