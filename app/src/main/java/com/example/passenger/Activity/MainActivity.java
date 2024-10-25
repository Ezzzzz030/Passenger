package com.example.passenger.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.view.Window;
import android.view.WindowManager;

import com.example.passenger.Fragments.HomeFragment;
import com.example.passenger.Fragments.PurchesFragment;
import com.example.passenger.R;
import com.example.passenger.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private DrawerLayout drawerLayout_home;
    BottomNavigationView bottomNavigationView;
    NavigationView navigationView;
    Toolbar toolbar;
    private AppBarConfiguration appBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        toolbar = findViewById(R.id.toolbar);
        drawerLayout_home = findViewById(R.id.drawerLayout_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        navigationView = findViewById(R.id.navigationView_main);

        setSupportActionBar(toolbar);

        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView_main);
        NavController navController = navHostFragment.getNavController();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout_home, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout_home.addDrawerListener(toggle);
        toggle.syncState();
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_purches)
                .setOpenableLayout(drawerLayout_home)
                .build();

        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        NavigationUI.setupWithNavController(navigationView, navController);

        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout_home);

//        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//        startActivity(intent);
    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = ((NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentContainerView_main)).getNavController();
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

}

