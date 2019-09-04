package com.zhangsan.senior1.week1.bean;

import java.util.Date;
import java.util.List;

public class Movie {
private Integer id;
private String name;
private String intorduce;//����
private String actor;//����
private Date beginDate;//��������
private List<Category>category;
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
public String getIntorduce() {
	return intorduce;
}
public void setIntorduce(String intorduce) {
	this.intorduce = intorduce;
}
public String getActor() {
	return actor;
}
public void setActor(String actor) {
	this.actor = actor;
}
public Date getBeginDate() {
	return beginDate;
}
public void setBeginDate(Date beginDate) {
	this.beginDate = beginDate;
}
public List<Category> getCategory() {
	return category;
}
public void setCategory(List<Category> category) {
	this.category = category;
}
public Movie(Integer id, String name, String intorduce, String actor, Date beginDate, List<Category> category) {
	super();
	this.id = id;
	this.name = name;
	this.intorduce = intorduce;
	this.actor = actor;
	this.beginDate = beginDate;
	this.category = category;
}
public Movie() {
	super();
}

@Override
public String toString() {
	return "Movie [id=" + id + ", name=" + name + ", intorduce=" + intorduce + ", actor=" + actor + ", beginDate="
			+ beginDate + ", category=" + category + "]";
}

}
