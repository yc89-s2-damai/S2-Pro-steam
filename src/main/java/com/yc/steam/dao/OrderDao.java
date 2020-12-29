package com.yc.steam.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yc.steam.po.Game;
import com.yc.steam.po.Order;

@Repository
public class OrderDao extends BaseDao{
	
	public void addOrder(Order order) {
		String sql="insert into orders values(null,?,now(),?,?,?,?,?)";
		jt.update(sql,order.getTotal(),				  
					  order.getAddr(),
					  order.getPhone(),
					  order.getUid(),
					  order.getName(),
					  order.getState());
	}
	
	//查询待处理订单
	public List<Order> selectOrder0() {
		String sql="select * from orders where state=0";
		return jt.query(sql, orderRowMapper);
	}
	//提交发货订单
	public void updateOrder(int oid) {
		String sql="update orders set state=1 where oid=?";
		jt.update(sql,oid);
	}
	//查询待处理订单
		public List<Order> selectOrder1() {
			String sql="select * from orders where state=1";
			return jt.query(sql, orderRowMapper);
		}
	
	private RowMapper<Order> orderRowMapper = new RowMapper<Order>() {

		@Override
		public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
			Order o = new Order();
			o.setOid(rs.getInt("oid"));
			o.setTotal(rs.getDouble("total"));
			o.setOrderTime(rs.getDate("ordertime"));
			o.setAddr(rs.getString("addr"));
			o.setPhone(rs.getInt("phone"));
			o.setUid(rs.getInt("uid"));
			o.setName(rs.getString("name"));
			o.setState(rs.getInt("state"));
			return o;
		}
	};
}
