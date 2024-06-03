package com.example.passenger.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.passenger.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PurchesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PurchesFragment extends Fragment {
    public PurchesFragment() {

    }
    public static PurchesFragment newInstance(String param1, String param2) {
        PurchesFragment fragment = new PurchesFragment();
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
        return inflater.inflate(R.layout.fragment_purches, container, false);
    }
}