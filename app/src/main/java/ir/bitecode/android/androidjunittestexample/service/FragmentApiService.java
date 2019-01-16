package ir.bitecode.android.androidjunittestexample.service;

import java.util.ArrayList;
import java.util.List;

import ir.bitecode.android.androidjunittestexample.managers.AuthorizationManager;

public class FragmentApiService {

    private AuthorizationManager authorizationManager;
    private int serviceNumber;

    public FragmentApiService(int serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public List<String> getData() {

        List<String> result = new ArrayList<>();
        for (int i = 1; i < serviceNumber; i++) {
            if (authorizationManager != null) {
                result.add(authorizationManager.getUserName() + "_" + i);

            } else {
                result.add("null_authorizationManager_" + i);

            }

        }

        return result;
    }

    public void setAuthorizationManager(AuthorizationManager authorizationManager) {
        this.authorizationManager = authorizationManager;
    }

}
