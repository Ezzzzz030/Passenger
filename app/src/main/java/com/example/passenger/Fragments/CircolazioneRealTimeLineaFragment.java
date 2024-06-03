package com.example.passenger.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.passenger.R;

public class CircolazioneRealTimeLineaFragment extends Fragment {
    public CircolazioneRealTimeLineaFragment() {
        // Required empty public constructor
    }
    public static CircolazioneRealTimeLineaFragment newInstance(String param1, String param2) {
        CircolazioneRealTimeLineaFragment fragment = new CircolazioneRealTimeLineaFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_circolazione_real_time_linea, container, false);
    }
}