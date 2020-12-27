package com.yc.steam.biz;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yc.steam.dao.UserDao;
import com.yc.steam.po.Admin;
import com.yc.steam.po.User;
import com.yc.steam.util.Utils;
@Service
public class UserBiz {
	@Resource
	private UserDao udao;
	
	@Resource
	private MailBiz mbiz;
	public String sendVcode(String email) {
		// 生成随机验证码
		String vcode = "" + System.currentTimeMillis();
		vcode = vcode.substring(vcode.length()-4);
		mbiz.sendSimpleMail(email, "申请账号验证码","请使用"+vcode+"验证码来注册");
		return vcode;
	}
	
	public void register(User user) throws BizException, SQLException {
		// 字段验证
		
		Utils.checkNull(user.getUname(), "用户名不能为空");
		Utils.checkNull(user.getUpwd(), "密码不能为空");
		Utils.checkNull(user.getEmail(), "邮箱不能为空");
		Utils.checkNull(user.getPhone(), "电话号码不能为空");
		// 同名验证
		User dbuser = udao.selectByName(user.getUname());
		if(dbuser != null ) {
			throw new BizException("该用户名已经被注册");
		}
		
		udao.insert(user);
	}



	public User login(String uname, String upwd, HttpSession session) throws BizException {
		Utils.checkNull(uname, "请输入用户名");
		Utils.checkNull(upwd, "请输入密码");
		
		User user = new User();
		user = udao.selectByName(uname);
		if(user == null) {
			throw new BizException("请检查用户名是否正确");
		}
	
		if( !user.getUpwd().equals(upwd)  ) {
			throw new BizException("密码错误");
		}
		return user;
	}

	

}
