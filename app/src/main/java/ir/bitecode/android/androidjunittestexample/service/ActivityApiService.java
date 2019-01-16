package ir.bitecode.android.androidjunittestexample.service;

import java.util.ArrayList;
import java.util.List;

import ir.bitecode.android.androidjunittestexample.managers.AuthorizationManager;

public class ActivityApiService {

    AuthorizationManager authorizationManager;

    public List<String> getData(){

        List<String> result = new ArrayList<>();
        if(authorizationManager.isAuthorized()){
            for (int i = 1; i < 10; i++) {
                result.add(authorizationManager.getUserName()+"_"+i);

            }
        }

        return result;
    }

    public ActivityApiService(AuthorizationManager authorizationManager) {
        this.authorizationManager = authorizationManager;
    }

}
