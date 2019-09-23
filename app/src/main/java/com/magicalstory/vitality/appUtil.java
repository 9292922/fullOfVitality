package com.magicalstory.vitality;

import android.app.Activity;

/*这是元气满满专用工具类，用于快速操作
* 已实现的方法:
* 1.设置状态栏
* ...
* */
public class appUtil {
   public static void  setStateBar(Activity activity) {
        StatusBarUtil.StatusBarLightMode(activity);
        StatusBarUtil.setColor(activity, activity.getResources().getColor(R.color.splashBackgroundColor));
    }
}
