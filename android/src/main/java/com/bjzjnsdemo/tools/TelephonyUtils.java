package com.bjzjnsdemo.tools;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * 手机屏幕显示工具类
 */

public class TelephonyUtils {

    /**
     * getDeviceDisplayWidth:获取设备的宽度
     *
     * @param context
     * @return
     */
    public static int getDeviceDisplayWidth(Context context) {
        int width = 0;
        DisplayMetrics displayMetrics = getDeviceDisplayMetrics(context);
        if (null != displayMetrics) {
            width = displayMetrics.widthPixels;
        }
        return width;
    }

    /**
     * getDeviceDisplayHeight:获取设备的高度
     *
     * @param context
     * @return
     */
    public static int getDeviceDisplayHeight(Context context) {
        int height = 0;
        DisplayMetrics displayMetrics = getDeviceDisplayMetrics(context);
        if (null != displayMetrics) {
            height = displayMetrics.heightPixels;
        }
        return height;
    }


    /**
     * getDisplayMetrics:返回DisplayMetrics对象，以方便得到屏幕相关信息. <br/>
     *
     * @param context
     * @return
     */
    public static DisplayMetrics getDeviceDisplayMetrics(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        try {
            WindowManager manager = (WindowManager) context
                    .getSystemService(Context.WINDOW_SERVICE);
            Display display = manager.getDefaultDisplay();
            if (display != null) {
                display.getMetrics(dm);
            } else {
                dm.setToDefaults();
            }
        } catch (Exception e) {
        }
        return dm;
    }


    /**
     * 获取屏幕宽度
     */
    public static int getScreenWidth(Context activity) {
        if (activity == null) {
            return 0;
        }
        int screenWidth = activity.getResources().getDisplayMetrics().widthPixels;
        return screenWidth;
    }

    /**
     * 获取屏幕高度
     */
    public static int getScreenHeight(Context activity) {
        if (activity == null) {
            return 0;
        }
        int screenHeight = activity.getResources().getDisplayMetrics().heightPixels;
        return screenHeight;
    }

}
