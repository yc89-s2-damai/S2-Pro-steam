package com.yc.steam.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yc.steam.biz.BizException;
import com.yc.steam.biz.UserBiz;
import com.yc.steam.po.Game;
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
	
	//后台数据表格展示
	public List<Game> selectHou() {
		String sql = "select * from game";
		return jt.query(sql, gameRowMapper);

		
	}
	
	//后台数据删除
	public void deleteGameById(int gid) {
		jt.update("delete from game where gid=? ", gid);
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

	private RowMapper<Game> gameRowMapper = new RowMapper<Game>() {

		@Override
		public Game mapRow(ResultSet rs, int rowNum) throws SQLException {
			Game g = new Game();
			g.setGid(rs.getInt("gid"));
			g.setGname(rs.getString("gname"));
			g.setDesc(rs.getString("desc"));
			g.setPublishDate(rs.getDate("publish_date"));
			g.setImage1(rs.getString("image1"));
			g.setImage2(rs.getString("image2"));
			g.setImage3(rs.getString("image3"));
			g.setImage4(rs.getString("image4"));
			g.setCid(rs.getInt("cid"));
			g.setPrice(rs.getDouble("price"));
			g.setIsHot(rs.getInt("is_hot"));
			return g;
		}
	};
	
	public User login(String uname, String upwd, HttpSession session) throws BizException {
		
		return ubiz.login(uname,upwd,session);
	}



	
}
