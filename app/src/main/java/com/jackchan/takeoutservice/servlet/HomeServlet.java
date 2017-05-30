package com.jackchan.takeoutservice.servlet;

import com.jackchan.takeoutservice.App;
import com.jackchan.takeoutservice.ConstantValue;
import com.jackchan.takeoutservice.bean.Category;
import com.jackchan.takeoutservice.bean.Head;
import com.jackchan.takeoutservice.bean.HomeInfo;
import com.jackchan.takeoutservice.bean.HomeItem;
import com.jackchan.takeoutservice.bean.Promotion;
import com.jackchan.takeoutservice.bean.Response;
import com.jackchan.takeoutservice.bean.Seller;
import com.jackchan.takeoutservice.utils.CommonUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取经纬度信息，并依据经纬度信息从数据库中获取需要检索的附近商家信息（mysql自持距离范围检索）

		// 测试使用静态数据
		Response resp = new Response();
		resp.setCode("0");

		// 设置data部分数据
		// 促销信息
		ArrayList<Promotion> promotionList = new ArrayList<Promotion>();
		for (int id = 1; id < 4; id++) {
			Promotion promotion = new Promotion();
			promotion.setId(id);
			// http://localhost:8080/TakeoutService/home/
			promotion.setPic(ConstantValue.HOST + "/TakeoutService/" + "imgs/promotion/" + id + ".jpg");

			promotion.setInfo("promotion info...");
			promotionList.add(promotion);
		}
		// 分类信息
		String[] catetories=new String[]{"美食","甜品饮料","商店超市","早餐","果蔬","新店","下午茶","麻辣烫"};
		ArrayList<Category> categorieList = new ArrayList<Category>();
		for (int id = 1; id < 9; id++) {
			Category category = new Category();
			category.setId(id);
			category.setPic(ConstantValue.HOST + "/TakeoutService/" + "imgs/category/" + id + ".png");
			category.setName(catetories[id-1]);
			categorieList.add(category);
		}

		// nearbySellerList
		ArrayList<Seller> nearbySellerList = new ArrayList<Seller>();
		Seller itcast = new Seller();
		itcast.setId(1);
		itcast.setPic(ConstantValue.HOST + "/TakeoutService/" + "imgs/category/" + 1 + ".png");
		itcast.setName("星星外卖项目");
		itcast.setScore("5");

		nearbySellerList.add(itcast);

		for (int i = 2; i < 10; i++) {
			Seller seller = new Seller();
			seller.setId(i);
			seller.setName("孟非小面第" + i + "家分店");
			nearbySellerList.add(seller);
		}

		// ortherSellerList
		ArrayList<Seller> ortherSellerList = new ArrayList<Seller>();

		for (int i = 10; i < 20; i++) {
			Seller seller = new Seller();
			seller.setId(i);
			seller.setName("孟非小面第" + i + "家分店");
			ortherSellerList.add(seller);
		}

		List<HomeItem> body = new ArrayList<>();
		for (Seller seller : nearbySellerList) {
			HomeItem sellerItem = new HomeItem();
			sellerItem.type = 0;
			sellerItem.seller = seller;
			body.add(sellerItem);
		}

		HomeItem item = new HomeItem();
		item.type = 1;
		item.recommendInfos = new ArrayList<>();

		item.recommendInfos.add("黄焖鸡");
		item.recommendInfos.add("米线");
		item.recommendInfos.add("孟非小面");
		item.recommendInfos.add("重庆火锅");
		item.recommendInfos.add("酸菜鱼");
		item.recommendInfos.add("啤酒鸭");

		body.add(item);

		for (Seller seller : ortherSellerList) {
			HomeItem sellerItem = new HomeItem();
			sellerItem.type = 0;
			sellerItem.seller = seller;
			body.add(sellerItem);
		}

		HomeInfo info = new HomeInfo(new Head(promotionList, categorieList), body);
		Response res = new Response();
		res.setCode("0");
		// res.setData(JSONObject.fromObject(info).toString());
		res.setData(App.getGson().toJson(info));

		CommonUtil.renderJson(response, res);

	}

}
