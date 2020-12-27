package com.yc.steam.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import com.yc.steam.biz.AdminBiz;
import com.yc.steam.biz.BizException;
import com.yc.steam.biz.UserBiz;
import com.yc.steam.po.Admin;
import org.springframework.jdbc.core.RowMapper;
@Repository
public class AdminDao extends BaseDao{

	
	//管理员登录
		public Admin login(String aname, String apwd, HttpSession session) throws BizException {
			AdminBiz abiz = null;
			return abiz.loginHou(aname, apwd, session);
		}
		//管理员
		public Admin loginName(String aname) {
			String sql = "select * from admin where aname=?";
			return jt.query(sql, rs->{
				return rs.next() ? AdminRowMapper.mapRow(rs, -1) : null;
			}, aname);

			
		}
		
		private RowMapper<Admin> AdminRowMapper = new RowMapper<Admin>() {

			@Override
			public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
				Admin admin =new Admin();
				admin.setAid(rs.getInt("aid"));
				admin.setAname(rs.getString("aname"));
				admin.setApwd(rs.getString("apwd"));
				return admin;
			}
		};
}
