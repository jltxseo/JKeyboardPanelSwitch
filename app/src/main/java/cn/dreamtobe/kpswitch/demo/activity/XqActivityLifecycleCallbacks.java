package cn.dreamtobe.kpswitch.demo.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;

import com.android.debug.hv.ViewServerHelper;

/**
 * @author jltxseo
 *         Created by junlintianxia on 2017/12/08.
 * @version V1.0
 * @Description
 */

@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
public class XqActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks{
    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        ViewServerHelper.addWindow(activity);
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {
        ViewServerHelper.setFocusedWindow(activity);
    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        ViewServerHelper.removeWindow(activity);
    }
}
