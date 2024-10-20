package com.example.passenger.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.passenger.Fragments.Adapter.CircolazioneRealTimeFragmentPagerAdapter;
import com.example.passenger.Fragments.CircolazioneRealTimeLineaFragment;
import com.example.passenger.Fragments.CircolazioneRealTimeStazioneFragment;
import com.example.passenger.Fragments.CircolazioneRealTimeTrenoFragment;
import com.example.passenger.R;
import com.example.passenger.RecycleView.Adapter.StazioneRecyclerViewAdapter;
import com.example.passenger.RecycleView.Models.Stazione;
import com.example.passenger.Utility.Utility;
import com.example.passenger.databinding.ActivityCircolazioneRealTimeBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class CircolazioneRealTimeActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {
    public CircolazioneRealTimeActivity() {

        super();

        // leggo le stazioni dal finto database
        stazioni = new ArrayList<>();
        stazioni.addAll(Utility.getFakeStazioni());
    }
    private final ArrayList<Stazione> stazioni;
    private ActivityCircolazioneRealTimeBinding binding;
    private SearchView searchView;

    public ArrayList<Stazione> getStazioni() {
        return stazioni;
    }

    public SearchView getSearchView() {
        return searchView;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_circolazione_real_time);
        changeColorStatusBar();

        binding = ActivityCircolazioneRealTimeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbarCircolazioneRealTime);

        binding.toolbarCircolazioneRealTime.setTitleTextColor(Color.parseColor("#FFCDD2"));

        binding.tabLayoutCircolazioneRealTime.setupWithViewPager(binding.viewPagerCircolazioneRealTime);

        CircolazioneRealTimeFragmentPagerAdapter adapter = new CircolazioneRealTimeFragmentPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new CircolazioneRealTimeStazioneFragment(), "Stazione");
        adapter.addFragment(new CircolazioneRealTimeTrenoFragment(), "Treno");
        adapter.addFragment(new CircolazioneRealTimeLineaFragment(), "Linea");
        binding.viewPagerCircolazioneRealTime.setAdapter(adapter);

        binding.tabLayoutCircolazioneRealTime.addOnTabSelectedListener(this);

        binding.tabLayoutCircolazioneRealTime.setSelectedTabIndicatorColor(Color.parseColor("#FFCDD2"));
        binding.tabLayoutCircolazioneRealTime.setSelectedTabIndicatorHeight((int) (5 * getResources().getDisplayMetrics().density));
        binding.tabLayoutCircolazioneRealTime.setTabTextColors(Color.parseColor("#FFCDD2"), Color.parseColor("#ffffff"));

        binding.toolbarCircolazioneRealTime.setTitleTextColor(Color.parseColor("#FFCDD2"));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // below line is to get our inflater
        MenuInflater inflater = getMenuInflater();
        // inside inflater we are inflating our menu file.
        inflater.inflate(R.menu.search_menu, menu);

        // below line is to get our menu item.
        MenuItem searchItem = menu.findItem(R.id.actionSearch);
        // getting search view of our item.
        searchView = (SearchView) searchItem.getActionView();

        // below line is to call set on query text listener method.
        if (searchView != null) {
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    filter(newText);
                    return false;
                }
            });
        }

        return true;

    }

    public void filter(String newText) {

        ArrayList<Stazione> unFilteredStazioniList = stazioni;
        ArrayList<Stazione> filteredStazioniList = new ArrayList<>();

        ViewPager viewPager = findViewById(R.id.viewPager_circolazioneRealTime);

        RecyclerView recyclerView = findViewById(R.id.recyclerView_stazioni);

        if(newText != null && !newText.isEmpty())
        {
            if(viewPager.getCurrentItem() == 0)
            {
                for (Stazione item : unFilteredStazioniList)
                {
                    if(item.getNome().toLowerCase().contains(newText.toLowerCase()))
                    {
                        filteredStazioniList.add(item);
                    }
                }
                StazioneRecyclerViewAdapter adapter = new StazioneRecyclerViewAdapter(this);
                adapter.setStazione(filteredStazioniList);

                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
            }
        }
        else
        {
            StazioneRecyclerViewAdapter adapter = new StazioneRecyclerViewAdapter(this);
            adapter.setStazione(stazioni);

            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
    }


    private void changeColorStatusBar()
    {
        Window window = this.getWindow();
        // cambio il colore della status bar
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimaryDark));

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}