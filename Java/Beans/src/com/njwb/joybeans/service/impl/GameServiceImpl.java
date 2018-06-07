package com.njwb.joybeans.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njwb.joybeans.exception.JoybeansException;
import com.njwb.joybeans.mapper.GameMapper;
import com.njwb.joybeans.pojo.Game;
import com.njwb.joybeans.service.GameService;
import com.njwb.joybeans.util.PageModel;

@Service("gameService")
public class GameServiceImpl implements GameService {
	@Autowired
	private GameMapper gameMapper;

	@Override
	public PageModel<Game> queryAllGame(int pageNo, int pageSize, String gameName, String gameType) throws JoybeansException {
		PageModel<Game> pageModel = new PageModel<Game>();
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		Map<String, String> param = new HashMap<String, String>();
		param.put("pageNo", "" + pageNo);
		param.put("pageSize", "" + pageSize);
		param.put("gameName", "%" + gameName + "%");
		param.put("gameType", gameType);
		try {
			List<Game> list = gameMapper.queryAllGame(param);
			int cnt = gameMapper.queryCnt(param);
			pageModel.setDataList(list);
			pageModel.setCnt(cnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageModel;
	}

	@Transactional
	@Override
	public void addGame(Game game) throws JoybeansException {
		try {
			gameMapper.addGame(game);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Game queryById(String id) throws JoybeansException {
		Game game = null;
		try {
			game = gameMapper.queryGame(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return game;
	}

	@Transactional
	@Override
	public void updateGame(Game game) throws JoybeansException {
		try {
			gameMapper.updateGame(game);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean gameNameIsExist(String gameName) throws JoybeansException {
		String id = null;
		try {
			id = gameMapper.gameNameIsExist(gameName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null == id) {
			return false;
		} else {
			return true;
		}
	}
}
