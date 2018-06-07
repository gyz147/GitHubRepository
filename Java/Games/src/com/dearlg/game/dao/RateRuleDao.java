package com.dearlg.game.dao;

import java.sql.SQLException;

import com.dearlg.game.entity.RateRule;
import com.dearlg.game.entity.User;

public interface RateRuleDao {
	/**
	 * 查找该用户话费下载游戏兑换乐豆的比率
	 * @return
	 * @throws SQLException
	 */
	public abstract RateRule queryByUser(User user) throws SQLException;
}
