package com.jackchan.takeoutservice.utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jackchan.takeoutservice.App;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsDateJsonBeanProcessor;

import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

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

public class CommonUtil {
	//header 常量定义//
	private static final String ENCODING_PREFIX = "encoding";
	private static final String NOCACHE_PREFIX = "no-cache";
	private static final String ENCODING_DEFAULT = "UTF-8"; //
	private static final boolean NOCACHE_DEFAULT = true;

	//content-type 定义 //
	private static final String TEXT = "text/plain";
	private static final String JSON = "application/json";
	private static final String XML = "text/xml";
	private static final String HTML = "text/html";


	// 绕过jsp/freemaker直接输出文本的函数 //

	/**
	 * 直接输出内容的简便函数.

	 * eg.
	 * render("text/plain", "hello", "encoding:GBK");
	 * render("text/plain", "hello", "no-cache:false");
	 * render("text/plain", "hello", "encoding:GBK", "no-cache:false");
	 * 
	 * @param headers 可变的header数组，目前接受的值为"encoding:"或"no-cache:",默认值分别为UTF-8和true.
	 */
	public static void render(final HttpServletResponse response,final String contentType, final String content, final String... headers) {
		try {
			//分析headers参数
			String encoding = ENCODING_DEFAULT;
			boolean noCache = NOCACHE_DEFAULT;
			for (String header : headers) {
				String headerName = StringUtils.substringBefore(header, ":");
				String headerValue = StringUtils.substringAfter(header, ":");

				if (StringUtils.equalsIgnoreCase(headerName, ENCODING_PREFIX)) {
					encoding = headerValue;
				} else if (StringUtils.equalsIgnoreCase(headerName, NOCACHE_PREFIX)) {
					noCache = Boolean.parseBoolean(headerValue);
				} else
					throw new IllegalArgumentException(headerName + "不是一个合法的header类型");
			}

			//设置headers参数
			String fullContentType = contentType + ";charset=" + encoding;
			response.setContentType(fullContentType);
			if (noCache) {
				response.setHeader("Pragma", "No-cache");
				response.setHeader("Cache-Control", "no-cache");
				response.setDateHeader("Expires", 0);
			}

			PrintWriter writer = response.getWriter();
			writer.write(content);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 直接输出文本.
	 * @see #render(String, String, String...)
	 */
	public static void renderText(final HttpServletResponse response,final String text, final String... headers) {
		render(response,TEXT, text, headers);
	}

	/**
	 * 直接输出HTML.
	 * @see #render(String, String, String...)
	 */
	public static void renderHtml(final HttpServletResponse response,final String html, final String... headers) {
		render(response,HTML, html, headers);
	}

	/**
	 * 直接输出XML.
	 * @see #render(String, String, String...)
	 */
	public static void renderXml(final HttpServletResponse response,final String xml, final String... headers) {
		render(response,XML, xml, headers);
	}

	/**
	 * 直接输出JSON.
	 * 
	 * @param jsonString json字符串.
	 * @see #render(String, String, String...)
	 */
	public static void renderJson(final HttpServletResponse response,final String jsonString, final String... headers) {
		render(response,JSON, jsonString, headers);
	}

	/**
	 * 直接输出JSON.
	 * 
	 * @param map Map对象,将被转化为json字符串.
	 */
	@SuppressWarnings("unchecked")
	public static void renderJson(final HttpServletResponse response,final Map map, final String... headers) {
		String jsonString = JSONObject.fromObject(map).toString();
		render(response,JSON, jsonString, headers);
	}

	/**
	 * 直接输出JSON.
	 * 
	 * @param object Java对象,将被转化为json字符串.
	 */
	public static void renderJson(final HttpServletResponse response,final Object object, final String... headers) {
		// String jsonString = JSONObject.fromObject(object).toString();
		String jsonString = App.getGson().toJson(object);
		render(response,JSON, jsonString, headers);
	}
	
	/**
	 * 直接输出JSON.
	 * @param response
	 * @param list
	 * @param headers
	 */
	public static void renderJson(final HttpServletResponse response,final List<?> list, final String... headers) {
		// String jsonString = JSONArray.fromObject(list).toString();
		String jsonString = App.getGson().toJson(list);
		render(response,JSON, jsonString, headers);
	}
	
	/**
	 * 直接输出JSON.含有java.sql.date数据类型
	 * @param response
	 * @param object
	 * @param headers
	 */
	public static void renderJsonForSqlDate(final HttpServletResponse response,final Object object, final String... headers) {
		JsDateJsonBeanProcessor beanProcessor = new JsDateJsonBeanProcessor();
 		JsonConfig config = new JsonConfig();
 		config.registerJsonBeanProcessor(java.sql.Date.class, beanProcessor);
 		JSONObject json = JSONObject.fromObject(object, config);
		// Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		render(response,JSON, json.toString(), headers);
	}
	
	
	public static void main(String args[]){
		
	}
	
	/**
	 * 直接输出内容与转发
	 * @param rep
	 * @param message
	 * @param headers
	 */
	public static void renderScript(final HttpServletResponse rep,final String message,final String... headers){
			PrintWriter printer = null;
			try {
				rep.setContentType("text/html;charset=UTF-8");
				printer = rep.getWriter();
				printer.write("<script language = 'javascript'>");
				printer.write("alert('"+message+"'),");
				printer.write("window.history.go(-1)");
				printer.write("</script>");
			} catch (IOException e) {
				System.err.println(e.getLocalizedMessage());
			} finally {
				if (printer != null) {
					printer.close();
				}
			}
	}
	
	/**
	 * json To List<?>
	 * @param jsonStr
	 * @param objClass
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static List<?> toList(final String jsonStr,Class<?> objClass){
		  JSONArray jsArray = JSONArray.fromObject(jsonStr);
		  List<?> list = JSONArray.toList(jsArray, objClass);
		  return list;
	}
	
	/**
	 * json to object
	 * @param jsonStr
	 * @param objClass
	 * @return
	 */
	public static Object toObject(final String jsonStr,Class<?> objClass){
		JSONObject jsObject = JSONObject.fromObject(jsonStr);
		return JSONObject.toBean(jsObject, objClass);
	}
	
}