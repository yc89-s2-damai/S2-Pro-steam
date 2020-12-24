package com.yc.steam.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.steam.biz.BizException;
import com.yc.steam.biz.CartBiz;
import com.yc.steam.dao.CartDao;
import com.yc.steam.po.Result;
import com.yc.steam.po.User;

@RestController
public class CartAction {
	
	
	@Resource
	private CartDao cdao;
	
	@Resource
	private CartBiz cbiz;
	
	
	
	//添加购物车
	@RequestMapping(path = "cart.s",params = "op=addCart")
	public Result AddCart(int gid,HttpSession session) {
		User user = (User) session.getAttribute("loginedUser");
		try {
			cbiz.addCart(gid, user.getUid());
		} catch (BizException e) {
			e.printStackTrace();
			return Result.failure(e.getMessage());
		}
		return Result.success("添加成功！");
	}
	
	
	
	
	/**
	 * 查询购物车
	 * @param session
	 * @return
	 */
	@RequestMapping(path="cart.s" ,params = "op=queryCart")
	public List<?> queryCart(HttpSession session){
		User user = (User) session.getAttribute("loginedUser");
		return cdao.selectCart(user.getUid());
	}
	/**
	 * 取消订单
	 * @param session
	 * @return
	 */
	public Result ClearCart(HttpSession session) {
		User user = (User) session.getAttribute("loginedUser");
		cdao.deleteByUid(user.getUid());
		return Result.success("取消成功！");
	}
}
