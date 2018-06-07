package com.njwb.joybeans.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.njwb.joybeans.exception.JoybeansException;
import com.njwb.joybeans.pojo.BeansExchange;
import com.njwb.joybeans.pojo.ConsumeRecord;
import com.njwb.joybeans.pojo.Game;
import com.njwb.joybeans.pojo.JoyBeansUser;
import com.njwb.joybeans.service.BeansExchangeService;
import com.njwb.joybeans.service.ConsumeRecordService;
import com.njwb.joybeans.service.GameService;
import com.njwb.joybeans.service.JoyBeansUserService;
import com.njwb.joybeans.service.PhoneAddressService;
import com.njwb.joybeans.util.Constant;

@Controller
@RequestMapping("/consumeRecord")
public class ConsumeRecordController {
	@Autowired
	private ConsumeRecordService consumeRecordService;

	@Autowired
	private JoyBeansUserService joyBeansUserService;

	@Autowired
	private GameService gameService;

	@Autowired
	private PhoneAddressService phoneAddressService;

	@Autowired
	private BeansExchangeService beansExchangeService;

	@RequestMapping(value = "/queryConsumeRecord.action", method = { RequestMethod.GET })
	public @ResponseBody
	String queryConsumeRecord(String userId, String gameId) {
		if (null == userId) {
			userId = "";
		}
		if (null == gameId) {
			gameId = "";
		}
		ConsumeRecord consumeRecord = consumeRecordService.queryByUserIdAndGameId(userId, gameId);
		if (null == consumeRecord) {
			return "notConsumeRecord";
		} else if (consumeRecord.getDownCount() >= 3) {
			return "reBuy";
		} else if (System.currentTimeMillis() - consumeRecord.getCreateTime().getTime() > 1440 * 60 * 1000 * 1) {
			return "overTime";
		} else {
			return "" + consumeRecord.getId();
		}
	}

	@RequestMapping(value = "/buyGame.action", method = { RequestMethod.GET })
	public String buyGame(String userAccount, String gameId, String buyType, HttpServletRequest request) throws JoybeansException {
		JoyBeansUser joyBeansUser = joyBeansUserService.queryBalanceByAccount(userAccount);
		Game game = gameService.queryById(gameId);
		String price = null;
		if ("1".equals(buyType)) {
			price = game.getGameFee();
		} else if ("2".equals(buyType)) {
			price = game.getGameBeans();
		}
		BeansExchange beansExchange = beansExchangeService.queryByProvCode(phoneAddressService.queryAddress(joyBeansUser.getUserPhone()));
		consumeRecordService.createConsumeRecord(userAccount, joyBeansUser.getId(), gameId, Double.valueOf(price), buyType, Integer.valueOf(beansExchange.getPrice()));
		request.setAttribute("operator", Constant.BUY_SUCCESS);
		return "prompt/success";
	}

	@RequestMapping(value = "/updateDownCnt.action", method = { RequestMethod.GET })
	public String updateDownCnt(String id, HttpServletRequest request) throws JoybeansException {
		consumeRecordService.updateDownCnt(id);
		request.setAttribute("operator", Constant.DOWN_SUCCESS);
		return "prompt/success";
	}
}
