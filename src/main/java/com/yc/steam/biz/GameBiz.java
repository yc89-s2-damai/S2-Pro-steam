package com.yc.steam.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.steam.dao.GameDao;
import com.yc.steam.po.Game;
@Service
public class GameBiz {
	
	@Resource
	private GameDao gdao;
	
	public List<Game> selectGames(String gname) throws BizException{
		if("".equals(gname)) {
			return gdao.selectAll();
		}else {
			List<Game> list= gdao.selectByName(gname);
			if(null==list) {
				throw new BizException("未找到该游戏");
			}
			return list;
		}
		
	}
}
