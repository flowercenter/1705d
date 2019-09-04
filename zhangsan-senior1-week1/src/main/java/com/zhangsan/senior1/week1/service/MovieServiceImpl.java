package com.zhangsan.senior1.week1.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangsan.senior1.week1.bean.Movie;
import com.zhangsan.senior1.week1.dao.MovieDao;
@Service
public class MovieServiceImpl implements MovieService{
	@Autowired
 private MovieDao dao;
	@Override
	public int add(Movie movie) {
		// TODO Auto-generated method stub
		return dao.add(movie);
	}

	@Override
	public List list(Map map) {
		// TODO Auto-generated method stub
		return dao.list(map);
	}

	@Override
	public int upd(Movie movie) {
		// TODO Auto-generated method stub
		return dao.upd(movie);
	}

	@Override
	public Movie huixian(Movie movie) {
		// TODO Auto-generated method stub
		return dao.huixian(movie);
	}

	@Override
	public int dels(String ids) {
		// TODO Auto-generated method stub
		return dao.dels(ids);
	}

	@Override
	public int addmoviecategory(Map map) {
		// TODO Auto-generated method stub
		return dao.addmoviecategory(map);
	}

}
