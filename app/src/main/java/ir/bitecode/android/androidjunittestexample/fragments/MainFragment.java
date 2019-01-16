package ir.bitecode.android.androidjunittestexample.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import ir.bitecode.android.androidjunittestexample.R;
import ir.bitecode.android.androidjunittestexample.managers.AuthorizationManager;
import ir.bitecode.android.androidjunittestexample.service.FragmentApiService;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {


    @Inject
    FragmentApiService fragmentApiService;

    @Inject
    AuthorizationManager authorizationManager;

    public MainFragment() {
        // Required empty public constructor
    }


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
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        fragmentApiService.setAuthorizationManager(authorizationManager);
        TextView text = view.findViewById(R.id.text);
        String finalText ="";
        for (String value : fragmentApiService.getData()) {
            finalText = finalText +"\n"+ value;
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
