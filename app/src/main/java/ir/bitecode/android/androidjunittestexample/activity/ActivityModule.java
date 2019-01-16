package ir.bitecode.android.androidjunittestexample.activity;

import java.util.Random;

import dagger.Module;
import dagger.Provides;
import ir.bitecode.android.androidjunittestexample.managers.AuthorizationManager;
import ir.bitecode.android.androidjunittestexample.service.ActivityApiService;

@Module
public class ActivityModule {

    @Provides
    ActivityApiService providesApiManager(AuthorizationManager authorizationManager){
        Random random = new Random();
        return new ActivityApiService(authorizationManager ,random.nextInt(10-1)+1);
    }
}
