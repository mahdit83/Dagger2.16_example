package ir.bitecode.android.androidjunittestexample;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import ir.bitecode.android.androidjunittestexample.DI.DaggerApplicationComponent;
import ir.bitecode.android.androidjunittestexample.managers.AuthorizationManager;

public class TestApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Inject
    AuthorizationManager authorizationManager;

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerApplicationComponent
                .builder()
                .application(this)
                .build()
                .inject(this);

        Log.i("mahdi", "app onCreate: authorizationManager"+authorizationManager.getUserName());

    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
