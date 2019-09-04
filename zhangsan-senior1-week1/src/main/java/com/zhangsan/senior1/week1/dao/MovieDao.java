package com.zhangsan.senior1.week1.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zhangsan.senior1.week1.bean.Movie;

public interface MovieDao {
	//添加
 int add(Movie movie);
 //列表
 List list(Map map);
 //修改
 int upd(Movie movie);
 //回显
 Movie huixian(Movie movie);
 //批删
 int dels(@Param("ids")String ids);
 //添加多对多关系
int addmoviecategory(Map map);
}
