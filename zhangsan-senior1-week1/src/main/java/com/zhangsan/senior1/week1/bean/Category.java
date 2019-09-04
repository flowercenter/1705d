package com.zhangsan.senior1.week1.bean;

import java.util.List;

public class Category {
private Integer id;
private String name;
private List<Movie>movie;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<Movie> getMovie() {
	return movie;
}
public void setMovie(List<Movie> movie) {
	this.movie = movie;
}
public Category(Integer id, String name, List<Movie> movie) {
	super();
	this.id = id;
	this.name = name;
	this.movie = movie;
}
public Category() {
	super();
}
@Override
public String toString() {
	return "Category [id=" + id + ", name=" + name + ", movie=" + movie + "]";
}

}
