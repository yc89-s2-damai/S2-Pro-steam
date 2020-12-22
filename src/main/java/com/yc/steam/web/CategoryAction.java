package com.yc.steam.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.steam.dao.CategoryDao;
import com.yc.steam.po.Category;

@RestController
public class CategoryAction {
	
	@Resource
	private CategoryDao cgdao;
	
	@RequestMapping(path = "category.s",params = "op=queryAll")
	public List<Category> queryAll(){
		return cgdao.selectAll();
	}
}
