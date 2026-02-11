package com.chernegasergiy.battery;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.chernegasergiy.battery.fragment.StatusFragment;
import com.chernegasergiy.battery.fragment.AboutFragment;

public class MainActivity extends FragmentActivity {
    private StatusFragment statusFragment;
    private AboutFragment aboutFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusFragment = new StatusFragment();
        aboutFragment = new AboutFragment();

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.nav_status) {
                loadFragment(statusFragment);
                return true;
            } else if (itemId == R.id.nav_about) {
                loadFragment(aboutFragment);
                return true;
            }
            return false;
        });

        if (savedInstanceState == null) {
            loadFragment(statusFragment);
        }
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
