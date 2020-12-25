package com.yc.steam.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yc.steam.po.Cart;


@Repository
public class CartDao extends BaseDao{
	
	
	//添加购物车
	public void addCart(int gid,int uid) {
		String sql = "insert into cart values(null,?,?,1)";				
		jt.update(sql,uid,gid);		
	}
	
	public Cart selectCartBygidAndUid(int gid,int uid) {
		String sql = "select * from cart where gid=? and uid=?";
		return jt.query(sql, rs->{
			return rs.next() ? cartRowMapper.mapRow(rs, -1) : null;
		}, gid,uid);
	}
	
	//查询订单
	public List<Map<String,Object>> selectCart(Integer uid) {
		return jt.queryForList("select * from cart a"
				+ " left join user b on a.uid=b.uid"
				+ " left join game c on a.gid=c.gid"
				+ " where a.uid=?", uid);
	}
	public Double selectTotalByUid(Integer uid) {
		String sql="select sum(b.price) from "+
				   " cart a join game b on a.gid = b.gid "+
				   " where uid=?";		
		return jt.queryForObject(sql, Double.class,uid);
	}
	
	//取消订单	
	public void deleteByUid(Integer uid) {	
		jt.update("delete from cart where uid=?",uid);
	
}
	
	private RowMapper<Cart> cartRowMapper = new RowMapper<Cart>() {

		@Override
		public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
			Cart cart = new Cart();
			cart.setCiid(rs.getInt("ciid"));
			cart.setUid(rs.getInt("uid"));
			cart.setGid(rs.getInt("gid"));
			cart.setCount(rs.getInt("count"));
			return cart;
		}
	};
}
