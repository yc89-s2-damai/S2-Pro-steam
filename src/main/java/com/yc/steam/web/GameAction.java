package com.yc.steam.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yc.steam.biz.BizException;
import com.yc.steam.biz.GameBiz;
import com.yc.steam.dao.GameDao;
import com.yc.steam.po.Game;
import com.yc.steam.po.Result;

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
	
	@RequestMapping(path = "game.s",params = "op=selectBygid")
	public List<Game> selectBygid(int gid){
		return  gdao.selectBygid(gid);
	}
	
	@RequestMapping(path = "game.s",params = "op=queryCateNew")
	public List<Game> queryCateNew(){
		return gdao.selectcateNew();
	}
	@RequestMapping(path = "game.s",params = "op=queryCatehot")
	public List<Game> queryCateHot(){
		return gdao.selectcateIsHot();
	}
	@RequestMapping(path = "game.s",params = "op=queryById")
	public Game quertById(int gid) {
		return gdao.selectById(gid);
	}
	@RequestMapping(path = "game.s",params = "op=selectGamesAll")
	public List<?> selectAllGames(){
		return gdao.selectGamesAll();
	}
	@RequestMapping(path = "game.s",params = "op=querycById")
	public Game quertcById(int gid) {
		return gdao.selectById(gid);
	}
	
	//删除商品
	@RequestMapping(path = "game.s",params = "op=delById")
	public Result delGame(int gid) {
		gdao.delGameById(gid);
		return Result.success("商品删除成功!");
	}
	//修改商品
	@RequestMapping("updateById")
	public Result updateGameById(Game game) {
		System.out.println("=============="+game);
		gdao.updateGameById(game);
		return Result.success("商品修改成功!");
	}
	@RequestMapping(path = "game.s",params = "op=addGame")
	public Result addGame(@RequestParam(value="images") MultipartFile[] files,Game game) throws IllegalStateException, IOException {
		String filepath ="d:/a/";
		for(MultipartFile file:files) {
			file.transferTo(new File(filepath + file.getOriginalFilename()));
		}
		game.setImage1("assets/images/game"+files[0].getOriginalFilename());
		game.setImage2("assets/images/game"+files[1].getOriginalFilename());
		game.setImage3("assets/images/game"+files[2].getOriginalFilename());
		game.setImage4("assets/images/game"+files[3].getOriginalFilename());
		gdao.addGame(game);
		return Result.success("添加成功!");
	}
	
}