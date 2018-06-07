package com.njwb.joybeans.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njwb.joybeans.exception.JoybeansException;
import com.njwb.joybeans.mapper.ProvinceMapper;
import com.njwb.joybeans.pojo.Province;
import com.njwb.joybeans.service.ProvinceService;

@Service("provinceService")
public class ProvinceServiceImpl implements ProvinceService {

	@Autowired
	private ProvinceMapper provinceMapper;

	@Override
	public List<Province> queryAllNotSecretCard() throws JoybeansException {
		List<Province> list = null;
		try {
			list = provinceMapper.queryAllNotSecretCard();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<String> queryAllNotBeansExchange(String provName) throws JoybeansException {
		List<Province> provList = null;
		List<String> list = new LinkedList<String>();
		provName = "%" + provName + "%";
		try {
			provList = provinceMapper.queryAllNotBeansExchange(provName);
			for (Province province : provList) {
				list.add(province.getProvCode() + "," + province.getProvName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
