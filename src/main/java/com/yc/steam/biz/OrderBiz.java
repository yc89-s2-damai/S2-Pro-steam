package com.yc.steam.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.steam.dao.CartDao;
import com.yc.steam.dao.OrderDao;
import com.yc.steam.po.Order;
import com.yc.steam.util.Utils;

@Service
public class OrderBiz {
	
	@Resource
	private OrderDao odao;
	@Resource
	private CartDao cdao;
	
	public void addOrder(Order order) throws BizException {
		Utils.checkNull(order.getAddr(), "请填写收货地址");
		Utils.checkNull(order.getName(), "请填写收货人");
		Utils.checkNull(order.getPhone(), "请填写电话");
		
		Double total=cdao.selectTotalByUid(order.getUid());
		order.setTotal(total);
		order.setState(0);
		odao.addOrder(order);
		cdao.deleteByUid(order.getUid());
	}
}
