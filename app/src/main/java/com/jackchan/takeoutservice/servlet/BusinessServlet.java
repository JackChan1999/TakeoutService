package com.jackchan.takeoutservice.servlet;

import com.jackchan.takeoutservice.ConstantValue;
import com.jackchan.takeoutservice.bean.GoodsInfo;
import com.jackchan.takeoutservice.bean.GoodsTypeInfo;
import com.jackchan.takeoutservice.bean.Response;
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
public class BusinessServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public BusinessServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    // 细品粗粮
    String[] types = new String[]{"13.9特价套餐", "粗粮主食", "佐餐小吃", "用心营养套餐（不含主食）", "三杯鸡双拼尊享套餐",
            "带鱼双拼螓享套餐", "双烧肉双拼智享套餐",
            "牛肉双拼乐享套餐", "精品凉菜", "饮品", "餐品加工中心及产品"};

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int sellerId = Integer.parseInt(request.getParameter("sellerId"));
        List<GoodsTypeInfo> list = new ArrayList<GoodsTypeInfo>();

        for (int i = 0; i < types.length; i++) {
            GoodsTypeInfo goodstypeInfo = new GoodsTypeInfo();
            if (i == 0) {
                goodstypeInfo.setInfo("(不与其它活动同享)13.9元特价套餐!!|13.9特价套餐!!(每单仅限2份)");
            }
            goodstypeInfo.setId(100 * sellerId + i + 1);
            goodstypeInfo.setName(types[i]);
            List<GoodsInfo> goodsInfoList = new ArrayList<GoodsInfo>();
            addGoodsInfo(sellerId, i, goodsInfoList);
            goodstypeInfo.setList(goodsInfoList);
            list.add(goodstypeInfo);
        }

        Response res = new Response();
        res.setCode("0");
        String data = JSONArray.fromObject(list).toString();
        res.setData(data);

        CommonUtil.renderJson(response, res);
    }

    private void addGoodsInfo(int sellerId, int i, List<GoodsInfo> list) {
        switch (i) {
            case 0:
                list.add(new GoodsInfo(sellerId * 1000 + 1, "肉末烧汁茄子+千叶豆腐套餐(含粗粮米饭)",
                        ImageServlet.baseurl + "imgs/goods/caiping_taocan.webp",
                        "肉末烧汁茄子+千叶豆腐+小食+时蔬+含粗粮米饭)",
                        53, true, false, 13.9f, 30));
                list.add(new GoodsInfo(sellerId * 1000 + 2, "肉末烧汁茄子+四季豆套餐(含粗粮米饭)",
                        ImageServlet.baseurl + "imgs/goods/caiping_taocan.webp",
                        "肉末烧汁茄子+榄菜肉末四季豆+小食+时蔬+含粗粮米饭)",
                        37, true, false, 13.9f, 30));
                list.add(new GoodsInfo(sellerId * 1000 + 3, "手撕杏鲍菇+千叶豆腐套餐(含粗粮米饭)",
                        ImageServlet.baseurl + "imgs/goods/caiping_taocan.webp",
                        "手撕杏鲍菇+千叶豆腐+小食+时蔬+含粗粮米饭)", 27,
                        true, false, 13.9f, 30));
                list.add(new GoodsInfo(sellerId * 1000 + 4, "肉末烧汁茄子+杏鲍菇套餐(含粗粮米饭)",
                        ImageServlet.baseurl + "imgs/goods/caiping_taocan.webp",
                        "肉末烧汁茄子+杏鲍菇+小食+时蔬+含粗粮米饭)", 24,
                        true, false, 13.9f, 30));
                list.add(new GoodsInfo(sellerId * 1000 + 5, "榄菜肉末四季豆+千叶豆腐套餐(含粗粮米饭)",
                        ImageServlet.baseurl + "imgs/goods/caiping_taocan.webp",
                        "榄菜肉末四季豆+千叶豆腐+小食+时蔬+含粗粮米饭)",
                        53, true, false, 13.9f, 30));
                list.add(new GoodsInfo(sellerId * 1000 + 6, "榄菜肉末四季豆+手撕杏鲍菇套餐(含粗粮米饭)",
                        ImageServlet.baseurl + "imgs/goods/caiping_taocan.webp",
                        "榄菜肉末四季豆+手撕杏鲍菇+小食+时蔬+含粗粮米饭)",
                        53, true, false, 13.9f, 30));
                break;
            case 1:
                list.add(new GoodsInfo(sellerId * 1000 + 6, "纯手工馒头(一个)",
                        ImageServlet.baseurl + "imgs/goods/mantou.webp", "", 54,
                        true, false, 1.5f, 0));
                list.add(new GoodsInfo(sellerId * 1000 + 7, "粗粮米饭",
                        ImageServlet.baseurl + "imgs/goods/culiangmifan.webp", "",
                        43, true, false, 2, 0));
                list.add(new GoodsInfo(sellerId * 1000 + 8, "黄金玉米饼(一个)",
                        ImageServlet.baseurl + "imgs/goods/huangjinyumibing.webp",
                        "", 24, true, false, 3,
                        0));
                list.add(new GoodsInfo(sellerId * 1000 + 9, "粗粮菜团子(一个)",
                        ImageServlet.baseurl + "imgs/goods/culiangcaituanzi.webp",
                        "", 10, true, false, 6,
                        0));
                break;
            case 2:
                list.add(new GoodsInfo(sellerId * 1000 + 11, "细品香肠",
                        ImageServlet.baseurl + "imgs/goods/xipingxiangchang.webp",
                        "", 10, true, false, 10,
                        0));
                list.add(new GoodsInfo(sellerId * 1000 + 12, "蝴蝶翅",
                        ImageServlet.baseurl + "imgs/goods/hudiechi.webp", "", 10,
                        true, false, 10, 0));
                list.add(new GoodsInfo(sellerId * 1000 + 13, "孜然鸡柳",
                        ImageServlet.baseurl + "imgs/goods/ziranjiliu.webp", "",
                        10, true, false, 10, 0));
                list.add(new GoodsInfo(sellerId * 1000 + 14, "盐酥鸡",
                        ImageServlet.baseurl + "imgs/goods/yansuji.webp", "", 10,
                        true, false, 10, 0));
                break;
            case 3:
                list.add(new GoodsInfo(sellerId * 1000 + 15, "放心-干烧带鱼套餐",
                        ImageServlet.baseurl + "imgs/goods/caiping.webp",
                        "干烧带鱼+五香香肠+小食+时蔬)", 53, true, false,
                        13.9f, 30));
                list.add(new GoodsInfo(sellerId * 1000 + 16, "安心-细品三杯鸡套餐(不含主食)",
                        ImageServlet.baseurl + "imgs/goods/caiping.webp",
                        "细品三杯鸡+五香香肠+鸡蛋羹+小食+清炒时蔬)", 9, true,
                        false, 13.9f, 30));
                list.add(new GoodsInfo(sellerId * 1000 + 17, "开心-细品红烧肉套餐(不含主食)",
                        ImageServlet.baseurl + "imgs/goods/caiping.webp",
                        "干烧带鱼+五香香肠+小食+时蔬)", 53, true, false,
                        13.9f, 30));
                list.add(new GoodsInfo(sellerId * 1000 + 18, "舒心-土豆烧牛肉套餐",
                        ImageServlet.baseurl + "imgs/goods/caiping.webp",
                        "土豆烧牛肉+五香香肠+小食+时蔬)", 53, true, false,
                        13.9f, 30));
                break;
            case 4:
                list.add(new GoodsInfo(sellerId * 1000 + 19, "三杯鸡+肉末烧汁茄子套餐",
                        ImageServlet.baseurl + "imgs/goods/caiping.webp",
                        "三杯鸡+肉末烧汁茄子+小食+时蔬)", 53, true, false,
                        22, 30));
                list.add(new GoodsInfo(sellerId * 1000 + 20, "三杯鸡+榄菜肉末四季豆套餐",
                        ImageServlet.baseurl + "imgs/goods/caiping.webp",
                        "三杯鸡+榄菜肉末四季豆+小食+时蔬)", 53, true,
                        false, 22, 30));
                list.add(new GoodsInfo(sellerId * 1000 + 21, "三杯鸡+手撕杏鲍菇套餐",
                        ImageServlet.baseurl + "imgs/goods/caiping.webp",
                        "三杯鸡+手撕杏鲍菇+小食+时蔬)", 53, true, false,
                        22, 30));
                list.add(new GoodsInfo(sellerId * 1000 + 22, "三杯鸡+干锅千叶豆腐套餐",
                        ImageServlet.baseurl + "imgs/goods/caiping.webp",
                        "三杯鸡+干锅千叶豆腐+小食+时蔬)", 53, true, false,
                        22, 30));
                break;
            case 5:
                list.add(new GoodsInfo(sellerId * 1000 + 23, "干烧带鱼+肉末烧汁茄子套餐",
                        ImageServlet.baseurl + "imgs/goods/caiping.webp",
                        "干烧带鱼+肉末烧汁茄子+小食+时蔬)", 53, true,
                        false, 22, 30));
                list.add(new GoodsInfo(sellerId * 1000 + 24, "干烧带鱼+榄菜肉末四季豆套餐",
                        ImageServlet.baseurl + "imgs/goods/caiping.webp",
                        "干烧带鱼+榄菜肉末四季豆+小食+时蔬)", 53, true,
                        false, 22, 30));
                list.add(new GoodsInfo(sellerId * 1000 + 25, "干烧带鱼+手撕杏鲍菇套餐",
                        ImageServlet.baseurl + "imgs/goods/caiping.webp",
                        "干烧带鱼+手撕杏鲍菇+小食+时蔬)", 53, true, false,
                        22, 30));
                list.add(new GoodsInfo(sellerId * 1000 + 26, "干烧带鱼+干锅千叶豆腐套餐",
                        ImageServlet.baseurl + "imgs/goods/caiping.webp",
                        "干烧带鱼+干锅千叶豆腐+小食+时蔬)", 53, true,
                        false, 22, 30));
                break;
            case 6:
                list.add(new GoodsInfo(sellerId * 1000 + 27, "红烧肉+肉末烧汁茄子套餐",
                        ImageServlet.baseurl + "imgs/goods/caiping.webp",
                        "红烧肉+肉末烧汁茄子+小食+时蔬)", 53, true, false,
                        22, 0));
                list.add(new GoodsInfo(sellerId * 1000 + 28, "红烧肉+榄菜肉末四季豆套餐",
                        ImageServlet.baseurl + "imgs/goods/caiping.webp",
                        "红烧肉+榄菜肉末四季豆+小食+时蔬)", 53, true,
                        false, 22, 0));
                list.add(new GoodsInfo(sellerId * 1000 + 29, "红烧肉+手撕杏鲍菇套餐",
                        ImageServlet.baseurl + "imgs/goods/caiping.webp",
                        "红烧肉+手撕杏鲍菇+小食+时蔬)", 53, true, false,
                        22, 0));
                list.add(new GoodsInfo(sellerId * 1000 + 30, "红烧肉+干锅千叶豆腐套餐",
                        ImageServlet.baseurl + "imgs/goods/caiping.webp",
                        "红烧肉+干锅千叶豆腐+小食+时蔬)", 53, true, false,
                        22, 0));
                break;
            case 7:
                list.add(new GoodsInfo(sellerId * 1000 + 31, "土豆烧牛肉+肉末烧汁茄子套餐",
                        ImageServlet.baseurl + "imgs/goods/caiping.webp",
                        "土豆烧牛肉+肉末烧汁茄子+小食+时蔬)", 53, true,
                        false, 25, 0));
                list.add(new GoodsInfo(sellerId * 1000 + 32, "土豆烧牛肉+榄菜肉末四季豆套餐",
                        ImageServlet.baseurl + "imgs/goods/caiping.webp",
                        "土豆烧牛肉+榄菜肉末四季豆+小食+时蔬)", 53, true,
                        false, 25, 0));
                list.add(new GoodsInfo(sellerId * 1000 + 33, "土豆烧牛肉+手撕杏鲍菇套餐",
                        ImageServlet.baseurl + "imgs/goods/caiping.webp",
                        "土豆烧牛肉+手撕杏鲍菇+小食+时蔬)", 53, true,
                        false, 25, 0));
                list.add(new GoodsInfo(sellerId * 1000 + 34, "土豆烧牛肉+干锅千叶豆腐套餐",
                        ImageServlet.baseurl + "imgs/goods/caiping.webp",
                        "土豆烧牛肉+干锅千叶豆腐+小食+时蔬)", 53, true,
                        false, 25, 0));
                break;
            case 8:
                list.add(new GoodsInfo(sellerId * 1000 + 35, "四川泡菜",
                        ImageServlet.baseurl + "imgs/goods/sichuanpaocai.webp", "",
                        53, true, false, 9, 0));
                list.add(new GoodsInfo(sellerId * 1000 + 36, "秘制萝卜条",
                        ImageServlet.baseurl + "imgs/goods/mizhiluobutiao.webp", "", 53, true, false, 9, 0));
                list.add(new GoodsInfo(sellerId * 1000 + 37, "开胃黄瓜",
                        ImageServlet.baseurl + "imgs/goods/kaiweihuanggua.webp", "", 53, true, false, 9, 0));
                break;
            case 9:
                list.add(new GoodsInfo(sellerId * 1000 + 38, "汇源果汁",
                        ImageServlet.baseurl + "imgs/goods/huiyuan.webp", "", 53, true, false, 3, 0));
                list.add(new GoodsInfo(sellerId * 1000 + 35, "蒙牛酸牛奶",
                        ImageServlet.baseurl + "imgs/goods/mengniusuanniunai.webp", "", 53, true, false, 3,
                        0));
                list.add(new GoodsInfo(sellerId * 1000 + 36, "红罐王老吉",
                        ImageServlet.baseurl + "imgs/goods/wanglaoji.webp", "", 53, true, false, 5, 0));
                list.add(new GoodsInfo(sellerId * 1000 + 37, "可口可乐",
                        ImageServlet.baseurl + "imgs/goods/kekoukele.webp", "", 53, true, false, 5, 0));
                list.add(new GoodsInfo(sellerId * 1000 + 38, "脉动",
                        ImageServlet.baseurl + "imgs/goods/maidong.webp", "", 53, true, false, 6, 0));
                list.add(new GoodsInfo(sellerId * 1000 + 39, "雀巢丝滑拿铁",
                        ImageServlet.baseurl + "imgs/goods/quechao.webp", "", 53, true, false, 6, 0));
                break;
            case 10:
                list.add(new GoodsInfo(sellerId * 1000 + 40, "产品",
                        ImageServlet.baseurl + "imgs/goods/caiping.webp", "", 53, true, false, 0, 0));
                list.add(new GoodsInfo(sellerId * 1000 + 41, "加工中心1",
                        ImageServlet.baseurl + "imgs/goods/jiagongzhongxin1.webp", "", 53, true, false, 0,
                        0));
                list.add(new GoodsInfo(sellerId * 1000 + 42, "加工中心2",
                        ImageServlet.baseurl + "imgs/goods/jiagongzhongxin2.webp", "", 53, true, false, 0,
                        0));
                list.add(new GoodsInfo(sellerId * 1000 + 43, "加工中心3",
                        ImageServlet.baseurl + "imgs/goods/jiagongzhongxin1.webp", "", 53, true, false, 0,
                        0));
                list.add(new GoodsInfo(sellerId * 1000 + 44, "加工中心4",
                        ImageServlet.baseurl + "imgs/goods/jiagongzhongxin4.webp", "", 53, true, false, 0,
                        0));
                list.add(new GoodsInfo(sellerId * 1000 + 45, "加工中心5",
                        ImageServlet.baseurl + "imgs/goods/jiagongzhongxin5.webp", "", 53, true, false, 0,
                        0));
                break;
        }
    }

}
