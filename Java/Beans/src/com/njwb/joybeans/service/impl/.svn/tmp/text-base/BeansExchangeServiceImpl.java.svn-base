package com.njwb.joybeans.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njwb.joybeans.exception.JoybeansException;
import com.njwb.joybeans.mapper.BeansExchangeMapper;
import com.njwb.joybeans.pojo.BeansExchange;
import com.njwb.joybeans.service.BeansExchangeService;
import com.njwb.joybeans.util.PageModel;

@Service("beansExchangeService")
public class BeansExchangeServiceImpl implements BeansExchangeService {
	@Autowired
	private BeansExchangeMapper beansExchangeMapper;

	@Override
	public PageModel<BeansExchange> queryAllByCondition(int pageNo, int pageSize, String provName) throws JoybeansException {
		PageModel<BeansExchange> pageModel = new PageModel<BeansExchange>();
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		Map<String, String> param = new HashMap<String, String>();
		param.put("pageNo", "" + pageNo);
		param.put("pageSize", "" + pageSize);
		param.put("provName", "%" + provName + "%");
		try {
			List<BeansExchange> list = beansExchangeMapper.queryAllByCondition(param);
			int cnt = beansExchangeMapper.queryCnt(param);
			pageModel.setCnt(cnt);
			pageModel.setDataList(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageModel;
	}

	@Transactional
	@Override
	public void addBeanExchange(String provCode, String price) throws JoybeansException {
		BeansExchange beansExchange = new BeansExchange();
		beansExchange.setProvCode(provCode);
		beansExchange.setPrice(price);
		try {
			beansExchangeMapper.insertBeansExchange(beansExchange);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public BeansExchange queryById(String id) throws JoybeansException {
		BeansExchange beansExchange = null;
		try {
			beansExchange = beansExchangeMapper.queryById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return beansExchange;
	}

	@Transactional
	@Override
	public void editBeanExchange(String id, String price) throws JoybeansException {
		BeansExchange beansExchange = new BeansExchange();
		beansExchange.setId(id);
		beansExchange.setPrice(price);
		try {
			beansExchangeMapper.updateBeansExchange(beansExchange);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBeanExchange(String id) throws JoybeansException {
		try {
			beansExchangeMapper.deleteBeansExchange(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public BeansExchange queryByProvCode(String provCode) throws JoybeansException {
		BeansExchange beansExchange = null;
		try {
			beansExchange = beansExchangeMapper.queryByProvCode(provCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return beansExchange;
	}
}
