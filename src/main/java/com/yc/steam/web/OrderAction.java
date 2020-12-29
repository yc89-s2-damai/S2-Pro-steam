package com.yc.steam.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.steam.dao.OrderDao;
import com.yc.steam.po.Result;

@RestController
public class OrderAction {
	
	@Resource
	private OrderDao odao;
	
	@RequestMapping("selectOrders")
	public List<?> select0(){
		return odao.selectOrder0();
	}
	
	@RequestMapping(path = "order.s",params = "op=updateOne")
	public Result updateOrder(int oid) {
		odao.updateOrder(oid);
		return Result.success("确认订单成功");
		
	}
	@RequestMapping("selectOver")
	public List<?> select1(){
		return odao.selectOrder1();
	}
	
}
