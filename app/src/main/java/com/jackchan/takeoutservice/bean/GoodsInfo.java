package com.jackchan.takeoutservice.bean;
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
public class GoodsInfo {
    int id;//商品id
    String name;//商品名称
    String icon;//商品图片
    String form;//组成
    int monthSaleNum;//月销售量
    boolean bargainPrice;//特价
    boolean isNew;//是否是新产品
    float newPrice;//新价
    int oldPrice;//原价
	public GoodsInfo() {
		super();
	}
	
	public GoodsInfo(int id, String name, String icon, String form, int monthSaleNum, boolean bargainPrice,
			boolean isNew, float newPrice, int oldPrice) {
		super();
		this.id = id;
		this.name = name;
		this.icon = icon;
		this.form = form;
		this.monthSaleNum = monthSaleNum;
		this.bargainPrice = bargainPrice;
		this.isNew = isNew;
		this.newPrice = newPrice;
		this.oldPrice = oldPrice;
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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public int getMonthSaleNum() {
		return monthSaleNum;
	}

	public void setMonthSaleNum(int monthSaleNum) {
		this.monthSaleNum = monthSaleNum;
	}

	public boolean isBargainPrice() {
		return bargainPrice;
	}

	public void setBargainPrice(boolean bargainPrice) {
		this.bargainPrice = bargainPrice;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public float getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(float newPrice) {
		this.newPrice = newPrice;
	}

	public int getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(int oldPrice) {
		this.oldPrice = oldPrice;
	}

	@Override
	public String toString() {
		return "GoodsInfo [id=" + id + ", name=" + name + ", icon=" + icon + ", form=" + form + ", monthSaleNum="
				+ monthSaleNum + ", bargainPrice=" + bargainPrice + ", isNew=" + isNew + ", newPrice=" + newPrice
				+ ", oldPrice=" + oldPrice + "]";
	}
    
}
