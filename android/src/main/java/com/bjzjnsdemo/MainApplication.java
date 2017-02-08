package com.bjzjnsdemo;

import android.app.Application;

import com.bjzjnsdemo.packages.NativePackage;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;

import java.util.Arrays;
import java.util.List;

public class MainApplication extends Application implements ReactApplication {


    private static MainApplication mInstance = null;

    private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {

        @Override
        protected boolean getUseDeveloperSupport() {
            return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {
            return Arrays.<ReactPackage>asList(
                    new MainReactPackage(),
                    new NativePackage()
            );
        }
    };

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, /* native exopackage */ false);
        Fresco.initialize(this);
        mInstance = this;
    }

    public static MainApplication getInstance() {
        return mInstance;
    }

    public ReactContext getReactContext() {
        return mReactNativeHost.getReactInstanceManager().getCurrentReactContext();
    }

}
