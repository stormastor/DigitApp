package com.cinnamon.digitapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Christian on 12/6/2016.
 */
public class FragmentMasLeido extends Fragment {


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(container != null){
            container.removeAllViews();
        }

        View unaView = inflater.inflate(R.layout.mas_leidas_fragment, container, false);
        AppCompatActivity activity = (AppCompatActivity) getActivity();

        Toolbar toolbar=(Toolbar) unaView.findViewById(R.id.toolbarFragment);
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle("Mas leidas");
        return unaView;
    }

}
