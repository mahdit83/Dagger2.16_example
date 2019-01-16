package ir.bitecode.android.androidjunittestexample.DI;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import ir.bitecode.android.androidjunittestexample.activity.ActivityModule;
import ir.bitecode.android.androidjunittestexample.activity.MainActivity;
import ir.bitecode.android.androidjunittestexample.fragments.FragmentModule;
import ir.bitecode.android.androidjunittestexample.fragments.MainFragment;
import ir.bitecode.android.androidjunittestexample.fragments.SecondFragment;

@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector(modules = ActivityModule.class)
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = FragmentModule.class)
    // or gain access to lobby activity dependencies from fragment via
    // @ContributesAndroidInjector(modules = {LobbyFragmentModule.class, LobbyActivityModule.class})
    abstract MainFragment bindMainFragment();

    @ContributesAndroidInjector(modules = {FragmentModule.class , ActivityModule.class})
    // or gain access to lobby activity dependencies from fragment via
    // @ContributesAndroidInjector(modules = {LobbyFragmentModule.class, LobbyActivityModule.class})
    abstract SecondFragment bindSecondFragment();
}
