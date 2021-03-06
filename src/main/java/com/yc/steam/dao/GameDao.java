package com.yc.steam.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.activation.MailcapCommandMap;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yc.steam.po.Game;
import com.yc.steam.po.Result;
	
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
	//热门游戏list
		public List<Game> selectcateIsHot(){
			String sql="select * from game where is_hot=1 limit 2,2";
			return jt.query(sql, gameRowMapper);
		}
	//最新游戏
		public List<Game> selectcateNew(){
			String sql="select * from game order by publish_date desc limit 2,2";
			return jt.query(sql, gameRowMapper);
		}
	//全部游戏
	public List<Game> selectAll(){
		String sql="select * from game";
		return jt.query(sql, gameRowMapper);
	}
	//byname
	public List<Game> selectByName(String gname){
		String sql="select * from game where gname=?";
		return jt.query(sql, gameRowMapper,gname);
	}
	//byid
	public Game selectById(int gid) {
		String sql="select * from game where gid=?";
		return jt.query(sql, rs->{
			return rs.next() ? gameRowMapper.mapRow(rs, -1) : null;
		}, gid);
	}
	
	public List<Game> selectAll(int cid){
		String sql="select * from game where cid=?";
		return jt.query(sql, gameRowMapper,cid);
	}
	
	public List<Game> selectBygid(int gid){
		String sql="select * from game where gid=?";
		return jt.query(sql, gameRowMapper,gid);
	}
	
	private RowMapper<Game> gameRowMapper = new RowMapper<Game>() {

		@Override
		public Game mapRow(ResultSet rs, int rowNum) throws SQLException {
			Game g = new Game();
			g.setGid(rs.getInt("gid"));
			g.setGname(rs.getString("gname"));
			g.setGdesc(rs.getString("gdesc"));
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
	//添加游戏
	public void addGame(Game game) {
		String sql="insert into game values(null,?,?,?,?,?,?,?,?,?,?)";
		jt.update(sql,game.getGname(),
					  game.getGdesc(),
					  game.getPublishDate(),
					  game.getImage1(),
					  game.getImage2(),
					  game.getImage3(),
					  game.getImage4(),
					  game.getCid(),
					  game.getPrice(),
					  game.getIsHot());
		
	}
	//查询所有游戏包括类型
	public List<Map<String,Object>> selectGamesAll(){
		return jt.queryForList("select * from game g"
				+" left join category c on g.cid=c.cid"
				+ " group by g.gid");
	}
	//后台查询
	public List<Map<String,Object>> selectcGame(Integer gid){
		return jt.queryForList("select * from game g"
				+" left join category c on g.cid=c.cid"
				+ " where g.gid=?",gid);
	}
	//后台修改
	public void updateGameById(Game game) {
		String sql="update game set gname=? ,price=?,gdesc=? where gid=?";
		jt.update(sql,game.getGname(),
					game.getPrice(),
					game.getGdesc(),
					game.getGid());
	}
	public void delGameById(int gid) {
		String sql="delete * from game where gid=?";
		jt.update(sql,gid);
	}
}
