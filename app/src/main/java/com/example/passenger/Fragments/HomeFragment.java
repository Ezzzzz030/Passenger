package com.example.passenger.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.passenger.Activity.CircolazioneRealTimeActivity;
import com.example.passenger.Activity.MainActivity;
import com.example.passenger.R;
import com.example.passenger.RecycleView.Adapter.TrenoPreferitoRecyclerViewAdapter;
import com.example.passenger.Utility.Utility;

public class HomeFragment extends Fragment {
    CardView cardView_circolazioneRealTime;
    RecyclerView recyclerView_treniPreferiti;
    public HomeFragment() {
        // Required empty public constructor
    }
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Toolbar toolbarHome = view.findViewById(R.id.toolbar_home);

        toolbarHome.setTitleTextColor(Color.parseColor("#FFCDD2"));

        ((MainActivity)getActivity()).setSupportActionBar(toolbarHome);


        cardView_circolazioneRealTime = view.findViewById(R.id.cardView_circolazioneRealTime);
        cardView_circolazioneRealTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CircolazioneRealTimeActivity.class);
                startActivity(intent);
            }
        });

        recyclerView_treniPreferiti = view.findViewById(R.id.recyclerView_treniPreferiti);
        TrenoPreferitoRecyclerViewAdapter adapter = new TrenoPreferitoRecyclerViewAdapter(this.getContext());
        adapter.setTreniPreferiti(Utility.getFakeTreni());

        recyclerView_treniPreferiti.setAdapter(adapter);
        recyclerView_treniPreferiti.setLayoutManager(new GridLayoutManager(this.getContext(), 2, GridLayoutManager.HORIZONTAL, true));
        return view;
    }
}