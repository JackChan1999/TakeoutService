package com.jackchan.takeoutservice.servlet;

import com.alibaba.fastjson.JSON;
import com.jackchan.takeoutservice.App;
import com.jackchan.takeoutservice.ConstantValue;
import com.jackchan.takeoutservice.bean.Distribution;
import com.jackchan.takeoutservice.bean.GoodsInfo;
import com.jackchan.takeoutservice.bean.Location;
import com.jackchan.takeoutservice.bean.Order;
import com.jackchan.takeoutservice.bean.OrderDetail;
import com.jackchan.takeoutservice.bean.OrderOverview;
import com.jackchan.takeoutservice.bean.Response;
import com.jackchan.takeoutservice.bean.Rider;
import com.jackchan.takeoutservice.bean.Seller;
import com.jackchan.takeoutservice.utils.CommonUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

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
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static HashMap<String, OrderOverview> map;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderServlet() {
		super();
		mapManager();
	}

	private void mapManager() {
		if (map == null) {
			map = new HashMap<>();
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int userId = 0;
		try {
			userId = Integer.parseInt(request.getParameter("userId"));
		} catch (Exception e) {
		}

		Response res = new Response();

		if (userId != 0) {

			List<Order> orderList = new ArrayList<>();

			for (int i = 9; i > 0; i--) {
				Order order = new Order();
				setOrder(order, i);

				orderList.add(order);
			}

			
			res.setCode("0");
			// res.setData(JSONArray.fromObject(orderList).toString());
			res.setData(App.getGson().toJson(orderList));

			
		}else{
			res.setCode("-1");
			res.setData("");
		}
		CommonUtil.renderJson(response, res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Response res = new Response();

		Random random = new Random();
		int num = random.nextInt(9999);

		String orderOverview = request.getParameter("orderOverview");
		if (orderOverview != null) {
			res.setCode("0");
			// 将用户订单保存到数据库中
			OrderOverview overview = JSON.parseObject(orderOverview, OrderOverview.class);
			overview.id = "1010 8027 3652 5688 " + num;
			map.put(overview.id, overview);

			res.setData(overview.id);

		} else {
			res.setCode("-1");
			res.setData("");
		}

		CommonUtil.renderJson(response, res);
	}

	private void setOrder(Order order, int i) {

		order.setId("1010 8027 3652 5689 3" + i);
		if (i == 9) {
			order.setType("10");
		} else {
			order.setType("50");
		}

		List<GoodsInfo> goodsInfos = new ArrayList<>();
		GoodsInfo goodsInfo = new GoodsInfo();
		goodsInfo.setName("红烧肉");
		goodsInfo.setNewPrice(25);
		goodsInfos.add(goodsInfo);

		GoodsInfo goodsInfo1 = new GoodsInfo();
		goodsInfo1.setName("米饭");
		goodsInfo1.setNewPrice(2);
		goodsInfos.add(goodsInfo1);

		GoodsInfo goodsInfo2 = new GoodsInfo();
		goodsInfo2.setName("雪碧");
		goodsInfo2.setNewPrice(4);
		goodsInfos.add(goodsInfo2);
		order.setGoodsInfos(goodsInfos);

		Rider rider = new Rider();
		rider.setId(100);
		rider.setName("孟非");
		rider.setPhone("1384380358");
		Location location = new Location();
		location.setLatitude("106.23");
		location.setLongitude("43.123");
		rider.setLocation(location);
		order.setRider(rider);

		Distribution distribution = new Distribution();
		distribution.setDes("星星配送");
		distribution.setType("1");
		order.setDistribution(distribution);

		OrderDetail detail = new OrderDetail();
		detail.setAddress("修正校区");
		detail.setPay("在线支付");
		detail.setPhone("135000000000");
		detail.setTime("2020-10-10 10:10:10");
		detail.setUsername("老黑");
		order.setDetail(detail);

		Seller itcast = new Seller();
		itcast.setId(1);
		itcast.setPic(ConstantValue.HOST + "/TakeoutService/" + "imgs/category/" + 1 + ".png");
		itcast.setName("星星外卖项目");
		itcast.setScore("5");
		order.setSeller(itcast);

	}

}
