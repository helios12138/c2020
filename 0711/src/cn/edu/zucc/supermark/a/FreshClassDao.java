package cn.edu.zucc.supermark.a;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import cn.edu.zucc.supermark.model.FreshClass;
import cn.edu.zucc.supermark.util.DbUtil;
import cn.edu.zucc.supermark.util.StringUtil;

public class FreshClassDao extends DbUtil {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	// 添加
	public int addFreshClass(FreshClass freshClass) {
		con = super.getCon();

		int num = 0;
		try {
			String sql = "INSERT INTO fresh_class_info (name, info) VALUES (?, ?)";
			ps = con.prepareStatement(sql);

			ps.setString(1, freshClass.getName());
			ps.setString(2, freshClass.getInfo());

			num = ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			super.release(null, ps, con);
		}
		return num;
	}

	// 查询
	public ArrayList<FreshClass> getFreshClass(String name) {
		con = super.getCon();

		ArrayList<FreshClass> list = new ArrayList<>();
		FreshClass freshClass;

		try {
			StringBuffer sql = new StringBuffer("SELECT * FROM fresh_class_info");

			if (!StringUtil.isNull(name)) {
				sql.append(" where name like '%" + name + "%'");
			}

			ps = con.prepareStatement(new String(sql));
			rs = ps.executeQuery();

			while (rs.next()) {
				freshClass = new FreshClass();

				freshClass.setId(rs.getInt("id"));
				freshClass.setName(rs.getString("name"));
				freshClass.setInfo(rs.getString("info"));

				list.add(freshClass);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			super.release(null, ps, con);
		}
		return list;
	}

	// 查询
	public ArrayList<FreshClass> getFreshClass(int id) {
		con = super.getCon();

		ArrayList<FreshClass> list = new ArrayList<>();
		FreshClass freshClass;

		try {
			StringBuffer sql = new StringBuffer("SELECT * FROM fresh_class_info where id = ?");

			ps = con.prepareStatement(new String(sql));
			ps.setInt(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {
				freshClass = new FreshClass();

				freshClass.setId(rs.getInt("id"));
				freshClass.setName(rs.getString("name"));
				freshClass.setInfo(rs.getString("info"));

				list.add(freshClass);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			super.release(null, ps, con);
		}
		return list;
	}

	// 删除
	public int delFreshClass(int id) {
		con = super.getCon();
		int num = 0;

		try {
			// 构造SQL语句
			String sql = "delete from fresh_class_info where id = ?";

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
	public int updateFreshClass(FreshClass freshClass) {
		con = super.getCon();
		int num = 0;

		try {
			// 构造SQL语句
			String sql = "update fresh_class_info set name = ?, info = ? where id = ?";

			// 创建执行对象
			ps = con.prepareStatement(sql);
			ps.setString(1, freshClass.getName());
			ps.setString(2, freshClass.getInfo());
			ps.setInt(3, freshClass.getId());

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
