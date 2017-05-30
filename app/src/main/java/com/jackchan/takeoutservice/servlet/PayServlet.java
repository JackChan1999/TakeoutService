package com.jackchan.takeoutservice.servlet;

import com.alibaba.fastjson.JSON;
import com.jackchan.takeoutservice.ConstantValue;
import com.jackchan.takeoutservice.bean.OrderOverviewResponse;
import com.jackchan.takeoutservice.bean.Payment;
import com.jackchan.takeoutservice.bean.Response;
import com.jackchan.takeoutservice.utils.CommonUtil;

import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.util.ArrayList;

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
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Response res = new Response();
		String orderId = request.getParameter("orderId");
		
		if(StringUtils.isNotBlank(orderId)){
			OrderOverviewResponse orderOverviewResponse = new OrderOverviewResponse();
			orderOverviewResponse.payDownTime = 15;
			orderOverviewResponse.money=50.0f;
			orderOverviewResponse.paymentInfo = new ArrayList<>();
			
			// 支付宝，微信
			Payment zfb = new Payment();
			zfb.id = 1;
			zfb.name = "支付宝";
			zfb.url = ConstantValue.HOST+"/TakeoutService/imgs/payment/zfb.png";
			orderOverviewResponse.paymentInfo.add(zfb);

			Payment wx = new Payment();
			wx.id = 2;
			wx.name = "微信支付";
			wx.url = ConstantValue.HOST+"/TakeoutService/imgs/payment/wx.png";
			orderOverviewResponse.paymentInfo.add(wx);

		
			res.setCode("0");

			res.setData(JSON.toJSONString(orderOverviewResponse));

			CommonUtil.renderJson(response, res);
		}else {
			res.setCode("-1");
			res.setData("");
		}

		CommonUtil.renderJson(response, res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
