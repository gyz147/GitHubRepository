package com.njwb.oa.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.njwb.oa.entity.Menu;
import com.njwb.oa.util.RowMapper;

/**
 * 部门对象转换器
 * 
 * @author Administrator
 * 
 */
public class MenuMapper implements RowMapper {

	@Override
	public Object mapperObject(ResultSet rs) throws SQLException {
		Menu menu = new Menu();
		menu.setMenuID(rs.getString("t_id"));
		menu.setMenuName(rs.getString("t_menu_name"));
		menu.setHrefUrl(rs.getString("t_href_url"));
		menu.setParentID(rs.getString("t_parent_id"));
		return menu;
	}

}
