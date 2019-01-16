package ir.bitecode.android.androidjunittestexample.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import ir.bitecode.android.androidjunittestexample.R;
import ir.bitecode.android.androidjunittestexample.fragments.MainFragment;
import ir.bitecode.android.androidjunittestexample.fragments.SecondFragment;
import ir.bitecode.android.androidjunittestexample.managers.AuthorizationManager;
import ir.bitecode.android.androidjunittestexample.service.ActivityApiService;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    private final String BITECODE = "mahdi";
    private Button button1, button2;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Inject
    AuthorizationManager authorizationManager;

    @Inject
    ActivityApiService activityApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeUi();

        Log.i(BITECODE, "api:getData "+ activityApiService.getData().size());
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    private void initializeUi() {
        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authorizationManager.setUserName("User1:");
                authorizationManager.setAuthorized(true);
                addFragment(MainFragment.newInstance(new Bundle()));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authorizationManager.setUserName("User2:");
                authorizationManager.setAuthorized(true);
                addFragment(SecondFragment.newInstance(new Bundle()));
            }
        });
    }



    private void addFragment(Fragment fragment) {
        Log.i(BITECODE, "addFragment: "+authorizationManager.getUserName());


        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }
}
