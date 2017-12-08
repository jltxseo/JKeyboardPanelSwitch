package cn.dreamtobe.kpswitch.demo.activity;

import android.app.Application;

/**
 * @author jltxseo
 *         Created by junlintianxia on 2017/12/08.
 * @version V1.0
 * @Description
 */

public class XqApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(new XqActivityLifecycleCallbacks());
    }
}
