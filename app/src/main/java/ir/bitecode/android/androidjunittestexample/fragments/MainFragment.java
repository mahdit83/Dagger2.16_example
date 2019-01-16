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
import ir.bitecode.android.androidjunittestexample.service.FragmentApiService;


public class MainFragment extends Fragment {


    @Inject
    FragmentApiService fragmentApiService;

    @Inject
    AuthorizationManager authorizationManager;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        fragmentApiService.setAuthorizationManager(authorizationManager);
        TextView text = view.findViewById(R.id.text);
        String finalText = "";
        for (String value : fragmentApiService.getData()) {
            finalText = finalText + "\n" + value;
        }
        text.setText(finalText);


        return view;
    }


    public static MainFragment newInstance(Bundle bundle) {
        MainFragment fragment = new MainFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

}
