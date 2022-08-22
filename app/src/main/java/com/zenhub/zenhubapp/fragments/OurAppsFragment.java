package com.zenhub.zenhubapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zenhub.zenhubapp.R;

import java.util.List;

public class OurAppsFragment extends Fragment {

    List<String> ourAppsTitles;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_our_apps, container, false);
    }
}