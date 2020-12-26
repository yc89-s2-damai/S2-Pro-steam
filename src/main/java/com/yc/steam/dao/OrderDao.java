package com.yc.steam.dao;

import org.springframework.stereotype.Repository;

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
}
