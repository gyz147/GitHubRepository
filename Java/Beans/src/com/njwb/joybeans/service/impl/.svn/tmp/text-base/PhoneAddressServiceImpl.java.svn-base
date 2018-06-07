package com.njwb.joybeans.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njwb.joybeans.exception.JoybeansException;
import com.njwb.joybeans.mapper.PhoneAddressMapper;
import com.njwb.joybeans.service.PhoneAddressService;

@Service("phoneAddressService")
public class PhoneAddressServiceImpl implements PhoneAddressService {

	@Autowired
	private PhoneAddressMapper phoneAddressMapper;

	@Override
	public boolean phoneIsExist(String phone) throws JoybeansException {
		String address = null;
		try {
			address = phoneAddressMapper.queryPhone(phone);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null == address) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public String queryAddress(String phone) throws JoybeansException {
		String address = null;
		try {
			address = phoneAddressMapper.queryPhone(phone);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return address;
	}
}
