package com.cn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Dictionary;

import com.cn.model.Discount;
import com.cn.model.Goods;
import com.cn.util.DbUtil;
import com.cn.util.StringUtil;

public class DiscountDao extends DbUtil {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	// 添加
	public int addDiscount(Discount discount) {
		con = super.getCon();

		int num = 0;
		try {
			String sql = "INSERT INTO discount_info (content, goodsnum, discount, begindate, enddate) VALUES (?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, discount.getContent());
			ps.setInt(2, discount.getGoodsnum());
			ps.setDouble(3, discount.getDiscount());
			ps.setTimestamp(4, discount.getBegindate());
			ps.setTimestamp(5, discount.getEnddate());

			num = ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			super.release(null, ps, con);
		}
		return num;
	}

	// 查询
	public ArrayList<Discount> getDiscount(String content) {
		con = super.getCon();

		ArrayList<Discount> list = new ArrayList<>();
		Discount discount;

		try {
			StringBuffer sql = new StringBuffer("SELECT * FROM discount_info");

			if (!StringUtil.isNull(content)) {
				sql.append(" where content like '%" + content + "%'");
			}

			ps = con.prepareStatement(new String(sql));
			rs = ps.executeQuery();

			while (rs.next()) {
				discount = new Discount();
				discount.setId(rs.getInt("id"));
				discount.setContent(rs.getString("content"));
				discount.setGoodsnum(rs.getInt("goodsnum"));
				discount.setDiscount(rs.getDouble("discount"));
				discount.setBegindate(rs.getTimestamp("begindate"));
				discount.setEnddate(rs.getTimestamp("enddate"));

				list.add(discount);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			super.release(null, ps, con);
		}
		return list;
	}

	// 根据id查询
	public ArrayList<Discount> getDiscount(int id) {
		con = super.getCon();

		ArrayList<Discount> list = new ArrayList<>();
		Discount discount;

		try {
			StringBuffer sql = new StringBuffer("SELECT * FROM discount_info where id = ?");

			ps = con.prepareStatement(new String(sql));
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				discount = new Discount();
				discount.setId(rs.getInt("id"));
				discount.setContent(rs.getString("content"));
				discount.setGoodsnum(rs.getInt("goodsnum"));
				discount.setDiscount(rs.getDouble("discount"));
				discount.setBegindate(rs.getTimestamp("begindate"));
				discount.setEnddate(rs.getTimestamp("enddate"));

				list.add(discount);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			super.release(null, ps, con);
		}
		return list;
	}

	// 删除
	public int delDiscount(int id) {
		con = super.getCon();
		int num = 0;

		try {
			// 构造SQL语句
			String sql = "delete from discount_info where id = ?";

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
	public int updateDiscount(Discount discount) {
		con = super.getCon();
		int num = 0;

		try {
			// 构造SQL语句
			String sql = "update discount_info set content = ?, goodsnum = ?, discount = ?, begindate = ?, enddate = ? where id = ?";

			// 创建执行对象
			ps = con.prepareStatement(sql);
			ps.setString(1, discount.getContent());
			ps.setInt(2, discount.getGoodsnum());
			ps.setDouble(3, discount.getDiscount());
			ps.setTimestamp(4, discount.getBegindate());
			ps.setTimestamp(5, discount.getEnddate());
			ps.setInt(6, discount.getId());

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
