package com.jackchan.takeoutservice.bean;

import java.util.ArrayList;
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
public class Head {
	ArrayList<Promotion> promotionList;
	ArrayList<Category> categorieList;

	public Head(ArrayList<Promotion> promotionList, ArrayList<Category> categorieList) {
		super();
		this.promotionList = promotionList;
		this.categorieList = categorieList;

	}

	public ArrayList<Promotion> getPromotionList() {
		return promotionList;
	}

	public void setPromotionList(ArrayList<Promotion> promotionList) {
		this.promotionList = promotionList;
	}

	public ArrayList<Category> getCategorieList() {
		return categorieList;
	}

	public void setCategorieList(ArrayList<Category> categorieList) {
		this.categorieList = categorieList;
	}

}
