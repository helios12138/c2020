package com.cn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cn.model.Admin;
import com.cn.model.User;
import com.cn.util.DbUtil;
import com.cn.util.StringUtil;

public class AdminDao extends DbUtil{
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public Boolean login(Admin admin) {
		DbUtil db = new DbUtil();
		con = db.getCon();
		String sql = "select * from admin_info where adminname = ? and password = ?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, admin.getAdminname());
			ps.setString(2, admin.getPassword());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//�ͷ���Դ
            super.release(null, ps, con);
		}

		return false;
	}
	
	//添加
	public int addAdmin(Admin admin){
		con = super.getCon();

        int num = 0;
        try {
            String sql = "INSERT INTO admin_info (adminname, password) VALUES (?, ?)";
            ps = con.prepareStatement(sql);

            ps.setString(1, admin.getAdminname());
            ps.setString(2, admin.getPassword());
          
            num = ps.executeUpdate();

        } catch (SQLException e) {
           
            e.printStackTrace();
        } finally {
            
            super.release(null, ps, con);
        }
        return num;
	}
	
	//查找
	public ArrayList<Admin> getAdmin(String adminname){
		con = super.getCon();
	       
        ArrayList<Admin> list = new ArrayList<>();

        Admin admin;

        try {
            StringBuffer sql = new StringBuffer("SELECT * FROM admin_info");
            
            if (!StringUtil.isNull(adminname)){
            	sql.append(" where adminname like '%" + adminname + "%'");
            }

            ps = con.prepareStatement(new String(sql));

            rs = ps.executeQuery();

            while (rs.next()) {
            	admin = new Admin();
            	
            	admin.setId(rs.getInt("id"));
            	admin.setAdminname(rs.getString("adminname"));;
            	admin.setPassword(rs.getString("password"));

                list.add(admin);
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        } finally {
            
            super.release(null, ps, con);
        }
		return list;		
	}
	
	//删除
	public int delAdmin(int id) {
		con = super.getCon();
		int num = 0;
		
		try {
            //构造SQL语句
            String sql = "delete from admin_info where id = ?";

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
	
	//更新
	public int updateAdmin(Admin admin){
		con = super.getCon();
		int num = 0;
		
		try {
            //构造SQL语句
            String sql = "update admin_info set adminname = ?, password = ? where id = ?";

            //创建执行对象
            ps = con.prepareStatement(sql);
            ps.setString(1, admin.getAdminname());
            ps.setString(2, admin.getPassword());
            ps.setInt(3, admin.getId());
           
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


