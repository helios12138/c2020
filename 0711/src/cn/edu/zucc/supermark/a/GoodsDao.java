package cn.edu.zucc.supermark.a;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import cn.edu.zucc.supermark.model.Goods;
import cn.edu.zucc.supermark.util.DbUtil;
import cn.edu.zucc.supermark.util.StringUtil;

public class GoodsDao extends DbUtil {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	// 添加
	public int addGoods(Goods goods) {
		con = super.getCon();

		int num = 0;
		try {
			String sql = "INSERT INTO goods_info (name, price, menberprice, number, spec, freshclassid, details) VALUES (?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, goods.getName());
			ps.setDouble(2, goods.getPrice());
			ps.setDouble(3, goods.getMenberprice());
			ps.setInt(4, goods.getNumber());
			ps.setString(5, goods.getSpec());
			ps.setInt(6, goods.getFreshclassid());
			ps.setString(7, goods.getDetails());

			num = ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			super.release(null, ps, con);
		}
		return num;
	}

	// 查询（根据商品名称）
	public ArrayList<Goods> getGoods(String name) {
		con = super.getCon();

		ArrayList<Goods> list = new ArrayList<>();
		Goods goods;

		try {
			StringBuffer sql = new StringBuffer("SELECT * FROM goods_info");

			if (!StringUtil.isNull(name)) {
				sql.append(" where name like '%" + name + "%'");
			}

			ps = con.prepareStatement(new String(sql));
			rs = ps.executeQuery();

			while (rs.next()) {
				goods = new Goods();
				goods.setId(rs.getInt("id"));
				goods.setName(rs.getString("name"));
				goods.setPrice(rs.getDouble("price"));
				goods.setMenberprice(rs.getDouble("menberprice"));
				goods.setNumber(rs.getInt("number"));
				goods.setSpec(rs.getString("spec"));
				goods.setFreshclassid(rs.getInt("freshclassid"));
				goods.setDetails(rs.getString("details"));

				list.add(goods);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			super.release(null, ps, con);
		}
		return list;
	}

	// 查询（根据商品id）
	public ArrayList<Goods> getGoods(int id) {
		con = super.getCon();

		ArrayList<Goods> list = new ArrayList<>();
		Goods goods;

		try {
			StringBuffer sql = new StringBuffer("SELECT * FROM goods_info where id = ?");

			ps = con.prepareStatement(new String(sql));
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				goods = new Goods();
				goods.setId(rs.getInt("id"));
				goods.setName(rs.getString("name"));
				goods.setPrice(rs.getDouble("price"));
				goods.setMenberprice(rs.getDouble("menberprice"));
				goods.setNumber(rs.getInt("number"));
				goods.setSpec(rs.getString("spec"));
				goods.setFreshclassid(rs.getInt("freshclassid"));
				goods.setDetails(rs.getString("details"));

				list.add(goods);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			super.release(null, ps, con);
		}
		return list;
	}

	// 查询（根据类别id）
	public ArrayList<Goods> getGoods_freshclassid(int id) {
		con = super.getCon();

		ArrayList<Goods> list = new ArrayList<>();
		Goods goods;

		try {
			StringBuffer sql = new StringBuffer("SELECT * FROM goods_info where freshclassid = ?");

			ps = con.prepareStatement(new String(sql));
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				goods = new Goods();
				goods.setId(rs.getInt("id"));
				goods.setName(rs.getString("name"));
				goods.setPrice(rs.getDouble("price"));
				goods.setMenberprice(rs.getDouble("menberprice"));
				goods.setNumber(rs.getInt("number"));
				goods.setSpec(rs.getString("spec"));
				goods.setFreshclassid(rs.getInt("freshclassid"));
				goods.setDetails(rs.getString("details"));

				list.add(goods);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			super.release(null, ps, con);
		}
		return list;
	}

	// 查询（根据类别id）
	public ArrayList<Goods> getGoods_freshclassid_goodsid(String freshclassid, String name) {
		con = super.getCon();

		ArrayList<Goods> list = new ArrayList<>();
		Goods goods;

		try {
			StringBuffer sql = new StringBuffer("SELECT * FROM goods_info ");

			if (!StringUtil.isNull(name)) {
				sql.append(" where name like '%" + name + "%'");

				if (!StringUtil.isNull(freshclassid)) {
					sql.append(" and freshclassid like '%" + freshclassid + "%'");
				}
			} else {
				if (!StringUtil.isNull(freshclassid)) {
					sql.append(" where freshclassid like '%" + freshclassid + "%'");
				}
			}

			ps = con.prepareStatement(new String(sql));
			rs = ps.executeQuery();

			while (rs.next()) {
				goods = new Goods();
				goods.setId(rs.getInt("id"));
				goods.setName(rs.getString("name"));
				goods.setPrice(rs.getDouble("price"));
				goods.setMenberprice(rs.getDouble("menberprice"));
				goods.setNumber(rs.getInt("number"));
				goods.setSpec(rs.getString("spec"));
				goods.setFreshclassid(rs.getInt("freshclassid"));
				goods.setDetails(rs.getString("details"));

				list.add(goods);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			super.release(null, ps, con);
		}
		return list;
	}

	// 删除
	public int delGoods(int id) {
		con = super.getCon();
		int num = 0;

		try {
			// 构造SQL语句
			String sql = "delete from goods_info where id = ?";

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
	public int updateGoods(Goods goods) {
		con = super.getCon();
		int num = 0;

		try {
			// 构造SQL语句
			String sql = "update goods_info set name = ?, price = ?, menberprice = ?, spec = ?, details = ? where id = ?";

			// 创建执行对象
			ps = con.prepareStatement(sql);
			ps.setString(1, goods.getName());
			ps.setDouble(2, goods.getPrice());
			ps.setDouble(3, goods.getMenberprice());
			ps.setString(4, goods.getSpec());
			ps.setString(5, goods.getDetails());
			ps.setInt(6, goods.getId());

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

	// 更新
	public int updateGoods(int number, int goodsid) {
		con = super.getCon();
		int num = 0;

		try {
			// 构造SQL语句
			String sql = "update goods_info set number = ? where id = ?";

			// 创建执行对象
			ps = con.prepareStatement(sql);
			ps.setInt(1, number);
			ps.setInt(2, goodsid);

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
