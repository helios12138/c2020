package com.cn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.cn.model.Appraise;
import com.cn.model.Order;
import com.cn.util.DbUtil;

public class AppraiseDao  extends DbUtil {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	// 查询（根据商品id）
	public ArrayList<Appraise> getGoods(int id) {
		con = super.getCon();

		ArrayList<Appraise> list = new ArrayList<>();
		Appraise appraise;

		try {
			StringBuffer sql = new StringBuffer("SELECT * FROM goods_appraise where goodsid = ?");

			ps = con.prepareStatement(new String(sql));
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				appraise = new Appraise();
				appraise.setId(rs.getInt("id"));
				appraise.setGoodsid(rs.getInt("goodsid"));;
				appraise.setUserid(rs.getInt("userid"));
				appraise.setContent(rs.getString("content"));
				appraise.setContentdata(rs.getTimestamp("contentdata"));

				list.add(appraise);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			super.release(null, ps, con);
		}
		return list;
	}
	
	public int addAppraise(Appraise appraise) {
		con = super.getCon();

		int num = 0;
		try {
			String sql = "INSERT INTO goods_appraise (goodsid, userid, content, contentdata) VALUES (?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, appraise.getGoodsid());
			ps.setInt(2, appraise.getUserid());
			ps.setString(3, appraise.getContent());
			ps.setTimestamp(4, appraise.getContentdata());

			num = ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			super.release(null, ps, con);
		}
		return num;
	}
}
