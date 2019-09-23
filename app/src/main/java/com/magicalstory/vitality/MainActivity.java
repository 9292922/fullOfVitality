package com.magicalstory.vitality;

import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity  extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setStateBar();//设置状态栏
    }
    private void setStateBar() {
       appUtil.setStateBar(MainActivity.this);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        //实现fragment方法
    }



}
