package ir.bitecode.android.androidjunittestexample.service;

import java.util.ArrayList;
import java.util.List;

import ir.bitecode.android.androidjunittestexample.managers.AuthorizationManager;

public class ActivityApiService {

    AuthorizationManager authorizationManager;
    int serviceNumber;

    public ActivityApiService(AuthorizationManager authorizationManager, int serviceNumber) {
        this.authorizationManager = authorizationManager;
        this.serviceNumber = serviceNumber;
    }


    public List<String> getData() {

        List<String> result = new ArrayList<>();
        if (authorizationManager.isAuthorized()) {
            for (int i = 1; i < serviceNumber; i++) {
                result.add(authorizationManager.getUserName() + "_activity_api_" + i);

            }
        }

        return result;
    }

}
