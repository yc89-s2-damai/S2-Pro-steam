package com.yc.steam.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yc.steam.po.Category;

@Repository
public class CategoryDao extends BaseDao{
	
	public List<Category> selectAll(){
		String sql="select * from category";
		return jt.query(sql, categoryRowMapper);
	}
	
	
	
	private RowMapper<Category> categoryRowMapper = new RowMapper<Category>() {

		@Override
		public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
			Category cg = new Category();
			cg.setCid(rs.getInt("cid"));
			cg.setCtype(rs.getString("ctype"));
			return cg;
		}
	};
}
