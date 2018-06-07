package com.njwb.joybeans.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.njwb.joybeans.exception.JoybeansException;
import com.njwb.joybeans.pojo.GameType;
import com.njwb.joybeans.service.GameTypeService;
import com.njwb.joybeans.util.Constant;
import com.njwb.joybeans.util.PageModel;

@Controller
@RequestMapping("/gameType")
public class GameTypeController {
	@Autowired
	private GameTypeService gameTypeService;

	@RequestMapping(value = "/queryAll.action", method = { RequestMethod.GET })
	public String queryAll(String pageNo, String typeName, String typeStatus, HttpServletRequest request) throws JoybeansException {
		if (null == pageNo) {
			pageNo = "1";
		}
		if (null == typeName) {
			typeName = "";
		}
		if (null == typeStatus) {
			typeStatus = "";
		}
		int pageSize = 6;
		PageModel<GameType> pageModel = gameTypeService.queryAllGameType(Integer.valueOf(pageNo), pageSize, typeName, typeStatus);
		request.setAttribute("typeName", typeName);
		request.setAttribute("typeStatus", typeStatus);
		request.setAttribute("pageModel", pageModel);
		return "sysUser/gameType/gameType";
	}

	@RequestMapping(value = "/gameTypeNameIsExist.action", method = { RequestMethod.GET })
	public void gameTypeNameIsExist(String typeName, HttpServletResponse response) throws JoybeansException {
		if (gameTypeService.gameTypeNameIsExist(typeName)) {
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write("已存在");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@RequestMapping(value = "/ableModifyStatus.action", method = { RequestMethod.GET })
	public @ResponseBody
	String ableModifyStatus(String id) throws JoybeansException {
		if (gameTypeService.ableModifyStatus(id)) {
			return "ok";
		} else {
			return "not";
		}
	}

	@RequestMapping(value = "/addGameType.action", method = { RequestMethod.POST })
	public String addGameType(String typeName, String typeStatus, HttpServletRequest request) throws JoybeansException {
		gameTypeService.addGameType(typeName, typeStatus);
		request.setAttribute("operator", Constant.GAME_TYPE_ADD);
		return "prompt/success";
	}

	@RequestMapping(value = "/queryForUpdate.action", method = { RequestMethod.GET })
	public String queryForUpdate(String id, Model model) throws Exception {
		GameType gameType = gameTypeService.queryById(id);
		model.addAttribute("gameType", gameType);
		return "sysUser/gameType/editGameType";
	}

	@RequestMapping(value = "/editGameType.action", method = { RequestMethod.POST })
	public String editGameType(String id, String typeName, String typeStatus, HttpServletRequest request) throws JoybeansException {
		GameType gameType = new GameType();
		gameType.setId(id);
		gameType.setTypeName(typeName);
		gameType.setTypeStatus(typeStatus);
		gameTypeService.updateGameType(gameType);
		request.setAttribute("operator", Constant.GAME_TYPE_EDIT);
		return "prompt/success";
	}
}
