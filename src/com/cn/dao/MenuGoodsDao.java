package com.cn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.cn.model.MenuGoods;
import com.cn.util.DbUtil;


public class MenuGoodsDao extends DbUtil {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	// 查询（根据商品名称）
	public ArrayList<MenuGoods> getMenuGoods(String menuid) {
		con = super.getCon();

		ArrayList<MenuGoods> list = new ArrayList<>();
		MenuGoods menuGoods;

		try {
			StringBuffer sql = new StringBuffer("SELECT * FROM goods_menu_rec where menuid = ?");

			ps = con.prepareStatement(new String(sql));
			ps.setString(1, menuid);
			rs = ps.executeQuery();

			while (rs.next()) {
				menuGoods = new MenuGoods();
				
				menuGoods.setId(rs.getInt("id"));
				menuGoods.setGoodsid(rs.getInt("goodsid"));
				menuGoods.setMenuid(rs.getInt("menuid"));
				menuGoods.setDes(rs.getString("des"));

				list.add(menuGoods);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			super.release(null, ps, con);
		}
		return list;
	}
}
