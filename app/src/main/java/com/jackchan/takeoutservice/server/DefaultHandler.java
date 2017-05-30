package com.jackchan.takeoutservice.server;

import org.eclipse.jetty.server.Request;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
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
public class DefaultHandler extends org.eclipse.jetty.server.handler.DefaultHandler {


	public DefaultHandler() {

	}

	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		if (response.isCommitted() || baseRequest.isHandled())
			return;

		baseRequest.setHandled(true);
		// String method = request.getMethod();//请求方式
		request.getRequestURI();// 请求路径

		System.out.println("URI" + request.getRequestURI());
		System.out.println("URL" + request.getRequestURI());
		response.setStatus(HttpServletResponse.SC_OK);
		// response.setContentType(MimeTypes.TEXT_JSON);
		String str = "我是返回内容";
		byte[] b = str.getBytes();
		response.setContentLength(b.length);
		OutputStream out = response.getOutputStream();
		out.write(b);
		out.close();
	}
}
