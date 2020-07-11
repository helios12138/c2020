package cn.edu.zucc.supermark.a;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.zucc.supermark.model.Discount;
import cn.edu.zucc.supermark.model.DiscountGoods;
import cn.edu.zucc.supermark.util.DbUtil;
import cn.edu.zucc.supermark.util.StringUtil;

public class DiscountGoodsDao extends DbUtil {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	// 添加
	public int addDiscountGood(DiscountGoods discountGoods) {
		con = super.getCon();

		int num = 0;
		try {
			String sql = "INSERT INTO discount_goods (discountid, goodsid,begindate, enddate) VALUES (?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, discountGoods.getDiscountid());
			ps.setInt(2, discountGoods.getGoodsid());
			ps.setTimestamp(3, discountGoods.getBegindate());
			ps.setTimestamp(4, discountGoods.getEnddate());

			num = ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			super.release(null, ps, con);
		}
		return num;
	}

	// 查询
	public ArrayList<DiscountGoods> getDiscountGoods(String goodsid) {
		con = super.getCon();

		ArrayList<DiscountGoods> list = new ArrayList<>();
		DiscountGoods discountGoods;

		try {
			StringBuffer sql = new StringBuffer("SELECT * FROM discount_goods");

			if (!StringUtil.isNull(goodsid)){
            	sql.append(" where goodsid like '%" + goodsid + "%'");
            }

			ps = con.prepareStatement(new String(sql));
			rs = ps.executeQuery();

			while (rs.next()) {
				discountGoods = new DiscountGoods();
				discountGoods.setId(rs.getInt("id"));
				discountGoods.setDiscountid(rs.getInt("discountid"));
				discountGoods.setGoodsid(rs.getInt("goodsid"));
				discountGoods.setBegindate(rs.getTimestamp("begindate"));
				discountGoods.setEnddate(rs.getTimestamp("enddate"));

				list.add(discountGoods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.release(null, ps, con);
		}
		return list;
	}
	
	public ArrayList<DiscountGoods> getDiscountGoods_discount(String discountid) {
		con = super.getCon();

		ArrayList<DiscountGoods> list = new ArrayList<>();
		DiscountGoods discountGoods;

		try {
			StringBuffer sql = new StringBuffer("SELECT * FROM discount_goods where discountid = ?");
			
			ps = con.prepareStatement(new String(sql));
			ps.setInt(1, Integer.parseInt(discountid));
			rs = ps.executeQuery();

			while (rs.next()) {
				discountGoods = new DiscountGoods();
				discountGoods.setId(rs.getInt("id"));
				discountGoods.setDiscountid(rs.getInt("discountid"));
				discountGoods.setGoodsid(rs.getInt("goodsid"));
				discountGoods.setBegindate(rs.getTimestamp("begindate"));
				discountGoods.setEnddate(rs.getTimestamp("enddate"));

				list.add(discountGoods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.release(null, ps, con);
		}
		return list;
	}
	
	public ArrayList<DiscountGoods> getDiscountGoods_goods(String goodsid) {
		con = super.getCon();

		ArrayList<DiscountGoods> list = new ArrayList<>();
		DiscountGoods discountGoods;

		try {
			StringBuffer sql = new StringBuffer("SELECT * FROM discount_goods where goodsid = ?");
			
			ps = con.prepareStatement(new String(sql));
			ps.setInt(1, Integer.parseInt(goodsid));
			rs = ps.executeQuery();

			while (rs.next()) {
				discountGoods = new DiscountGoods();
				discountGoods.setId(rs.getInt("id"));
				discountGoods.setDiscountid(rs.getInt("discountid"));
				discountGoods.setGoodsid(rs.getInt("goodsid"));
				discountGoods.setBegindate(rs.getTimestamp("begindate"));
				discountGoods.setEnddate(rs.getTimestamp("enddate"));

				list.add(discountGoods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.release(null, ps, con);
		}
		return list;
	}

	// 删除
	public int delDiscountGoods(int id) {
		con = super.getCon();
		int num = 0;

		try {
			// 构造SQL语句
			String sql = "delete from discount_goods where id = ?";

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
	public int updateDiscountGoods(DiscountGoods discountGoods) {
		con = super.getCon();
		int num = 0;

		try {
			// 构造SQL语句
			String sql = "update discount_goods set discountid = ?, goodsid = ?, begindate = ?, enddate = ? where id = ?";

			// 创建执行对象
			ps = con.prepareStatement(sql);
			ps.setInt(1, discountGoods.getDiscountid());
			ps.setInt(2, discountGoods.getGoodsid());
			ps.setTimestamp(3, discountGoods.getBegindate());
			ps.setTimestamp(4, discountGoods.getEnddate());
			ps.setInt(5, discountGoods.getId());

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
