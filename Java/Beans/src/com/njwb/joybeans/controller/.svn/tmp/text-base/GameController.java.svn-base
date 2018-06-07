package com.njwb.joybeans.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.njwb.joybeans.exception.JoybeansException;
import com.njwb.joybeans.pojo.Game;
import com.njwb.joybeans.pojo.GameType;
import com.njwb.joybeans.service.GameService;
import com.njwb.joybeans.service.GameTypeService;
import com.njwb.joybeans.util.CodeUtil;
import com.njwb.joybeans.util.Constant;
import com.njwb.joybeans.util.PageModel;
import com.njwb.joybeans.util.PropertiesUtil;
import com.njwb.joybeans.util.UUIDGenerator;

@Controller
@RequestMapping("/game")
public class GameController {
	@Autowired
	private GameService gameService;

	@Autowired
	private GameTypeService gameTypeService;

	@RequestMapping(value = "/queryAll.action", method = { RequestMethod.GET })
	public String queryAll(String pageNo, String gameName, String gameType, HttpServletRequest request, HttpSession session) throws JoybeansException {
		List<GameType> gameTypeList = gameTypeService.queryAllGameType();
		session.setAttribute("gameTypeList", gameTypeList);
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
		return "sysUser/game/game";
	}

	@RequestMapping(value = "/gameNameIsExist.action", method = { RequestMethod.GET })
	public void GameNameIsExist(String gameName, HttpServletResponse response) throws JoybeansException {
		if (gameService.gameNameIsExist(gameName)) {
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write("游戏名已存在");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@RequestMapping(value = "/addGame.action", method = { RequestMethod.POST })
	public String addGame(@RequestParam("file") CommonsMultipartFile file, String gameName, String gameType, String gameDetail, String gameStatus, String gameFee, String gameBeans,
			HttpServletRequest request) throws Exception {
		String fileName = UUIDGenerator.getUUID() + CodeUtil.getSuffix(file.getOriginalFilename());
		file.transferTo(new File(PropertiesUtil.getKey("uploadPath") + fileName));
		Game game = new Game();
		game.setGameName(gameName);
		game.setGameType(gameType);
		game.setGamePicture(fileName);
		game.setGameDetail(gameDetail);
		game.setGameStatus(gameStatus);
		game.setGameFee(gameFee);
		game.setGameBeans(gameBeans);
		gameService.addGame(game);
		request.setAttribute("operator", Constant.GAME_ADD);
		return "prompt/success";
	}

	@RequestMapping(value = "/queryForUpdate.action", method = { RequestMethod.GET })
	public String queryForUpdate(String id, Model model) throws Exception {
		Game game = gameService.queryById(id);
		model.addAttribute("game", game);
		return "sysUser/game/editGame";
	}

	@RequestMapping(value = "/editGame.action", method = { RequestMethod.POST })
	public String editGame(@RequestParam("file") CommonsMultipartFile file, String id, String gameName, String gamePicture, String gameType, String gameDetail, String gameStatus, String gameFee,
			String gameBeans, HttpServletRequest request) throws Exception {
		String fileName = UUIDGenerator.getUUID() + CodeUtil.getSuffix(file.getOriginalFilename());
		file.transferTo(new File(PropertiesUtil.getKey("uploadPath") + fileName));
		Game game = new Game();
		game.setId(id);
		game.setGameName(gameName);
		game.setGameType(gameType);
		if (file.isEmpty()) {
			game.setGamePicture(gamePicture);
		} else {
			game.setGamePicture(fileName);
		}
		game.setGameDetail(gameDetail);
		game.setGameStatus(gameStatus);
		game.setGameFee(gameFee);
		game.setGameBeans(gameBeans);
		gameService.updateGame(game);
		request.setAttribute("operator", Constant.GAME_EDIT);
		return "prompt/success";
	}
}
