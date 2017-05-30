package com.jackchan.takeoutservice.server;

import com.jackchan.takeoutservice.servlet.AddressServlet;
import com.jackchan.takeoutservice.servlet.BusinessServlet;
import com.jackchan.takeoutservice.servlet.HomeServlet;
import com.jackchan.takeoutservice.servlet.ImageServlet;
import com.jackchan.takeoutservice.servlet.OrderServlet;
import com.jackchan.takeoutservice.servlet.PayServlet;
import com.jackchan.takeoutservice.servlet.SellerListServlet;
import com.jackchan.takeoutservice.servlet.UserLoginServlet;

import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
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
public class ServlertConfig {
    public static void config(ServletContextHandler handler) {
        handler.addServlet(new ServletHolder(new AddressServlet()), "/TakeoutService/address");
        handler.addServlet(new ServletHolder(new BusinessServlet()), "/TakeoutService/goods");
        handler.addServlet(new ServletHolder(new HomeServlet()), "/TakeoutService/home");
        handler.addServlet(new ServletHolder(new OrderServlet()), "/TakeoutService/order");
        handler.addServlet(new ServletHolder(new PayServlet()), "/TakeoutService/pay");
        handler.addServlet(new ServletHolder(new SellerListServlet()), "/TakeoutService/sellerlist");
        handler.addServlet(new ServletHolder(new UserLoginServlet()), "/TakeoutService/login");
        handler.addServlet(new ServletHolder(new ImageServlet()), "/TakeoutService/image");
    }
}
