package com.example.testandroid; 

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

/** 
 * @author 刘泾铭
 * @version 创建时间：2017-1-11 上午11:04:18 
 * 类说明 
 */
public  class TitleView extends RelativeLayout {

	private TextView tit;
	public TitleView(Context context) {
		super(context);
		LayoutInflater.from(context).inflate(R.layout.title_bar, this);
		tit=(TextView) findViewById(R.id.title_tv);
	}

	protected void setText(String title) {
		tit.setText(title);
	}
	
}
