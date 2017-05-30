package com.jackchan.takeoutservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jackchan.takeoutservice.log.AndroidLog;
import com.jackchan.takeoutservice.server.WebService;

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
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
	private Button mBtStart, mBtStop, mBtSetting;
	//	public static final File JETTY_DIR;
	//	public static final String WEBAPP_DIR = "webapps";
	//	public static final String ETC_DIR = "etc";
	//	public static final String CONTEXTS_DIR = "contexts";
	//
	static {
		// 不使用jetty的XML解析验证
		System.setProperty("org.eclipse.jetty.xml.XmlParser.Validating", "false");
		// 使用android日志类
		System.setProperty("org.eclipse.jetty.util.log.class", "org.mortbay.ijetty.AndroidLog");
		org.eclipse.jetty.util.log.Log.setLog(new AndroidLog());
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mBtStart = (Button) findViewById(R.id.bt_start);
		mBtStop = (Button) findViewById(R.id.bt_stop);
		mBtSetting = (Button) findViewById(R.id.bt_setting);
		mBtStart.setOnClickListener(this);
		mBtStop.setOnClickListener(this);
		mBtSetting.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.bt_start:
				onStartClick();
				break;
			case R.id.bt_stop:
				onStopClick();
				break;
			case R.id.bt_setting:
				onSettingClick();
				break;
		}
	}

	public void onStartClick() {
		Intent intent = new Intent(this, WebService.class);
		startService(intent);
	}

	public void onStopClick() {
		Intent intent = new Intent(this, WebService.class);
		stopService(intent);
	}

	public void onSettingClick() {

	}
}
