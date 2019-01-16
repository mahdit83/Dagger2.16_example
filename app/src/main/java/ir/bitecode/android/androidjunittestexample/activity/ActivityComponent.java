package ir.bitecode.android.androidjunittestexample.activity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity>{}
}
