package com.njwb.joybeans.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njwb.joybeans.exception.JoybeansException;
import com.njwb.joybeans.mapper.JoyBeansUserMapper;
import com.njwb.joybeans.mapper.SecretCardMapper;
import com.njwb.joybeans.pojo.JoyBeansUser;
import com.njwb.joybeans.service.JoyBeansUserService;
import com.njwb.joybeans.util.CodeUtil;
import com.njwb.joybeans.util.PageModel;

@Service("joyBeansUserService")
public class JoyBeansUserServiceImpl implements JoyBeansUserService {
	@Autowired
	private JoyBeansUserMapper joyBeansUserMapper;

	@Autowired
	private SecretCardMapper secretCardMapper;

	@Override
	public PageModel<JoyBeansUser> queryAll(int pageNo, int pageSize, String userName, String userAccount, String userPhone) throws JoybeansException {
		PageModel<JoyBeansUser> pageModel = new PageModel<JoyBeansUser>();
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		Map<String, String> param = new HashMap<String, String>();
		param.put("pageNo", "" + pageNo);
		param.put("pageSize", "" + pageSize);
		param.put("userName", "%" + userName + "%");
		param.put("userAccount", "%" + userAccount + "%");
		param.put("userPhone", "%" + userPhone + "%");
		try {
			List<JoyBeansUser> list = joyBeansUserMapper.queryAllByCondition(param);
			int cnt = joyBeansUserMapper.queryCntByCondition(param);
			pageModel.setDataList(list);
			pageModel.setCnt(cnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageModel;
	}

	@Override
	public JoyBeansUser loginByAccountPwd(String userAccount, String userPwd) throws JoybeansException {
		Map<String, String> param = new HashMap<String, String>();
		param.put("userAccount", userAccount);
		param.put("userPwd", userPwd);
		JoyBeansUser joyBeansUser = null;
		try {
			joyBeansUser = joyBeansUserMapper.loginByAccountPwd(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return joyBeansUser;
	}

	@Override
	public String getMessage(String userAccount) throws JoybeansException {
		String phone = "";
		String code = CodeUtil.getCode();
		try {
			phone = joyBeansUserMapper.queryPhoneByAccount(userAccount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return phone + "," + code;
	}

	@Override
	public boolean phoneIsRegister(String phone) throws JoybeansException {
		String id = null;
		try {
			id = joyBeansUserMapper.queryPhoneForRegister(phone);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (id != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean accountIsExist(String userAccount) throws JoybeansException {
		String phone = null;
		try {
			phone = joyBeansUserMapper.queryPhoneByAccount(userAccount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (phone != null) {
			return true;
		} else {
			return false;
		}
	}

	@Transactional
	@Override
	public void register(String userName, String userAccount, String userPwd, String userPhone) throws JoybeansException {
		JoyBeansUser joyBeansUser = new JoyBeansUser();
		joyBeansUser.setUserName(userName);
		joyBeansUser.setUserAccount(userAccount);
		joyBeansUser.setUserPwd(userPwd);
		joyBeansUser.setUserPhone(userPhone);
		try {
			joyBeansUserMapper.register(joyBeansUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public void modifyStatus(String id, String userStatus) throws JoybeansException {
		Map<String, String> param = new HashMap<String, String>();
		param.put("id", id);
		param.put("userStatus", userStatus);
		try {
			joyBeansUserMapper.updateJoyBeansUser(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public JoyBeansUser queryBalanceByAccount(String userAccount) throws JoybeansException {
		JoyBeansUser joyBeansUser = null;
		try {
			joyBeansUser = joyBeansUserMapper.queryBalance(userAccount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return joyBeansUser;
	}

	@Transactional
	@Override
	public void addSecretBalance(String secretBalance, String userId,String cardNo, String secretId) throws JoybeansException {
		Map<String, String> param = new HashMap<String, String>();
		param.put("secretBalance", secretBalance);
		param.put("cardNo", cardNo);
		param.put("id", userId);
		try {
			joyBeansUserMapper.addSecretBalance(param);
			secretCardMapper.updateSecretStatus(secretId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
