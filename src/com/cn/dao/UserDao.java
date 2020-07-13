package com.cn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.cn.model.User;
import com.cn.util.DbUtil;
import com.cn.util.StringUtil;

public class UserDao extends DbUtil {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//登录
	public Boolean login(User user) {
		con = super.getCon();
		String sql = "select * from user_info where username = ? and password = ?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
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
            super.release(null, ps, con);
		}

		return false;
	}
	
	//添加
	public int addUser(User user) {
		con = super.getCon();

        int num = 0;
        try {
            String sql = "INSERT INTO user_info (username, sex, password, phone, email, city, signtime, ismember) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getSex());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getCity());
            ps.setTimestamp(7, user.getSigntime() );
            ps.setString(8, user.getIsmember());
          
            num = ps.executeUpdate();

        } catch (SQLException e) {
           
            e.printStackTrace();
        } finally {
            
            super.release(null, ps, con);
        }
        return num;
    }
	
	//查询
	public ArrayList<User> getUser(String username){
		con = super.getCon();
       
        ArrayList<User> list = new ArrayList<>();

        User user;

        try {
            StringBuffer sql = new StringBuffer("SELECT * FROM user_info");
            
            if (!StringUtil.isNull(username)){
            	sql.append(" where username like '%" + username + "%'");
            }

            ps = con.prepareStatement(new String(sql));

            rs = ps.executeQuery();

            while (rs.next()) {
            	user = new User();
            	
            	user.setId(rs.getInt("id"));
            	user.setUsername(rs.getString("username"));
            	user.setSex(rs.getString("sex"));
            	user.setPassword(rs.getString("password"));
            	user.setPhone(rs.getString("phone"));
            	user.setEmail(rs.getString("email"));
            	user.setCity(rs.getString("city"));
            	user.setSigntime(rs.getTimestamp("signtime"));
            	user.setIsmember(rs.getString("ismember"));
            	user.setMembertime(rs.getTimestamp("membertime"));

                list.add(user);
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        } finally {
            
            super.release(null, ps, con);
        }
		return list;
	}
	
	public int updateUser(User user){
		con = super.getCon();
		int num = 0;
		
		try {
            //构造SQL语句
            String sql = "update user_info set password = ?, phone = ?, email = ?, city = ?, ismember = ?, membertime = ? where username = ?";

            //创建执行对象
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getPhone());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getCity());
            ps.setString(5, user.getIsmember());
            ps.setTimestamp(6, user.getMembertime());
            ps.setString(7, user.getUsername());
            
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
	
	public int updateUser1(User user){
		con = super.getCon();
		int num = 0;
		
		try {
            //构造SQL语句
            String sql = "update user_info set password = ?, phone = ?, email = ?, city = ? where username = ?";

            //创建执行对象
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getPhone());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getCity());
            ps.setString(5, user.getUsername());
            
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
	
	public int delUser(String username){
		con = super.getCon();
		int num = 0;
		
		try {
            //构造SQL语句
            String sql = "delete from user_info where username = ?";

            //创建执行对象
            ps = con.prepareStatement(sql);
            ps.setString(1, username);;
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
		
		return 0;
	}
}
