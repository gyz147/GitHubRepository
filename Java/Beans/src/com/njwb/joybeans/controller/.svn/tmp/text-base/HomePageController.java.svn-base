package com.njwb.joybeans.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.njwb.joybeans.exception.JoybeansException;
import com.njwb.joybeans.pojo.Game;
import com.njwb.joybeans.pojo.GameType;
import com.njwb.joybeans.service.GameService;
import com.njwb.joybeans.service.GameTypeService;
import com.njwb.joybeans.util.PageModel;

@Controller
@RequestMapping("/main")
public class HomePageController {
	@Autowired
	private GameTypeService gameTypeService;

	@Autowired
	private GameService gameService;

	@RequestMapping(value = "/homePage.action", method = { RequestMethod.GET })
	public String queryAll(String pageNo, String gameName, String gameType, HttpServletRequest request, HttpSession session) throws JoybeansException {
		List<GameType> gameTypeList = gameTypeService.queryAllGameType();
		if (null == pageNo) {
			pageNo = "1";
		}
		if (null == gameName) {
			gameName = "";
		}
		if (null == gameType) {
			gameType = "";
		}
		int pageSize = 6;
		PageModel<Game> pageModel = gameService.queryAllGame(Integer.valueOf(pageNo), pageSize, gameName, gameType);
		request.setAttribute("gameName", gameName);
		request.setAttribute("gameType", gameType);
		request.setAttribute("pageModel", pageModel);
		session.setAttribute("gameTypeList", gameTypeList);
		return "joyBeansUser/main";
	}

	@RequestMapping(value = "/gameCenter.action", method = { RequestMethod.GET })
	public String gameCenter(String id,HttpServletRequest request) throws JoybeansException {
		Game game = gameService.queryById(id);
		request.setAttribute("game", game);
		return "joyBeansUser/game/game";
	}
}
