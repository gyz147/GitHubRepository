package com.dearlg.game.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dearlg.game.entity.RateRule;
import com.dearlg.game.util.RowMapper;

public class RateRuleMapper implements RowMapper {

	@Override
	public Object mapperObject(ResultSet rs) throws SQLException {
		RateRule rateRule = new RateRule();
		rateRule.setAddress(rs.getString("t_address"));
		rateRule.setRate(Double.valueOf(rs.getString("t_rate")));
		return rateRule;
	}

}
