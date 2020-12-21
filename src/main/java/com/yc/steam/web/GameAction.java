package com.yc.steam.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.steam.dao.GameDao;
import com.yc.steam.po.game;

@RestController
public class GameAction {
	
	@Resource
	private GameDao gdao;
	
	@RequestMapping(path="game.s",params = "op=queryTopGame")
	public List<game> queryTopGame(){
		return gdao.selectTop();
	}
	
	
}
