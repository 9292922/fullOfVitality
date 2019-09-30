package com.magicalstory.vitality;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import com.magicalstory.vitality.databinding.FragmentHomeBinding;

public class MainActivity  extends AppCompatActivity  {
    ViewModel viewModel;
  FragmentHomeBinding dataBinding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding=DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        viewModel = ViewModelProviders.of(MainActivity.this).get(MainActivityViewModel.class);
        setStateBar();//设置状态栏

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    private void setStateBar() {
       appUtil.setStateBar(MainActivity.this);
    }


    public void newTask(View view) {
       //跳转新增任务
    }
}
