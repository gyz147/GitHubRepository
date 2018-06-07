package com.dearlg.game.service.impl;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.dearlg.game.dao.GameDao;
import com.dearlg.game.entity.Game;
import com.dearlg.game.factory.ObjectFactory;
import com.dearlg.game.service.GameService;

public class GameServiceImpl implements GameService {
	private GameDao gameDao = (GameDao) ObjectFactory.getBean("gameDao");

	@SuppressWarnings("unchecked")
	@Override
	public void show() {
		List gamelist = gameDao.show();
		if (null != gamelist) {
			System.out.println("游戏编号\t\t游戏名称\t\t游戏类型\t\t话费价格\t\t乐豆价格");
		}
		Iterator<Game> iterator = gamelist.iterator();
		while (iterator.hasNext()) {
			Game game = iterator.next();
			System.out.println(game.getId() + "\t\t" + game.getName() + "\t\t" + game.getCategory() + "\t\t" + game.getRmbPrice() + "\t\t" + game.getVirtualPrice());
		}
	}

	@Override
	public Game select(String id) {
		Game game = null;
		try {
			game = gameDao.select(id);
			if (null != game) {
				System.out.println("游戏编号\t\t游戏名称\t\t游戏类型\t\t话费价格\t\t乐豆价格");
				System.out.println(game.getId() + "\t\t" + game.getName() + "\t\t" + game.getCategory() + "\t\t" + game.getRmbPrice() + "\t\t" + game.getVirtualPrice());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return game;
	}

}
