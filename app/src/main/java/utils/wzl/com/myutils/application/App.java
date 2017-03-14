package utils.wzl.com.myutils.application;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.google.common.annotations.Beta;

/**
 * Created by Administrator on 2017/3/14.
 */

public class App extends Application {

    private static Context mContext;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //初始化 MultiDex
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
