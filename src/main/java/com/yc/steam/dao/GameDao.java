package com.yc.steam.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yc.steam.po.game;

@Repository
public class GameDao extends BaseDao{
	
	public List<game> selectTop(){
		String sql="select * from game order by publish_date desc limit 0,2";
		return jt.query(sql, gameRowMapper);
	}
	
	
	
	private RowMapper<game> gameRowMapper = new RowMapper<game>() {

		@Override
		public game mapRow(ResultSet rs, int rowNum) throws SQLException {
			game g = new game();
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
