package com.example.testandroid;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 */
public class FullscreenFragment extends Fragment implements OnClickListener {


	private RelativeLayout contentView;
	private Button tool;
	private Context mContext;
	private boolean isOne=true;
	private TitleView titleOne;
	private View mRecorderView;
	private TitleView titleTwo;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    View view=inflater.inflate(R.layout.activity_fullscreen,null);//需要转换
	    mContext=view.getContext();
		contentView=(RelativeLayout)view.findViewById(R.id.content_view);
		tool=(Button)view.findViewById(R.id.dummy_button);
		titleOne=new TitleViewOne(mContext);
		titleTwo=new TitleViewTwo(mContext);
		mRecorderView=titleOne;
		bindEvent();
		setView(isOne);
		return view;
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
