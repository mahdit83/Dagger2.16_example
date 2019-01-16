package ir.bitecode.android.androidjunittestexample.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import ir.bitecode.android.androidjunittestexample.R;
import ir.bitecode.android.androidjunittestexample.managers.AuthorizationManager;
import ir.bitecode.android.androidjunittestexample.service.ActivityApiService;
import ir.bitecode.android.androidjunittestexample.service.FragmentApiService;


public class SecondFragment extends Fragment {


    public SecondFragment() {
        // Required empty public constructor
    }

    @Inject
    FragmentApiService fragmentApiService;

    @Inject
    AuthorizationManager authorizationManager;

    @Inject
    ActivityApiService activityApiService;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        activityApiService.getData();
        fragmentApiService.setAuthorizationManager(authorizationManager);
        TextView text = view.findViewById(R.id.text);
        String finalText ="";

        finalText = handleFragmentScopeApi(text,finalText);
        handleActivityScopeApi(text ,finalText);



        return view;
    }

    private void handleActivityScopeApi(TextView text, String finalText) {
        for (String value : activityApiService.getData()) {
            finalText = finalText + "\n " + value;
        }
        text.setText(finalText);
    }

    private String handleFragmentScopeApi(TextView text, String finalText) {
        for (String value : fragmentApiService.getData()) {
            finalText = finalText + "\n" + value;
        }
        text.setText(finalText);

        finalText = finalText + "\n ________________";
        text.setText(finalText);

        return finalText;
    }


    public static SecondFragment newInstance(Bundle bundle) {
        SecondFragment fragment = new SecondFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

}
