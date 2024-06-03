package com.example.passenger.Fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.passenger.R;
import com.example.passenger.RecycleView.Adapter.StazioneRecyclerViewAdapter;
import com.example.passenger.RecycleView.Models.Stazione;
import com.example.passenger.Utility.Utility;
import com.example.passenger.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class CircolazioneRealTimeTrenoFragment extends Fragment {

    public CircolazioneRealTimeTrenoFragment() {
    }

    private RecyclerView recyclerView_stazioni;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_circolazione_real_time_treno, container, false);
        return view;
    }
}