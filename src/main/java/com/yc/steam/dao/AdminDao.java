package com.yc.steam.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yc.steam.biz.AdminBiz;
import com.yc.steam.biz.BizException;
import com.yc.steam.po.Admin;

@Repository
public class AdminDao extends BaseDao {
	@Resource
	private AdminBiz abiz;

	public Admin login(String aname, String apwd, HttpSession session) throws BizException {
		
		return abiz.login(aname,apwd,session);
	}

	public Admin selectByName(String aname) {
		
		String sql = "select * from admin where aname=?";
		return jt.query(sql, rs->{
			return rs.next() ? UserRowMapper.mapRow(rs, -1) : null;
		}, aname);
	}
	private RowMapper<Admin> UserRowMapper = new RowMapper<Admin>() {

		@Override
		public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
			Admin admin = new Admin();
			admin.setAid(rs.getInt("aid"));
			admin.setAname(rs.getString("aname"));
			admin.setApwd(rs.getString("apwd"));
			return admin;
		}
	};
	
	
}
