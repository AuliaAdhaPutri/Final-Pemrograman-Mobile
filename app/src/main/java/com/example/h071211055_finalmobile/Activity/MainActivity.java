package com.example.h071211055_finalmobile.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.h071211055_finalmobile.Fragment.FavoriteFragment;
import com.example.h071211055_finalmobile.Fragment.MovieFragment;
import com.example.h071211055_finalmobile.Fragment.TvFragment;
import com.example.h071211055_finalmobile.R;

public class MainActivity extends AppCompatActivity {

    private ImageButton moviesButton, tvButton, favoriteButton;
    private FrameLayout fragmentContainer;

    private MovieFragment movieFragment;
    private TvFragment tvFragment;
    private FavoriteFragment favoriteFragment;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentContainer = findViewById(R.id.fragment_container);
        moviesButton = findViewById(R.id.bottom_navigation_movies);
        tvButton = findViewById(R.id.bottom_navigation_tv);
        favoriteButton = findViewById(R.id.bottom_navigation_favorite);

        // Set homeButton sebagai tombol aktif pertama
        moviesButton.setSelected(true);

        movieFragment = new MovieFragment();
        tvFragment = new TvFragment();
        favoriteFragment = new FavoriteFragment();

        // Tampilkan HomeFragment pada container saat pertama kali dibuka
        replaceFragment(movieFragment);

        moviesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tampilkan HomeFragment pada container
                replaceFragment(movieFragment);
                moviesButton.setSelected(true);
                tvButton.setSelected(false);
                favoriteButton.setSelected(false);
            }
        });

        tvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tampilkan UploadFragment pada container
                replaceFragment(tvFragment);
                moviesButton.setSelected(false);
                tvButton.setSelected(true);
                favoriteButton.setSelected(false);
            }
        });

        favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tampilkan ProfileFragment pada container
                replaceFragment(favoriteFragment);
                moviesButton.setSelected(false);
                tvButton.setSelected(false);
                favoriteButton.setSelected(true);
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}

