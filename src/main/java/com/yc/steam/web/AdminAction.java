package com.yc.steam.web;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.EncodeException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.steam.biz.AdminBiz;
import com.yc.steam.biz.BizException;
import com.yc.steam.biz.UserBiz;
import com.yc.steam.dao.AdminDao;
import com.yc.steam.dao.UserDao;
import com.yc.steam.po.Admin;
import com.yc.steam.po.Result;

@RestController
public class AdminAction {

	@Resource
	private AdminBiz abiz;
	@Resource
	private AdminDao adao;
	
	@RequestMapping("loginhou.s")
	public Result loginHou(String aname,String apwd,HttpSession session) throws IOException, EncodeException {
		Admin admin = null;
		try {
			admin = abiz.loginHou(aname,apwd,session);
			session.setAttribute("loginedUser", admin);
			return new Result(1, "登录成功");
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(0, e.getMessage());
		}	
	}
}
