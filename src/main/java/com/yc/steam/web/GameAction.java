package com.yc.steam.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.steam.biz.BizException;
import com.yc.steam.biz.GameBiz;
import com.yc.steam.dao.GameDao;
import com.yc.steam.po.Game;

@RestController
public class GameAction {
	
	@Resource
	private GameDao gdao;
	
	@Resource
	private GameBiz gbiz;
	//首页顶部查询
	@RequestMapping(path="game.s",params = "op=queryTopGame")
	public List<Game> queryTopGame(){
		return gdao.selectTop();
	}
	//首页精品游戏查询
	@RequestMapping(path = "game.s",params = "op=queryFeatur")
	public List<Game> queryFeatur(){
		return gdao.selectFeatur();
	}
	
	@RequestMapping(path = "game.s",params = "op=queryNew")
	public List<Game> queryNew(){
		return gdao.selectNew();
	}
	
	@RequestMapping(path = "game.s",params = "op=queryhot")
	public List<Game> queryIshot(){
		return gdao.selectIsHot();
	}
	

	@RequestMapping(path = "game.s",params = "op=queryGames")	
	public List<Game> quertGames(String gname) throws BizException{
		System.out.println("========="+gname);
		return gbiz.selectGames(gname);
	}
	@RequestMapping(path = "game.s",params = "op=selectall")
	public List<Game> selectall(int cid){
		return  gdao.selectAll(cid);
	}
}
