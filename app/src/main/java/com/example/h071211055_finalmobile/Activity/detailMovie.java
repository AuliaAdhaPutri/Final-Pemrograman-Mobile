package com.example.h071211055_finalmobile.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.h071211055_finalmobile.DataResponse.Movie;
import com.example.h071211055_finalmobile.R;

public class detailMovie extends AppCompatActivity {

    private ImageView back, icon_fav;
    private ImageView Foto, Foto2;
    private TextView judulmovie;
    private TextView rate;
    private TextView Date;
    private TextView synopsis;
    private TextView desk_movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        back = findViewById(R.id.back);
        icon_fav = findViewById(R.id.icon_fav);
        Date = findViewById(R.id.date);
        Foto = findViewById(R.id.foto);
        Foto2 = findViewById(R.id.foto2);
        judulmovie = findViewById(R.id.judulmovie);
        rate = findViewById(R.id.ratemovie);
        synopsis = findViewById(R.id.sinop);
        desk_movie = findViewById(R.id.desk_movie);

        // Mengambil data film dari intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("datamovie")) {
            Movie movie = intent.getParcelableExtra("datamovie");
            if (movie != null) {
                judulmovie.setText(movie.getTitle());
                rate.setText(String.valueOf(movie.getVote_average()));
                Date.setText(movie.getRelease_date());
                desk_movie.setText(movie.getOverview());

                String posterPath = "https://image.tmdb.org/t/p/w500" + movie.getPoster_path();
                Glide.with(this)
                        .load(posterPath)
                        .into(Foto);
                Glide.with(this)
                        .load(posterPath)
                        .into(Foto2);
            } else {
                Toast.makeText(this, "Failed to get movie details", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "No movie data available", Toast.LENGTH_SHORT).show();
        }
    }

    public void back(View view) {
        finish(); // Kembali ke aktivitas sebelumnya
    }
}
