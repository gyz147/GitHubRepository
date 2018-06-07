package com.dearlg.game.service;

import com.dearlg.game.entity.Game;

public interface GameService {
	/**
	 * 显示游戏下载列表
	 * 
	 * @param list
	 */
	public abstract void show();

	/**
	 * 根据游戏查找id
	 * 
	 * @param id
	 * @return
	 */
	public abstract Game select(String id);
}
