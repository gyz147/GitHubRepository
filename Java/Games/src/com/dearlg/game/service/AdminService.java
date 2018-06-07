package com.dearlg.game.service;

import com.dearlg.game.entity.Admin;
import com.dearlg.game.entity.Game;
import com.dearlg.game.exception.GameException;

public interface AdminService {
	/**
	 * 管理员通过帐号密码登录
	 * @param id
	 * @param pwd
	 * @return
	 * @throws GameException
	 */
	public abstract Admin log(String id, String pwd) throws GameException;

	/**
	 * 添加游戏
	 * 
	 * @param game
	 * @throws GameException 
	 * @throws GameException 
	 */
	public abstract void add(Game game);

	/**
	 * 根据id删除游戏
	 * 
	 * @param id
	 */
	public abstract void delete(String id);
}
