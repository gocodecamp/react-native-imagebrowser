package com.bjzjnsdemo.modules;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.bjzjnsdemo.tools.Navigator;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

/**
 * Created by blade on 19/01/2017.
 */

public class RichEditorModule extends ReactContextBaseJavaModule {

    Promise mPromise;
    private static final int HTML_REQUEST = 467081;


    private ActivityEventListener mActivityEventListener = new ActivityEventListener() {
        @Override
        public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
            if (requestCode == HTML_REQUEST) {
                if (resultCode == Activity.RESULT_OK) {
                    Toast.makeText(getReactApplicationContext(),data.getStringExtra("HTML"),Toast.LENGTH_SHORT).show();
                    WritableMap map =  Arguments.createMap();
                    map.putString("html",data.getStringExtra("HTML"));
                    mPromise.resolve(map);
                } else {
                    Toast.makeText(getReactApplicationContext(),"Activity.Cancel",Toast.LENGTH_SHORT).show();
                    WritableMap map =  Arguments.createMap();
                    map.putString("html","error");
                    mPromise.resolve(map);
                }
            }
        }

        @Override
        public void onNewIntent(Intent intent) {

        }
    };

    public RichEditorModule(ReactApplicationContext reactContext) {
        super(reactContext);
        reactContext.addActivityEventListener(mActivityEventListener);
    }

    /**
     * @return the name of this module. This will be the name used to {@code require()} this module
     * from javascript.
     */
    @Override
    public String getName() {
        return "RichEditor";
    }

    @ReactMethod
    public void startRichEditor(Promise promise) {
        mPromise = promise;
        Navigator.startRichEditorActivityForResult(getCurrentActivity(),HTML_REQUEST);
    }

    private void sendEvent(ReactContext reactContext,
                           String eventName,
                           @Nullable WritableMap params) {
        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);
    }


}
