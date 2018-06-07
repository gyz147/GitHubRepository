package com.njwb.joybeans.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njwb.joybeans.exception.JoybeansException;
import com.njwb.joybeans.mapper.SecretCardMapper;
import com.njwb.joybeans.pojo.SecretCard;
import com.njwb.joybeans.service.SecretCardService;
import com.njwb.joybeans.util.DateUtil;
import com.njwb.joybeans.util.PageModel;

@Service("secretCardService")
public class SecretCardServiceImpl implements SecretCardService {

	@Autowired
	private SecretCardMapper secretCardMapper;

	@Override
	public PageModel<SecretCard> queryAllByCondition(int pageNo, int pageSize, String cardNo, String provName, Date endTime) throws JoybeansException {
		PageModel<SecretCard> pageModel = new PageModel<SecretCard>();
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("pageNo", "" + pageNo);
		param.put("pageSize", "" + pageSize);
		param.put("cardNo", "%" + cardNo + "%");
		param.put("provName", "%" + provName + "%");
		param.put("endTime", endTime);
		try {
			List<SecretCard> list = secretCardMapper.queryAllByCondition(param);
			int cnt = secretCardMapper.queryCnt(param);
			pageModel.setDataList(list);
			pageModel.setCnt(cnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageModel;
	}

	@Transactional
	@Override
	public void insertSecretCards(int cardNumbers, String provStr, int beansNumber, String startTime, String endTime) throws JoybeansException {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("cardNumbers", cardNumbers);
		param.put("provStr", provStr);
		param.put("beansNumber", beansNumber);
		param.put("startTime", DateUtil.str2Date(startTime, "yyyy-MM-dd"));
		param.put("endTime", DateUtil.str2Date(endTime, "yyyy-MM-dd"));
		try {
			secretCardMapper.insertSecretCards(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public SecretCard querySecretPrice(String cardNo, String cardPwd) throws JoybeansException {
		Map<String, String> param = new HashMap<String, String>();
		param.put("cardNo", cardNo);
		param.put("cardPwd", cardPwd);
		SecretCard secretCard = null;
		try {
			secretCard = secretCardMapper.querySecretPrice(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return secretCard;
	}
}
