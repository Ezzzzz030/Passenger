package com.example.passenger;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.passenger.Fragments.Adapter.CircolazioneRealTimeFragmentPagerAdapter;
import com.example.passenger.Fragments.CircolazioneRealTimeLineaFragment;
import com.example.passenger.Fragments.CircolazioneRealTimeStazioneFragment;
import com.example.passenger.Fragments.CircolazioneRealTimeTrenoFragment;
import com.example.passenger.RecycleView.Adapter.StazioneRecyclerViewAdapter;
import com.example.passenger.RecycleView.Models.Stazione;
import com.example.passenger.Utility.Utility;
import com.example.passenger.databinding.ActivityCircolazioneRealTimeBinding;
import com.example.passenger.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class CircolazioneRealTimeActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {
    ActivityCircolazioneRealTimeBinding binding;

    public ArrayList<Stazione> getStazioni() {
        return stazioni;
    }

    ArrayList<Stazione> stazioni;

    public SearchView getSearchView() {
        return searchView;
    }

    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_circolazione_real_time);
        changeColorStatusBar();

        stazioni = new ArrayList<Stazione>();
        stazioni.addAll(Utility.getFakeStazioni());

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
                    // inside on query text change method we are
                    // calling a method to filter our recycler view.
                    filter(newText);
                    return false;
                }
            });
        }

        return true;

    }

    public void filter(String newText) {

        ArrayList<Stazione> unFilteredStazioniList = stazioni;
        ArrayList<Stazione> filteredStazioniList = new ArrayList<Stazione>();

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
        // finally change the color
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