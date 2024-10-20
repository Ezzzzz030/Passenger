package com.example.passenger.Fragments;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.passenger.Activity.CircolazioneRealTimeActivity;
import com.example.passenger.R;
import com.example.passenger.RecycleView.Adapter.StazioneRecyclerViewAdapter;
import com.example.passenger.RecycleView.Models.Stazione;

import java.util.ArrayList;

public class CircolazioneRealTimeStazioneFragment extends Fragment {

    private RecyclerView recyclerView_stazioni;
    private SearchView searchView;
    CircolazioneRealTimeActivity activity;
    public CircolazioneRealTimeStazioneFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_circolazione_real_time_stazione, container, false);

        recyclerView_stazioni = view.findViewById(R.id.recyclerView_stazioni);

        activity = (CircolazioneRealTimeActivity) this.getContext();

        if(activity != null)
        {
            fillRecyclerView(activity.getStazioni());
        }

        return view;
    }

    public void fillRecyclerView(ArrayList<Stazione> stazioni)
    {
        StazioneRecyclerViewAdapter adapter = new StazioneRecyclerViewAdapter(this.getContext());
        adapter.setStazione(activity.getStazioni());

        recyclerView_stazioni.setAdapter(adapter);
        recyclerView_stazioni.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }
}