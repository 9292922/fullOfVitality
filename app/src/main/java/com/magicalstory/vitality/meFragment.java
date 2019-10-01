package com.magicalstory.vitality;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


public class meFragment extends Fragment {

    View view;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (ViewHoder.meView == null) {
            view = inflater.inflate(R.layout.fragment_home, container, false);

            ViewHoder.meView = view;
        } else {
            view = ViewHoder.meView;
        }

        return view;
    }


}
