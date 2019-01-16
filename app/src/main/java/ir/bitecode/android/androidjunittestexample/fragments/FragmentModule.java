package ir.bitecode.android.androidjunittestexample.fragments;

import java.util.Random;

import dagger.Module;
import dagger.Provides;
import ir.bitecode.android.androidjunittestexample.service.FragmentApiService;

@Module
public class FragmentModule {

    @Provides
    FragmentApiService providesFragmentApiService(){
        Random random = new Random();
        //return random number from 1 to 10
        return new FragmentApiService(random.nextInt(10 -1)+1);
    }
}
