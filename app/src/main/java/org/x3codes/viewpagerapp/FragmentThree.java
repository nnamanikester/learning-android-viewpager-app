package org.x3codes.viewpagerapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FragmentThree extends ViewPagerFragment {
    private final String title;

    public FragmentThree(String title) {
        super(title);
        // Required empty public constructor
        this.title = title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_three, container, false);
    }

    @Override
    public String getTitle() {
        return title;
    }
}