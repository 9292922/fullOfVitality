package com.magicalstory.vitality;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashAcitvity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        hideBottomUIMenu();//隐藏底部虚拟键
        setStateBar();//设置状态栏
        setTimeCounter();
    }

    //延迟一定时间载入MainActivity
    private void setTimeCounter() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashAcitvity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },getResources().getInteger(R.integer.splash_time));
    }


    @Override
    protected void onResume() {
        super.onResume();
        hideBottomUIMenu();//关闭底部虚拟键
    }

    private void setStateBar() {
      appUtil.setStateBar(SplashAcitvity.this);
    }

    protected void hideBottomUIMenu() {
        //隐藏虚拟按键，并且全屏
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            Window _window = getWindow();
            WindowManager.LayoutParams params = _window.getAttributes();
            params.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE;
            _window.setAttributes(params);
        }
    }

}
