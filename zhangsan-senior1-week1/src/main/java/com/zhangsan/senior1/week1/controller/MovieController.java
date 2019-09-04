package com.zhangsan.senior1.week1.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangsan.senior1.week1.bean.Category;
import com.zhangsan.senior1.week1.bean.Movie;
import com.zhangsan.senior1.week1.service.MovieService;
@Controller
public class MovieController {
	@Autowired
private MovieService service;
	@RequestMapping("add.do")
	@ResponseBody
	public Object add(Movie movie) {
		int i = service.add(movie);
		if(i>0) {
			//同时保存电影分类多对多数据
			Integer movie_id = movie.getId();
			List<Category> list = movie.getCategory();
			Iterator<Category> iterator = list.iterator();
			Map map=new HashMap();
			map.put("movie_id", movie_id);
			for (Category category : list) {
				Integer category_id = category.getId();
				map.put("category_id", category);
				int m=service.addmoviecategory(map);
			}
			
			return i;
		}else {
			return i;
		}
	}
	@RequestMapping("list.do")
	public String list(@RequestParam(defaultValue = "")String mohu1,@RequestParam(defaultValue = "1")Integer cpage,Model model) {
		Map map=new HashMap();
		map.put("mohu1", mohu1);
		PageHelper.startPage(cpage, 2);
		List list = service.list(map);
		PageInfo pi=new PageInfo(list);
		pi.getNextPage();
		pi.isIsFirstPage();
		pi.getPrePage();
		pi.getPages();
		pi.isIsLastPage();
		model.addAttribute("list", list);
		model.addAttribute("map", map);
		model.addAttribute("pi", pi);
		return "list";
	}
	@RequestMapping("tosuccess.do")
	public String tosuccess() {
		return "success";
	}
	@RequestMapping("toadd.do")
	public String toadd() {
		return "add";
	}
	@RequestMapping("dels.do")
	public String dels(String ids) {
		int i = service.dels(ids);
		if(i>0) {
			return "redirect:list.do";
		}else {
			return "error";
		}
	}
}
