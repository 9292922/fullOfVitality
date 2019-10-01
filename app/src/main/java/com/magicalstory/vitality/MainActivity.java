package com.magicalstory.vitality;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    ViewModel viewModel;
    int bottomCode=R.id.main;//定义底部栏当前页面标识
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = ViewModelProviders.of(MainActivity.this).get(MainActivityViewModel.class);
        setBottomBar();//设置底部栏的事件
        setStateBar();//设置状态栏

    }

    private void setBottomBar() {

        final BottomNavigationView bottomNavigationView = findViewById(R.id.bottomBar);
        //监听底部栏点击事件
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.main:
                        if (!(bottomCode == R.id.main)) {
                            Navigation.findNavController(MainActivity.this, R.id.fragment).navigate(R.id.mainFragment);
                            bottomCode = R.id.main;
                        }
                            break;

                    case R.id.record:

                        if (!(bottomCode == R.id.record)) {
                            Navigation.findNavController(MainActivity.this, R.id.fragment).navigate(R.id.recordFragment);
                            bottomCode = R.id.record;
                        }

                        break;
                    case R.id.tools:
                        break;
                    case R.id.me:
                        break;
                }


                return true;
            }
        });

    }

    //监听按下按键回调
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Toast.makeText(this, "你点击了返回键", Toast.LENGTH_SHORT).show();
        }
        return super.onKeyDown(keyCode, event);
    }

    //设置状态栏
    private void setStateBar() {
        appUtil.setStateBar(MainActivity.this);
    }


    //新增任务按钮
    public void newTask(View view) {
        //跳转新增任务
    }
}
