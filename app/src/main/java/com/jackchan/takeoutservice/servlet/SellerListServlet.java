package com.jackchan.takeoutservice.servlet;

import com.jackchan.takeoutservice.bean.Response;
import com.jackchan.takeoutservice.bean.Seller;
import com.jackchan.takeoutservice.utils.CommonUtil;

import net.sf.json.JSONArray;

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
public class SellerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--------获取商家列表--------");
		List<Seller> list=new ArrayList<Seller>();
		
		for(int i=1;i<10;i++){
			Seller seller=new Seller();
			seller.setId(i);
			seller.setName("孟非小面第"+i+"家分店");
			list.add(seller);
		}
		
		
		
		Response res=new Response();
		res.setCode("0");
		String data="{\"list\":"+JSONArray.fromObject(list).toString()+"}";
		res.setData(data);
		
		CommonUtil.renderJson(response, res);
	}

}
