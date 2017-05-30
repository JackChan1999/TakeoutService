package com.jackchan.takeoutservice.servlet;

import com.jackchan.takeoutservice.bean.Response;
import com.jackchan.takeoutservice.bean.User;
import com.jackchan.takeoutservice.utils.CommonUtil;

import net.sf.json.JSONObject;

import java.io.IOException;
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
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public UserLoginServlet() {
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
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		Random random=new Random(System.currentTimeMillis());
		
		int num=random.nextInt(9999)+1;
		
		if(name==null||name.length()==0)
		{
			name="random"+num;
		}
		
		int type = Integer.parseInt(request.getParameter("type"));

		String phone=null;
		if (type==2) {
			phone = request.getParameter("phone");
		}
		
		Response res = new Response();
		res.setCode("0");
		User user = new User();
		
		
		user.set_id(num);
		user.setName(name);
		user.setBalance(1.0f);
		user.setDiscount(0);
		user.setIntegral(0);
		if (phone != null)
			user.setPhone(phone);
		res.setData(JSONObject.fromObject(user).toString());

		CommonUtil.renderJson(response, res);
	}

}
