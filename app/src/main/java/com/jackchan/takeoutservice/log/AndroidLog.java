package com.jackchan.takeoutservice.log;

import android.util.Log;

import org.eclipse.jetty.util.log.Logger;
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
public class AndroidLog implements Logger {
    public static final String  __JETTY_TAG        = "Jetty";
    public static       boolean __isIgnoredEnabled = false;
    public String _name;

    public AndroidLog() {
        this("org.mortbay.ijetty.AndroidLog");
    }

    public AndroidLog(String name) {
        _name = name;
    }

    public String getName() {
        return _name;
    }


    public void debug(Throwable th) {
        if (Log.isLoggable(__JETTY_TAG, Log.DEBUG)) {
            Log.d(__JETTY_TAG, "", th);
        }
    }

    public void debug(String msg, Throwable th) {
        if (Log.isLoggable(__JETTY_TAG, Log.DEBUG)) {
            Log.d(__JETTY_TAG, msg, th);
        }
    }

    public void debug(String msg, Object... args) {
        if (Log.isLoggable(__JETTY_TAG, Log.DEBUG)) {
            Log.d(__JETTY_TAG, msg);
        }
    }

    public Logger getLogger(String name) {
        return new AndroidLog(name);
    }

    public void info(String msg, Object... args) {
        Log.i(__JETTY_TAG, msg);
    }

    public void info(Throwable th) {
        Log.i(__JETTY_TAG, "", th);
    }

    public void info(String msg, Throwable th) {
        Log.i(__JETTY_TAG, msg, th);
    }

    public boolean isDebugEnabled() {
        return Log.isLoggable(__JETTY_TAG, Log.DEBUG);
    }

    public void warn(Throwable th) {
        if (Log.isLoggable(__JETTY_TAG, Log.WARN))
            Log.e(__JETTY_TAG, "", th);
    }

    public void warn(String msg, Object... args) {
        if (Log.isLoggable(__JETTY_TAG, Log.WARN))
            Log.w(__JETTY_TAG, msg);
    }

    public void warn(String msg, Throwable th) {
        if (Log.isLoggable(__JETTY_TAG, Log.ERROR))
            Log.e(__JETTY_TAG, msg, th);
    }

    public boolean isIgnoredEnabled() {
        return __isIgnoredEnabled;
    }


    public void ignore(Throwable ignored) {
        if (__isIgnoredEnabled)
            Log.w(__JETTY_TAG, "IGNORED", ignored);
    }

    public void setIgnoredEnabled(boolean enabled) {
        __isIgnoredEnabled = enabled;
    }

    public void setDebugEnabled(boolean enabled) {

    }
}