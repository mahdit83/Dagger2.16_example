package ir.bitecode.android.androidjunittestexample.DI;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;
import ir.bitecode.android.androidjunittestexample.TestApplication;

@Singleton
@Component(modules = {
        /* Use AndroidInjectionModule.class if you're not using support library */
        AndroidSupportInjectionModule.class,
        AppModule.class,
        BuildersModule.class})
public interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(TestApplication application);
        ApplicationComponent build();
    }
    void inject(TestApplication app);
}
