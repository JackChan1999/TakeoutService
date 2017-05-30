package com.jackchan.takeoutservice.servlet;

import com.alibaba.fastjson.JSONObject;
import com.jackchan.takeoutservice.bean.AddressInfo;
import com.jackchan.takeoutservice.bean.Response;
import com.jackchan.takeoutservice.utils.CommonUtil;

import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

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
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressServlet() {
        super();
        loadData();
    }
    
    static HashMap<Long, CopyOnWriteArrayList<AddressInfo>> db;
    static{
    	db=new HashMap<>();
    }
	private void loadData() {
		// 读取json文件，操作用户地址列表
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		long userId = 0;
		String addressInfo=null;
		try {
			userId = Long.parseLong(request.getParameter("userId"));
			addressInfo=request.getParameter("info");
		} catch (Exception e) {
		}
		
		Response res=new Response();
		
		
		if(userId!=0){
			res.setCode("0");
			if(StringUtils.isNotBlank(addressInfo)){
				// 地址修改
				AddressInfo info = JSONObject.parseObject(addressInfo, AddressInfo.class);
				CopyOnWriteArrayList<AddressInfo> arrayList = db.get(userId);
				if(arrayList!=null&&arrayList.size()>0){
					for (AddressInfo item : arrayList) {
						if(item._id==info._id){
							arrayList.remove(item);
							break;
						}
					}
					arrayList.add(info);
					
				}else{
					arrayList=new CopyOnWriteArrayList<>();
					arrayList.add(info);
					db.put(userId, arrayList);
				}
			}else{
				// 获取该用户的地址列表数据
				CopyOnWriteArrayList<AddressInfo> arrayList = db.get(userId);
				if(arrayList!=null&&arrayList.size()>0){
					res.setData(net.sf.json.JSONObject.fromObject(arrayList).toString());
				}
			}
		}else{
			res.setCode("-1");
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
