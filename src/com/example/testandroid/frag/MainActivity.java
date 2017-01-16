package com.example.testandroid.frag;

import java.util.ArrayList;
import java.util.List;

import com.example.testandroid.FullscreenFragment;
import com.example.testandroid.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

@SuppressLint("NewApi")
public class MainActivity extends Activity implements OnClickListener {

	private Button movieBtn, tvBtn, animeBtn, varietyBtn;
	private List<Button> btnList = new ArrayList<Button>();
	private FragmentManager fm;
	private FragmentTransaction ft;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findById();
		fm = getFragmentManager();
		ft = fm.beginTransaction();

		setBackgroundColorById(R.id.movie_btn);
		ft.replace(R.id.fragment_content, new MovieFragment());
		
		ft.commit();
	}

	private void findById() {
		movieBtn = (Button) this.findViewById(R.id.movie_btn);
		tvBtn = (Button) this.findViewById(R.id.tv_btn);
		animeBtn = (Button) this.findViewById(R.id.anime_btn);
		varietyBtn = (Button) this.findViewById(R.id.variety_btn);
		movieBtn.setOnClickListener(this);
		tvBtn.setOnClickListener(this);
		animeBtn.setOnClickListener(this);
		varietyBtn.setOnClickListener(this);

		btnList.add(movieBtn);
		btnList.add(tvBtn);
		btnList.add(animeBtn);
		btnList.add(varietyBtn);
	}

	private void setBackgroundColorById(int btnId) {
		for (Button btn : btnList) {
			if (btn.getId() == btnId) {
				btn.setBackgroundColor(Color.GREEN);
			} else {
				btn.setBackgroundColor(Color.BLUE);
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		fm = getFragmentManager();
		ft = fm.beginTransaction();
		switch (v.getId()) {

		case R.id.movie_btn:
			setBackgroundColorById(R.id.movie_btn);

			ft.replace(R.id.fragment_content, new MovieFragment());
			break;

		case R.id.tv_btn:
			setBackgroundColorById(R.id.tv_btn);

			ft.replace(R.id.fragment_content, new FullscreenFragment());
			break;

		case R.id.anime_btn:
			setBackgroundColorById(R.id.anime_btn);

			ft.replace(R.id.fragment_content, new AnimeFragment());
			break;

		case R.id.variety_btn:
			setBackgroundColorById(R.id.variety_btn);

			ft.replace(R.id.fragment_content, new VarietyFragment());
			break;

		default:
			break;
		}
		// ��Ҫ����ύ
		ft.commit();
	}

}
