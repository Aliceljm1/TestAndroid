package com.example.testandroid.frag;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.testandroid.R;


@SuppressLint("NewApi")
public class AnimeFragment extends Fragment {
	@Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {  
        return inflater.inflate(R.layout.fragment_anime, null);  
    }  
}
