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
	private UserDao udao;
	
	@Resource
	private UserBiz ubiz;
	
	//后台展示
	@RequestMapping(path = "game.s",params = "op=queryhou")
	public List<Game> queryIshot(){
		return udao.selectHou();
	}
	
	@RequestMapping(path="game.s" ,params = "op=deletedel")
	public Result deleteGameById(int gid) {
				
				System.out.println("========"+gid);
				udao.deleteGameById(gid);
				
				return Result.success("删除游戏成功!");
				
	}
	
	@RequestMapping("reg")
	public Result reg(User user,HttpSession session) throws BizException, SQLException {
		try {
			udao.register(user);
			return new Result(1, "注册成功");
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(0, e.getMessage());
		} 
	}
	
	
	@RequestMapping("login.s")
	public Result login(String uname,String upwd,HttpSession session) throws IOException, EncodeException {
		User user = null;
		try {
			user = udao.login(uname,upwd,session);
			session.setAttribute("loginedUser", user);
			return new Result(1, "登录成功");
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(0, e.getMessage());
		}
	
		
	}
	
}
