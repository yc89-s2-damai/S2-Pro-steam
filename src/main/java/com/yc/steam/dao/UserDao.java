package com.yc.steam.dao;


import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yc.steam.biz.BizException;
import com.yc.steam.biz.UserBiz;
import com.yc.steam.po.User;

@Repository
public class UserDao extends BaseDao {
	@Resource
	private UserBiz ubiz;


	//从数据库里查找是否有这么一个id 从而实现看注册是否有同名
	public User selectByName(String uname) {
		String sql = "select * from user where uname=?";
		return jt.query(sql, rs->{
			return rs.next() ? UserRowMapper.mapRow(rs, -1) : null;
		}, uname);

		
	}
	// 用户注册
	public void register(User user) throws BizException, SQLException {
		ubiz.register(user);
	}
	public void insert(User user) {
		String sql = "insert into user values(null,?,?,?,?,now())";
		jt.update(sql,
				user.getUname(),user.getUpwd(),
				user.getEmail(),user.getPhone());
	}
	private RowMapper<User> UserRowMapper = new RowMapper<User>() {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setUid(rs.getInt("uid"));
			user.setUname(rs.getString("uname"));
			user.setUpwd(rs.getString("upwd"));
			user.setPhone(rs.getString("phone"));
			return user;
		}
	};

	public User login(String uname, String upwd, HttpSession session) throws BizException {
		
		return ubiz.login(uname,upwd,session);
	}

}
