package com.yc.steam.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.EncodeException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.steam.biz.BizException;
import com.yc.steam.biz.UserBiz;
import com.yc.steam.dao.UserDao;
import com.yc.steam.po.Game;
import com.yc.steam.po.Result;
import com.yc.steam.po.User;


@RestController
public class UserAction {	
	@Resource
	private UserBiz ubiz;
	@Resource
	private UserDao udao;
	//后台展示


	
	@RequestMapping("reg")
	public Result reg(User user,HttpSession session) throws BizException, SQLException {
		try {
			ubiz.register(user);
			return Result.success("注册成功");
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(0, e.getMessage());
		} 
	}
	
	
	@RequestMapping("login.s")
	public Result login(String uname,String upwd,HttpSession session) throws IOException, EncodeException {
		User user = null;
		try {
			user = ubiz.login(uname,upwd,session);
			session.setAttribute("loginedUser", user);
			return new Result(1, "登录成功");
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(0, e.getMessage());
		}	
	}
	
	@RequestMapping("getLoginedUser")
	public User getLoginedUser(String username,HttpSession session) {
		User user = (User) session.getAttribute("loginedUser");
		return user;
	}
	
	
	@RequestMapping("sendVcode")
	public String sendVcode(String email,HttpSession session) {
		//根据用户名发送验证码
		String vcode =ubiz.sendVcode(email);
		//将验证码保存到回话中
		session.setAttribute("vcode", vcode);
		return "验证码发送成功!";
	}	
}
