package ir.bitecode.android.androidjunittestexample.DI;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.IntoMap;
import ir.bitecode.android.androidjunittestexample.activity.ActivityComponent;
import ir.bitecode.android.androidjunittestexample.activity.ActivityModule;
import ir.bitecode.android.androidjunittestexample.activity.MainActivity;
import ir.bitecode.android.androidjunittestexample.fragments.FragmentModule;
import ir.bitecode.android.androidjunittestexample.fragments.MainFragment;
import ir.bitecode.android.androidjunittestexample.fragments.SecondFragment;

@Module
public abstract class BuildersModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMainActivity(ActivityComponent
                                                                                      .Builder
                                                                                      builder);

    @ContributesAndroidInjector(modules = FragmentModule.class)
    abstract MainFragment bindMainFragment();

    @ContributesAndroidInjector(modules = {FragmentModule.class, ActivityModule.class})
    abstract SecondFragment bindSecondFragment();
}
