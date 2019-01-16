package ir.bitecode.android.androidjunittestexample.DI;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ir.bitecode.android.androidjunittestexample.TestApplication;
import ir.bitecode.android.androidjunittestexample.activity.ActivityComponent;
import ir.bitecode.android.androidjunittestexample.managers.AuthorizationManager;

@Module(subcomponents = {ActivityComponent.class,})
public class AppModule {

    @Provides
    Context provideContext(TestApplication application) {
        return application.getApplicationContext();
    }

    @Singleton
    @Provides
    AuthorizationManager provideAuthorizationManager() {
        return new AuthorizationManager();
    }
}
