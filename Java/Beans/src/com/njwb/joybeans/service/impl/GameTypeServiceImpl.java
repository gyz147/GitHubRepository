package com.njwb.joybeans.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njwb.joybeans.exception.JoybeansException;
import com.njwb.joybeans.mapper.GameTypeMapper;
import com.njwb.joybeans.pojo.GameType;
import com.njwb.joybeans.service.GameTypeService;
import com.njwb.joybeans.util.PageModel;

@Service("gameTypeService")
public class GameTypeServiceImpl implements GameTypeService {
	@Autowired
	private GameTypeMapper gameTypeMapper;

	@Override
	public PageModel<GameType> queryAllGameType(int pageNo, int pageSize, String typeName, String typeStatus) throws JoybeansException {
		PageModel<GameType> pageModel = new PageModel<GameType>();
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		Map<String, String> param = new HashMap<String, String>();
		param.put("pageNo", "" + pageNo);
		param.put("pageSize", "" + pageSize);
		param.put("typeName", "%" + typeName + "%");
		param.put("typeStatus", typeStatus);
		try {
			List<GameType> list = gameTypeMapper.queryAllGameType(param);
			int cnt = gameTypeMapper.queryCnt(param);
			pageModel.setCnt(cnt);
			pageModel.setDataList(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageModel;
	}

	@Override
	public List<GameType> queryAllGameType() throws JoybeansException {
		List<GameType> list = null;
		try {
			list = gameTypeMapper.queryAllGameType2();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void addGameType(String typeName, String typeStatus) throws JoybeansException {
		GameType gameType = new GameType();
		gameType.setTypeName(typeName);
		gameType.setTypeStatus(typeStatus);
		try {
			gameTypeMapper.addGameType(gameType);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateGameType(GameType gameType) throws JoybeansException {
		try {
			gameTypeMapper.updateGameType(gameType);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public GameType queryById(String id) throws JoybeansException {
		GameType gameType = null;
		try {
			gameType = gameTypeMapper.queryById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gameType;
	}

	@Override
	public boolean gameTypeNameIsExist(String typeName) throws JoybeansException {
		String id = null;
		try {
			id = gameTypeMapper.gameTypeNameIsExist(typeName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null == id) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean ableModifyStatus(String id) throws JoybeansException {
		String status = null;
		try {
			status = gameTypeMapper.ableModifyStatus(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null != status) {
			return false;
		} else {
			return true;
		}
	}
}
