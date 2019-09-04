package com.zhangsan.senior1.week1.service;

import java.util.List;
import java.util.Map;

import com.zhangsan.senior1.week1.bean.Movie;

public interface MovieService {
	//添加
 int add(Movie movie);
 //列表
 List list(Map map);
 //修改
 int upd(Movie movie);
 //回显
 Movie huixian(Movie movie);
 //批删
 int dels(String ids);
int addmoviecategory(Map map);
}
