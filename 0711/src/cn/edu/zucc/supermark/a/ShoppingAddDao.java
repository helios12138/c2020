package cn.edu.zucc.supermark.a;

import java.awt.geom.Area;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.zucc.supermark.model.ShippingAddress;
import cn.edu.zucc.supermark.model.User;
import cn.edu.zucc.supermark.util.DbUtil;
import cn.edu.zucc.supermark.util.StringUtil;

public class ShoppingAddDao extends DbUtil {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	// 添加
	public int addAdd(ShippingAddress shipadd) {
		con = super.getCon();

		int num = 0;
		try {
			String sql = "INSERT INTO shipping_address (userid, province, city, area, address, username, phone) VALUES (?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);

			ps.setString(1, shipadd.getUserid());
			ps.setString(2, shipadd.getProvince());
			ps.setString(3, shipadd.getCity());
			ps.setString(4, shipadd.getArea());
			ps.setString(5, shipadd.getAddress());
			ps.setString(6, shipadd.getUsername());
			ps.setString(7, shipadd.getPhone());

			num = ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			super.release(null, ps, con);
		}
		return num;
	}
	
	//查找地址
	public ArrayList<ShippingAddress> getAdd(String username){
		con = super.getCon();
		ArrayList<ShippingAddress> list = new ArrayList<>();
		
		ShippingAddress shippingAddress;
		
		try {
            StringBuffer sql = new StringBuffer("SELECT * FROM shipping_address");
            
            if (!StringUtil.isNull(username)){
            	sql.append(" where username like '%" + username + "%'");
            }

            ps = con.prepareStatement(new String(sql));

            rs = ps.executeQuery();

            while (rs.next()) {
            	shippingAddress = new ShippingAddress();
            	
            	shippingAddress.setId(rs.getInt("id"));
            	shippingAddress.setUserid(rs.getString("userid"));
            	shippingAddress.setProvince(rs.getString("province"));
            	shippingAddress.setCity(rs.getString("city"));
            	shippingAddress.setArea(rs.getString("area"));
            	shippingAddress.setAddress(rs.getString("address"));
            	shippingAddress.setUsername(rs.getString("username"));
            	shippingAddress.setPhone(rs.getString("phone"));
            	
                list.add(shippingAddress);
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        } finally {
            
            super.release(null, ps, con);
        }

		return list;
	}
	
	public int delAdd(int id){
		con = super.getCon();
		int num = 0;
		
		try {
            //构造SQL语句
            String sql = "delete from shipping_address where id = ?";

            //创建执行对象
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);;
            //执行删除
            num = ps.executeUpdate();
        } catch (SQLException e) {
            //异常处理
            System.out.println("删除失败！");
            e.printStackTrace();
        } finally {
            //释放资源
            super.release(null, ps, con);
        }
		
		return num;
	}
	
	public int updtate(ShippingAddress shippingAddress){
		con = super.getCon();
		int num = 0;
		
		try {
            //构造SQL语句
            String sql = "update shipping_address set province = ?, city = ?, area = ?, address = ?, phone = ? where id = ?";

            //创建执行对象
            ps = con.prepareStatement(sql);
            ps.setString(1, shippingAddress.getProvince());
            ps.setString(2, shippingAddress.getCity());
            ps.setString(3, shippingAddress.getArea());
            ps.setString(4, shippingAddress.getAddress());
            ps.setString(5, shippingAddress.getPhone());
            ps.setInt(6, shippingAddress.getId());
           
            //执行查询，得到结果集
            num = ps.executeUpdate();
        } catch (SQLException e) {
            //异常处理
            System.out.println("更新失败！");
            e.printStackTrace();
        } finally {
            //释放资源
            super.release(null, ps, con);
        }
		
		return num;
		
	}
}
