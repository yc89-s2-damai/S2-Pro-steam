package com.yc.steam.dao;

import org.springframework.stereotype.Repository;

import com.yc.steam.po.Order;

@Repository
public class OrderDao {
	
	public void addOrder(Order order) {
		String sql="insert into order(null,?,now(),?,?,?,?,?)";
	}
}
