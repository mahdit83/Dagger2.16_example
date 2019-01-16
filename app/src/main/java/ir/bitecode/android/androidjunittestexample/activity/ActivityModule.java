package ir.bitecode.android.androidjunittestexample.activity;

import dagger.Module;
import dagger.Provides;
import ir.bitecode.android.androidjunittestexample.managers.AuthorizationManager;
import ir.bitecode.android.androidjunittestexample.service.ActivityApiService;

@Module
public class ActivityModule {

    @Provides
    ActivityApiService providesApiManager(AuthorizationManager authorizationManager){
        return new ActivityApiService(authorizationManager);
    }
}
