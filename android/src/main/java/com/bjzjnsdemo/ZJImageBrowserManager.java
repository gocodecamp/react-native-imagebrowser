package com.bjzjnsdemo;

import android.support.annotation.Nullable;
import android.widget.Toast;

import com.bjzjnsdemo.models.ImageItem;
import com.bjzjnsdemo.tools.Navigator;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import java.util.ArrayList;

/**
 * Created by blade on 17/01/2017.
 */

public class ZJImageBrowserManager extends ReactContextBaseJavaModule {

    public ZJImageBrowserManager(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    /**
     * @return the name of this module. This will be the name used to {@code require()} this module
     * from javascript.
     */
    @Override
    public String getName() {
        return "ZJImageBrowserManager";
    }

    @ReactMethod
    public void showImage(ReadableArray images) {
        if (images != null && images.size() > 0) {
            ArrayList<ImageItem> allimages = new ArrayList<>();
            int size = images.size();
            for (int i = 0; i < size; i++) {
                ImageItem item = new ImageItem();
                item.path = images.getString(i);
                allimages.add(item);
            }
            Navigator.startImageViewActivity(getCurrentActivity(),allimages);
        }
    }

    @ReactMethod
    public void show() {
//        callback.invoke("hahaha successs");

        WritableMap map = Arguments.createMap();
        map.putString("awesomeRating","hahahhaha");
        sendEvent(getReactApplicationContext(),"Event",map);
        Toast.makeText(getReactApplicationContext(),"DisplayImage",Toast.LENGTH_LONG).show();
    }


    private void sendEvent(ReactContext reactContext,
                           String eventName,
                           @Nullable WritableMap params) {
        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);
    }



}
