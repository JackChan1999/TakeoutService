package com.jackchan.takeoutservice.bean;

import java.util.List;
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
public class OrderOverview {
	/*
	{
        "addressId":1 ,
        "userId":1 ,
        "cart": [
        	{"id":1,"num":1},
        	{"id":2,"num":1},
        	{"id":3,"num":2}
        ],
        "sellerId":1 ,
        "type": 10
    }
    */
	
	public int addressId;
	public int userId;
	public List<Cart> cart;
	public long sellerid;
	public int type;
	
	public String id;
}
