package com.yc.steam.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.steam.dao.GameDao;
import com.yc.steam.po.Game;
import com.yc.steam.util.Utils;
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
	public void addGame(Game game) throws BizException {
		Utils.checkNull(game.getGname(), "请填写游戏名称");
		Utils.checkNull(game.getGname(), "请填写游戏类型");
		Utils.checkNull(game.getGname(), "请填写游戏描述");
		
		List<Game> list=gdao.selectByName(game.getGname());
		if(list!=null) {
			throw new BizException("已存在该游戏");
		}else if(null==list) {
			gdao.addGame(game);
		}
		
	}
}
