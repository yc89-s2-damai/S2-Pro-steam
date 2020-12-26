package com.yc.steam.web;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.EncodeException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.steam.biz.BizException;
import com.yc.steam.dao.AdminDao;
import com.yc.steam.po.Admin;
import com.yc.steam.po.Result;

@RestController
public class AdminAction {
	@Resource
	private AdminDao adao;

	@RequestMapping("amdinlogin.s")
	public Result login(String aname, String apwd, HttpSession session) throws IOException, EncodeException {
		Admin admin=null;
		try {
			admin = adao.login(aname, apwd, session);
			session.setAttribute("loginedUser", admin);
			return new Result(1, "登录成功");
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(0, e.getMessage());
		}
	}
}