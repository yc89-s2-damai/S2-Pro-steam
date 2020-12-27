package com.yc.steam.biz;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yc.steam.dao.AdminDao;
import com.yc.steam.dao.UserDao;
import com.yc.steam.po.Admin;
import com.yc.steam.util.Utils;

@Service
public class AdminBiz {

	@Resource
	private AdminDao adao;
	
	public Admin loginHou(String aname, String apwd, HttpSession session) throws BizException {
		Utils.checkNull(aname, "请输入用户名");
		Utils.checkNull(apwd, "请输入密码");
		
		Admin admin =new Admin();
		admin = adao.loginName(aname);
		if(admin == null) {
			throw new BizException("请检查用户名是否正确");
		}
	
		if( !admin.getApwd().equals(apwd)  ) {
			throw new BizException("密码错误");
		}
		return admin;
	}
}
