package com.example.eshop;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Administrator on 2019/6/17/017.
 */

public class EShopApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        if (LeakCanary.isInAnalyzerProcess(this)) {

            // 这个是用于分析内存的线程，我们不能再这里面初始化我们项目
            return;
        }
        LeakCanary.install(this);

        // 正常的app初始化

    }
}

