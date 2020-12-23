package com.yc.steam.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yc.steam.po.Game;
	
@Repository
public class GameDao extends BaseDao{
	
	//首页顶部商品展示
	public List<Game> selectTop(){
		String sql="select * from game order by publish_date desc limit 0,2";
		return jt.query(sql, gameRowMapper);
	}
	//首页精品游戏3A
	public List<Game> selectFeatur(){
		String sql="select * from game where cid=4";
		return jt.query(sql, gameRowMapper);
	}
	//最新游戏
	public List<Game> selectNew(){
		String sql="select * from game order by publish_date desc limit 0,5";
		return jt.query(sql, gameRowMapper);
	}
	//热门游戏
	public List<Game> selectIsHot(){
		String sql="select * from game where is_hot=1";
		return jt.query(sql, gameRowMapper);
	}
	//全部游戏
	public List<Game>selectAll(){
		String sql="select * from game";
		return jt.query(sql, gameRowMapper);
	}
	//byname
	public List<Game> selectByName(String gname){
		String sql="select * from game where gname=?";
		return jt.query(sql, gameRowMapper,gname);
	}
	
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
}
