package cn.edu.zucc.supermark.a;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cn.model.Admin;
import com.cn.util.DbUtil;

public class AdminDao extends DbUtil{
	Connection con = null;
	PreparedStatement ps = null;
	
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
			//ÊÍ·Å×ÊÔ´
            super.release(null, ps, con);
		}

		return false;
	}
}
