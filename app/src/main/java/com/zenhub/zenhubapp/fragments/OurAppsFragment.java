package com.zenhub.zenhubapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zenhub.zenhubapp.R;
import com.zenhub.zenhubapp.adapters.OurAppsAdapter;

import java.util.ArrayList;
import java.util.List;

public class OurAppsFragment extends Fragment {

    List<String> ourAppsTitles;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_our_apps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ourAppsTitles = new ArrayList<>();
        recyclerView = view.findViewById(R.id.ourAppsRecycleView);

        ourAppsTitles.add("ZenLounge+");
        ourAppsTitles.add("ZenFulcrum");
        ourAppsTitles.add("ZenDeavor");
        ourAppsTitles.add("ZenApp");
        ourAppsTitles.add("ZenApp");
        ourAppsTitles.add("ZenApp");

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        OurAppsAdapter ourAppsAdapter = new OurAppsAdapter(getContext(), ourAppsTitles);
        recyclerView.setAdapter(ourAppsAdapter);
        ourAppsAdapter.notifyDataSetChanged();
    }
}