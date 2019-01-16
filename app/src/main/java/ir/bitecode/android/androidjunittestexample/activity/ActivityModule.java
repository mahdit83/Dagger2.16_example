package ir.bitecode.android.androidjunittestexample.activity;

import dagger.Module;
import dagger.Provides;
import ir.bitecode.android.androidjunittestexample.service.ActivityApiService;

@Module
public class ActivityModule {

    @Provides
    ActivityApiService providesApiManager(){
        return new ActivityApiService();
    }
}
