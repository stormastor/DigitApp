package com.cinnamon.digitapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Christian on 14/6/2016.
 */
public class FragmentEntretenimiento extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(container != null){
            container.removeAllViews();
        }
        View unaView = inflater.inflate(R.layout.entretenimiento_fragment, container, false);
        AppCompatActivity activity = (AppCompatActivity) getActivity();

        Toolbar toolbar=(Toolbar) unaView.findViewById(R.id.toolbar_fragement_entretenimiento);
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle("Entretenimiento");
        return unaView;
    }
}
