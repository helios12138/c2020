package cn.edu.zucc.supermark.a;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.zucc.supermark.model.Coupon;
import cn.edu.zucc.supermark.model.Goods;
import cn.edu.zucc.supermark.util.DbUtil;
import cn.edu.zucc.supermark.util.StringUtil;

public class CouponDao extends DbUtil {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public int addCoupon(Coupon coupon) {
		con = super.getCon();

		int num = 0;
		try {
			String sql = "INSERT INTO coupon (content, useamount, creditamount, begindate, enddate) VALUES (?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, coupon.getContent());
			ps.setDouble(2, coupon.getUseamount());
			ps.setDouble(3, coupon.getCreditamount());
			ps.setTimestamp(4, coupon.getBegindate());
			ps.setTimestamp(5, coupon.getEnddate());

			num = ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			super.release(null, ps, con);
		}
		return num;
	}

	// 查询
	public ArrayList<Coupon> getCoupon(String content) {
		con = super.getCon();

		ArrayList<Coupon> list = new ArrayList<>();
		Coupon coupon;

		try {
			StringBuffer sql = new StringBuffer("SELECT * FROM coupon");

			if (!StringUtil.isNull(content)) {
				sql.append(" where content like '%" + content + "%'");
			}

			ps = con.prepareStatement(new String(sql));
			rs = ps.executeQuery();

			while (rs.next()) {
				coupon = new Coupon();
				coupon.setId(rs.getInt("id"));
				coupon.setContent(rs.getString("content"));
				coupon.setUseamount(rs.getDouble("useamount"));
				coupon.setCreditamount(rs.getDouble("creditamount"));
				coupon.setBegindate(rs.getTimestamp("begindate"));
				coupon.setEnddate(rs.getTimestamp("enddate"));

				list.add(coupon);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			super.release(null, ps, con);
		}
		return list;
	}

	// 删除
	public int delCoupon(int id) {
		con = super.getCon();
		int num = 0;

		try {
			// 构造SQL语句
			String sql = "delete from coupon where id = ?";

			// 创建执行对象
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			;
			// 执行删除
			num = ps.executeUpdate();
		} catch (SQLException e) {
			// 异常处理
			System.out.println("删除失败！");
			e.printStackTrace();
		} finally {
			// 释放资源
			super.release(null, ps, con);
		}

		return num;
	}

	// 更新
	public int updateCoupon(Coupon coupon) {
		con = super.getCon();
		int num = 0;

		try {
			// 构造SQL语句
			String sql = "update coupon set content = ?, useamount = ?, creditamount = ?, begindate = ?, enddate = ? where id = ?";

			// 创建执行对象
			ps = con.prepareStatement(sql);
			ps.setString(1, coupon.getContent());
			ps.setDouble(2, coupon.getUseamount());
			ps.setDouble(3, coupon.getCreditamount());
			ps.setTimestamp(4, coupon.getBegindate());
			ps.setTimestamp(5, coupon.getEnddate());
			ps.setInt(6, coupon.getId());

			// 执行查询，得到结果集
			num = ps.executeUpdate();
		} catch (SQLException e) {
			// 异常处理
			System.out.println("更新失败！");
			e.printStackTrace();
		} finally {
			// 释放资源
			super.release(null, ps, con);
		}

		return num;
	}
}
