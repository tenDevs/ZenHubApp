package com.zenhub.zenhubapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zenhub.zenhubapp.R;
import com.zenhub.zenhubapp.adapters.HomeItemsAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    List<String> listTitles;
    List<Integer> listIcons;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listTitles = new ArrayList<>();
        listIcons = new ArrayList<>();

        listTitles.add(getString(R.string.about_zensar));
        listTitles.add(getString(R.string.work_shop));
        listTitles.add(getString(R.string.faqs));
        listTitles.add(getString(R.string.contact_us));

        listIcons.add(R.drawable.ic_baseline_info_24);
        listIcons.add(R.drawable.ic_baseline_store_24);
        listIcons.add(R.drawable.ic_baseline_help_24);
        listIcons.add(R.drawable.ic_baseline_phone_enabled_24);

        recyclerView = view.findViewById(R.id.HomeRecyclerView);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        HomeItemsAdapter homeItemsAdapter = new HomeItemsAdapter(getContext(), listTitles, listIcons);
        recyclerView.setAdapter(homeItemsAdapter);
        homeItemsAdapter.notifyDataSetChanged();
    }
}