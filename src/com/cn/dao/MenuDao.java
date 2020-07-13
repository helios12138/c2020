package com.cn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.cn.model.Menu;
import com.cn.util.DbUtil;
import com.cn.util.StringUtil;

public class MenuDao extends DbUtil {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	// 查询（根据商品名称）
	public ArrayList<Menu> getMenu(String name) {
		con = super.getCon();

		ArrayList<Menu> list = new ArrayList<>();
		Menu menu;

		try {
			StringBuffer sql = new StringBuffer("SELECT * FROM menu_info");

			if (!StringUtil.isNull(name)) {
				sql.append(" where name like '%" + name + "%'");
			}

			ps = con.prepareStatement(new String(sql));
			rs = ps.executeQuery();

			while (rs.next()) {
				menu = new Menu();
				
				menu.setId(rs.getInt("id"));
				menu.setName(rs.getString("name"));
				menu.setMaterials(rs.getString("materials"));
				menu.setStep(rs.getString("step"));

				list.add(menu);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			super.release(null, ps, con);
		}
		return list;
	}
}
