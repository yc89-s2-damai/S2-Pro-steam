package com.yc.steam.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.steam.biz.BizException;
import com.yc.steam.biz.OrderBiz;
import com.yc.steam.po.Order;
import com.yc.steam.po.Result;
import com.yc.steam.po.User;

@RestController
public class OrderAction {

	@Resource
	private OrderBiz obiz;
	
	@RequestMapping("order.s")
	public Result pay(Order order, HttpSession session) {
		User user=(User) session.getAttribute("loginedUser");
		try {
			System.out.println("------------"+order);
			order.setUid(user.getUid());
			obiz.addOrder(order);
			return Result.success("下单成功！");
		} catch (BizException e) {
			e.printStackTrace();
			return Result.failure(e.getMessage());
		}
	}
}
