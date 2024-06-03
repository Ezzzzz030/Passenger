package com.example.passenger.Fragments;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.passenger.CircolazioneRealTimeActivity;
import com.example.passenger.R;
import com.example.passenger.RecycleView.Adapter.StazioneRecyclerViewAdapter;
import com.example.passenger.RecycleView.Models.Stazione;
import com.example.passenger.Utility.Utility;

import java.util.ArrayList;

public class CircolazioneRealTimeStazioneFragment extends Fragment {
    private RecyclerView recyclerView_stazioni;
    private SearchView searchView;
    CircolazioneRealTimeActivity activity;
    public CircolazioneRealTimeStazioneFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_circolazione_real_time_stazione, container, false);

        recyclerView_stazioni = view.findViewById(R.id.recyclerView_stazioni);

        activity = (CircolazioneRealTimeActivity) this.getContext();

        StazioneRecyclerViewAdapter adapter = new StazioneRecyclerViewAdapter(this.getContext());
        adapter.setStazione(activity.getStazioni());

        recyclerView_stazioni.setAdapter(adapter);
        recyclerView_stazioni.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return view;
    }

}