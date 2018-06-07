package com.njwb.joybeans.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njwb.joybeans.exception.JoybeansException;
import com.njwb.joybeans.mapper.SysUserMapper;
import com.njwb.joybeans.pojo.SysUser;
import com.njwb.joybeans.service.SysUserService;
import com.njwb.joybeans.util.CodeUtil;

@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public String getMessage(String userAccount) throws JoybeansException {
		String phone = null;
		String code = null;
		try {
			phone = sysUserMapper.queryPhoneByAccount(userAccount);
			if (phone != null) {
				code = CodeUtil.getCode();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return phone + "," + code;
	}

	@Override
	public SysUser login(String userAccount, String userPwd) throws JoybeansException {
		Map<String, String> param = new HashMap<String, String>();
		param.put("userAccount", userAccount);
		param.put("userPwd", userPwd);
		SysUser sysUser = null;
		try {
			sysUser = sysUserMapper.loginByAccountPwd(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sysUser;
	}
}
