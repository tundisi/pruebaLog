package com.nextdots.retargetly.retargetly;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by luistundisi on 8/8/17.
 */

public class Retargetly {

    private Activity activeActivity;
    Application application;

    public void inicialize(Application application){
        this.application = application;
        setupActivityListener();
    }

    private void setupActivityListener() {
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            }
            @Override
            public void onActivityStarted(Activity activity) {
                Log.d("--LIBRARY Start",""+activity.getLocalClassName());
            }
            @Override
            public void onActivityResumed(Activity activity) {
                Log.d("--LIBRARY Resumed",""+activity.getLocalClassName());
                activeActivity = activity;
            }
            @Override
            public void onActivityPaused(Activity activity) {
                activeActivity = null;
            }
            @Override
            public void onActivityStopped(Activity activity) {
            }
            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            }
            @Override
            public void onActivityDestroyed(Activity activity) {
            }
        });
    }

    public Activity getActiveActivity(){
        return activeActivity;
    }

}
