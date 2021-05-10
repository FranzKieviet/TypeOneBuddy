package com.example.parsetagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.parsetagram.fragment.BloodSugarFragment;
import com.example.parsetagram.fragment.ComposeFragment;
import com.example.parsetagram.fragment.PostsFragment;
import com.example.parsetagram.fragment.RatiosFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    public static final String TAG = "MainActivity";
    private BottomNavigationView bottomNavigationView;
    final FragmentManager fragmentManager = getSupportFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = findViewById(R.id.bottomNavigation);


    bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.action_home:
                        fragment = new PostsFragment();
                        break;
                    case R.id.action_compose:
                        fragment = new ComposeFragment();
                        break;
                    case R.id.action_bloodsugar:
                        fragment = new BloodSugarFragment();
                        break;
                    case R.id.action_calculate:
                        fragment = new RatiosFragment();
                        break;
                    case R.id.action_profile:

                    default:
                        fragment = new PostsFragment();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
        }
    });
        // Set default selection
        bottomNavigationView.setSelectedItemId(R.id.action_home);
    }


}