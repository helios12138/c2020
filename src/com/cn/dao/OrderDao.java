package com.cn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cn.model.Order;
import com.cn.model.User;
import com.cn.util.DbUtil;
import com.cn.util.StringUtil;

public class OrderDao extends DbUtil {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public int addOrder(Order order) {
		con = super.getCon();

		int num = 0;
		try {
			String sql = "INSERT INTO goods_order (userid, orgprice, payprice, couponid, ordertime, addressid, orderstate, id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);

			ps.setInt(1, order.getUserid());
			ps.setDouble(2, order.getOrgprice());
			ps.setDouble(3, order.getPayprice());
			ps.setInt(4, order.getCouponid());
			ps.setTimestamp(5, order.getOrdertime());
			ps.setInt(6, order.getAddressid());
			ps.setString(7, order.getOrderstate());
			ps.setInt(8, order.getId());

			num = ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			super.release(null, ps, con);
		}
		return num;
	}

	// 查询
	public ArrayList<Order> getOrder(String id) {
		con = super.getCon();

		ArrayList<Order> list = new ArrayList<>();
		Order order;
		try {
			StringBuffer sql = new StringBuffer("SELECT * FROM goods_order");

			if (!StringUtil.isNull(id)) {
				sql.append(" where id like '%" + id + "%'");
			}

			ps = con.prepareStatement(new String(sql));

			rs = ps.executeQuery();

			while (rs.next()) {
				order = new Order();

				order.setId(rs.getInt("id"));
				order.setUserid(rs.getInt("userid"));
				order.setOrgprice(rs.getDouble("orgprice"));
				order.setPayprice(rs.getDouble("payprice"));
				order.setCouponid(rs.getInt("couponid"));
				order.setOrdertime(rs.getTimestamp("ordertime"));
				order.setAddressid(rs.getInt("addressid"));
				order.setOrderstate(rs.getString("orderstate"));

				list.add(order);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			super.release(null, ps, con);
		}
		return list;
	}

	// 查询
	public ArrayList<Order> getOrder(String id, int userid) {
		con = super.getCon();

		ArrayList<Order> list = new ArrayList<>();
		Order order;
		try {
			StringBuffer sql = new StringBuffer("SELECT * FROM goods_order where userid = ?");

			if (!StringUtil.isNull(id)) {
				sql.append(" and id like '%" + id + "%'");
			}

			ps = con.prepareStatement(new String(sql));
			ps.setInt(1, userid);
			rs = ps.executeQuery();

			while (rs.next()) {
				order = new Order();

				order.setId(rs.getInt("id"));
				order.setUserid(rs.getInt("userid"));
				order.setOrgprice(rs.getDouble("orgprice"));
				order.setPayprice(rs.getDouble("payprice"));
				order.setCouponid(rs.getInt("couponid"));
				order.setOrdertime(rs.getTimestamp("ordertime"));
				order.setAddressid(rs.getInt("addressid"));
				order.setOrderstate(rs.getString("orderstate"));

				list.add(order);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			super.release(null, ps, con);
		}
		return list;
	}
}
