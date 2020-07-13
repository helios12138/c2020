package com.cn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cn.model.Coupon;
import com.cn.model.Order;
import com.cn.model.OrderDetail;
import com.cn.util.DbUtil;
import com.cn.util.StringUtil;

public class OrderDetailDao extends DbUtil {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public int addOrderDetail(OrderDetail orderDetail) {
		con = super.getCon();

		int num = 0;
		try {
			String sql = "INSERT INTO order_detail (orderid, goodsid, ordernum, price, discount, discountid) VALUES (?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);

			ps.setInt(1, orderDetail.getOrderid());
			ps.setInt(2, orderDetail.getGoodsid());
			ps.setInt(3, orderDetail.getOrdernum());
			ps.setDouble(4, orderDetail.getPrice());
			ps.setDouble(5, orderDetail.getDiscount());
			ps.setInt(6, orderDetail.getDiscountid());

			num = ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			super.release(null, ps, con);
		}
		return num;
	}

	// 查询
	public ArrayList<OrderDetail> getOrderDetail(String orderid) {
		con = super.getCon();

		ArrayList<OrderDetail> list = new ArrayList<>();
		OrderDetail orderDetail;
		try {
			StringBuffer sql = new StringBuffer("SELECT * FROM order_detail where orderid = ?");

			ps = con.prepareStatement(new String(sql));
			ps.setString(1, orderid);
			rs = ps.executeQuery();

			while (rs.next()) {
				orderDetail = new OrderDetail();

				orderDetail.setId(rs.getInt("id"));
				orderDetail.setOrderid(rs.getInt("orderid"));
				orderDetail.setGoodsid(rs.getInt("goodsid"));
				orderDetail.setOrdernum(rs.getInt("ordernum"));
				orderDetail.setPrice(rs.getDouble("price"));
				orderDetail.setDiscount(rs.getDouble("discount"));
				orderDetail.setId(rs.getInt("discountid"));

				list.add(orderDetail);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			super.release(null, ps, con);
		}
		return list;
	}
}
