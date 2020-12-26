package com.yc.steam.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.steam.dao.CartDao;
import com.yc.steam.po.Result;
@Service
public class CartBiz {
	
	@Resource
	private CartDao cdao;
	
	public void addCart(int gid,int uid) throws BizException {
		if((cdao.selectCartBygidAndUid(gid, uid))==null) {
			cdao.addCart(gid, uid);
		}else {
			throw new BizException("该游戏已经加入到购物车了!");
		}		
	}
}
