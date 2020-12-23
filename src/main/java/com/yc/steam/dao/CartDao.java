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
	
	
	
	
	
	
	//查询订单
	public List<Map<String,Object>> selectCart(Integer uid) {
		return jt.queryForList("select * from cart a"
				+ " left join user b on a.uid=b.uid"
				+ " left join game c on a.gid=c.gid"
				+ " where a.uid=?", uid);
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
