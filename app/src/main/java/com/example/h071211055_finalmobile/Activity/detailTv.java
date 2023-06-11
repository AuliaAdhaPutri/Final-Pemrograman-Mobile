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
import com.example.h071211055_finalmobile.DataResponse.Tv;
import com.example.h071211055_finalmobile.R;

public class detailTv extends AppCompatActivity {

    private ImageView back, icon_fav;
    private ImageView Foto, Foto2;
    private TextView judultv;
    private TextView rate;
    private TextView Date;
    private TextView synopsis;
    private TextView desk_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv);

        back = findViewById(R.id.back);
        icon_fav = findViewById(R.id.icon_fav);
        Date = findViewById(R.id.datetv);
        Foto = findViewById(R.id.foto);
        Foto2 = findViewById(R.id.foto2);
        judultv = findViewById(R.id.judultv);
        rate = findViewById(R.id.ratetv);
        synopsis = findViewById(R.id.sinoptv);
        desk_tv = findViewById(R.id.desk_tv);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("datatv")) {
            Tv tv = intent.getParcelableExtra("datatv");
            if (tv != null) {
                judultv.setText(tv.getOriginal_name());
                rate.setText(String.valueOf(tv.getVote_average()));
                Date.setText(tv.getFirst_air_date());
                desk_tv.setText(tv.getOverview());

                String posterPath = "https://image.tmdb.org/t/p/w500" + tv.getPoster_path();
                Glide.with(this)
                        .load(posterPath)
                        .into(Foto);
                Glide.with(this)
                        .load(posterPath)
                        .into(Foto2);
            } else {
                Toast.makeText(this, "Failed to get tv details", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "No tv data available", Toast.LENGTH_SHORT).show();
        }
    }

    public void back(View view) {
        finish();
    }
}
