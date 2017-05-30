package com.jackchan.takeoutservice.bean;

import java.util.List;
/**
 * ============================================================
 * Copyright：JackChan和他的朋友们有限公司版权所有 (c) 2017
 * Author：   JackChan
 * Email：    815712739@qq.com
 * GitHub：   https://github.com/JackChan1999
 * GitBook：  https://www.gitbook.com/@alleniverson
 * CSDN博客： http://blog.csdn.net/axi295309066
 * 个人博客： https://jackchan1999.github.io/
 * 微博：     AndroidDeveloper
 * <p>
 * Project_Name：TakeoutService
 * Package_Name：com.jackchan.takeoutservice
 * Version：1.0
 * time：2017/5/30 10:49
 * des ：外卖客户端服务器，用i-jetty搭建
 * gitVersion：2.12.0.windows.1
 * updateAuthor：AllenIverson
 * updateDate：2017/5/30 10:49
 * updateDes：${TODO}
 * ============================================================
 */
public class GoodsTypeInfo {
    int id;//商品类型id
    String name;//商品类型名称
    String info;//特价信息
    List<GoodsInfo> list;//商品列表
	public GoodsTypeInfo() {
		super();
	}
	public GoodsTypeInfo(int id, String name, String info, List<GoodsInfo> list) {
		super();
		this.id = id;
		this.name = name;
		this.info = info;
		this.list = list;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public List<GoodsInfo> getList() {
		return list;
	}
	public void setList(List<GoodsInfo> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "GoodsTypeInfo [id=" + id + ", name=" + name + ", info=" + info + ", list=" + list + "]";
	}
    
}
