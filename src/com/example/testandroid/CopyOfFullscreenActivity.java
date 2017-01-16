package com.example.testandroid;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 */
public class CopyOfFullscreenActivity extends Activity implements OnClickListener {


	private RelativeLayout contentView;
	private Button tool;
	private Context mContext;
	private boolean isOne=true;
	private TitleView titleOne;
	private View mRecorderView;
	private TitleView titleTwo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext=this;
		setContentView(R.layout.activity_fullscreen);
		contentView=(RelativeLayout) findViewById(R.id.content_view);
		tool=(Button) findViewById(R.id.dummy_button);
		titleOne=new TitleViewOne(mContext);
		titleTwo=new TitleViewTwo(mContext);
		mRecorderView=titleOne;
		bindEvent();
		setView(isOne);
		
	}

	private void setView(boolean isOne)
	{
		if(isOne)
			contentView.addView(titleOne);
		else
			contentView.addView(titleTwo);
	}
	
	private void bindEvent() {
	   tool.setOnClickListener(this);	
	}


	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.dummy_button){
			Toast.makeText(mContext, "show", 2000).show();
	        isOne=!isOne;
	        releaseView();
			setView(isOne);
		}
	}
	
	private void releaseView()
	{
		contentView.destroyDrawingCache();
		contentView.removeAllViews();
	}

}
