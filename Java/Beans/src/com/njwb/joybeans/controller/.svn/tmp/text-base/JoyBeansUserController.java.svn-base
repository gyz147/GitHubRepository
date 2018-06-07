package com.njwb.joybeans.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.njwb.joybeans.exception.JoybeansException;
import com.njwb.joybeans.pojo.JoyBeansUser;
import com.njwb.joybeans.pojo.SecretCard;
import com.njwb.joybeans.pojo.wrapper.ConsumeRecordWrapper;
import com.njwb.joybeans.service.ConsumeRecordService;
import com.njwb.joybeans.service.JoyBeansUserService;
import com.njwb.joybeans.service.PhoneAddressService;
import com.njwb.joybeans.service.SecretCardService;
import com.njwb.joybeans.util.Constant;
import com.njwb.joybeans.util.PageModel;

@Controller
@RequestMapping("/joyBeans")
public class JoyBeansUserController {
	@Autowired
	private JoyBeansUserService joyBeansUserService;

	@Autowired
	private PhoneAddressService phoneAddressService;

	@Autowired
	private SecretCardService secretCardService;

	@Autowired
	private ConsumeRecordService consumeRecordService;

	@RequestMapping(value = "/queryAll.action", method = { RequestMethod.GET })
	public String queryAll(String pageNo, String userName, String userAccount, String userPhone, HttpServletRequest request) throws JoybeansException {
		if (null == pageNo) {
			pageNo = "1";
		}
		if (null == userName) {
			userName = "";
		}
		if (null == userAccount) {
			userAccount = "";
		}
		if (null == userPhone) {
			userPhone = "";
		}
		int pageSize = 6;
		PageModel<JoyBeansUser> pageModel = joyBeansUserService.queryAll(Integer.valueOf(pageNo), pageSize, userName, userAccount, userPhone);
		request.setAttribute("userName", userName);
		request.setAttribute("userAccount", userAccount);
		request.setAttribute("userPhone", userPhone);
		request.setAttribute("pageModel", pageModel);
		return "sysUser/userManager/user";
	}

	@RequestMapping(value = "/modifyStatus.action", method = { RequestMethod.GET })
	public String modifyStatus(String id, String userStatus, HttpServletRequest request) throws JoybeansException {
		joyBeansUserService.modifyStatus(id, userStatus);
		request.setAttribute("operator", Constant.USERSTATUS_MODIFY);
		return "prompt/success";
	}

	@RequestMapping(value = "/getCode.action", method = { RequestMethod.GET })
	public void getCode(String userAccount, HttpServletResponse response) throws Exception {
		String message = joyBeansUserService.getMessage(userAccount);
		String messages = JSONArray.fromObject(message.split(",")).toString();
		response.getWriter().write(messages);
	}

	@RequestMapping(value = "/login.action", method = { RequestMethod.POST })
	public String login(String userAccount, String userPwd, HttpSession session, HttpServletRequest request) throws Exception {
		JoyBeansUser joyBeansUser = joyBeansUserService.loginByAccountPwd(userAccount, userPwd);
		if (null == joyBeansUser) {
			request.setAttribute("operator", Constant.USER_LOGIN_ERROR);
			return "prompt/success";
		} else if("暂停使用".equals(joyBeansUser.getUserStatus())){
			request.setAttribute("operator", Constant.USER_NOT_LOG);
			return "prompt/success";
		}else {
			session.setAttribute("joyBeansUser", joyBeansUser);
			request.setAttribute("operator", Constant.USER_LOGIN_SUCCESS);
			return "prompt/success";
		}
	}

	@RequestMapping(value = "/register.action", method = { RequestMethod.POST })
	public String register(String userName, String userAccount, String userPwd, String userPhone, HttpServletRequest request) throws JoybeansException {
		if (null == userPhone) {
			userPhone = "";
		}
		joyBeansUserService.register(userName, userAccount, userPwd, userPhone);
		request.setAttribute("operator", Constant.USER_REGISTER_SUCCESS);
		return "prompt/success";
	}

	@RequestMapping(value = "/accountIsExist.action", method = { RequestMethod.GET })
	public @ResponseBody
	String accountIsExist(String userAccount) throws JoybeansException {
		if (joyBeansUserService.accountIsExist(userAccount)) {
			return "exist";
		} else {
			return "notExist";
		}
	}

	@RequestMapping(value = "/phoneIsExist.action", method = { RequestMethod.GET })
	public @ResponseBody
	String phoneIsExist(String userPhone) throws JoybeansException {
		if (joyBeansUserService.phoneIsRegister(userPhone)) {
			return "exist";
		} else if (!phoneAddressService.phoneIsExist(userPhone)) {
			return "notUse";
		} else {
			return "ableUse";
		}
	}

	@RequestMapping(value = "/queryBalance.action", method = { RequestMethod.GET })
	public @ResponseBody
	String queryBalance(String userAccount, HttpServletResponse response) throws JoybeansException, IOException {
		JoyBeansUser joyBeansUser = joyBeansUserService.queryBalanceByAccount(userAccount);
		String balance = joyBeansUser.getFeeBalance() + "," + joyBeansUser.getBeansBalance() + "," + joyBeansUser.getSecretBalance();
		return balance;
	}

	@RequestMapping(value = "/queryUserCenter.action", method = { RequestMethod.GET })
	public String queryUserCenter(String pageNo, HttpSession session, HttpServletRequest request) throws JoybeansException, IOException {
		JoyBeansUser joyBeansUser = (JoyBeansUser) session.getAttribute("joyBeansUser");
		JoyBeansUser joyBeansUser2 = joyBeansUserService.queryBalanceByAccount(joyBeansUser.getUserAccount());
		joyBeansUser.setFeeBalance(joyBeansUser2.getFeeBalance());
		joyBeansUser.setBeansBalance(joyBeansUser2.getBeansBalance());
		joyBeansUser.setSecretBalance(joyBeansUser2.getSecretBalance());
		session.setAttribute("joyBeansUser", joyBeansUser);
		// 查消费记录
		if (null == pageNo) {
			pageNo = "1";
		}
		PageModel<ConsumeRecordWrapper> pageModel = consumeRecordService.queryAllConsumerRecordByConsumerId(Integer.valueOf(pageNo), 4, joyBeansUser.getId());
		if (pageModel.getDataList().size() == 0) {
			pageModel.setPageNo2(0);
		}
		request.setAttribute("pageModel", pageModel);
		return "joyBeansUser/user/userCenter";
	}

	@RequestMapping(value = "/addSecretBalance.action", method = { RequestMethod.POST })
	public String addSecretBalance(String userId, String userAccount, String cardNo, String cardPwd, String phone, HttpServletRequest request) throws JoybeansException {
		SecretCard secretCard = secretCardService.querySecretPrice(cardNo, cardPwd);
		String address = phoneAddressService.queryAddress(phone);
		JoyBeansUser joyBeansUser = joyBeansUserService.queryBalanceByAccount(userAccount);
		if (null == secretCard) {
			request.setAttribute("operator", Constant.CARD_ERROR);
			return "prompt/success";
		} else if (!"正常".equals(secretCard.getCardStatus())) {
			request.setAttribute("operator", Constant.CARD_NOT_USE);
			return "prompt/success";
		} else if (!address.equals(secretCard.getCardProv())) {
			request.setAttribute("operator", Constant.CARD_PROV_ERROR);
			return "prompt/success";
		} else if (!"0".equals(joyBeansUser.getSecretBalance())) {
			request.setAttribute("operator", Constant.CARD_NOT_ADD);
			return "prompt/success";
		} else {
			joyBeansUserService.addSecretBalance(secretCard.getBeansNumbers(), userId, cardNo, secretCard.getId());
			request.setAttribute("userAccount", userAccount);
			request.setAttribute("operator", Constant.CARD_ADD_SUCCESS);
			return "prompt/success";
		}
	}

}
