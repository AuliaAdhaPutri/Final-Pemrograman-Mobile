package com.example.h071211055_finalmobile.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.h071211055_finalmobile.Activity.detailMovie;
import com.example.h071211055_finalmobile.Activity.detailTv;
import com.example.h071211055_finalmobile.DataResponse.Movie;
import com.example.h071211055_finalmobile.DataResponse.Tv;
import com.example.h071211055_finalmobile.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterTv extends RecyclerView.Adapter<AdapterTv.ViewHolder> {
    Context context;
    private List<Tv> dataFilm;

    public AdapterTv(Context context, List<Tv> dataFilm) {
        this.context = context;
        this.dataFilm = dataFilm;
    }

    @NonNull
    @Override
    public AdapterTv.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemrv2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tv tv = dataFilm.get(position);
//        Glide.with(holder.itemView.getContext()) .load(movie.getPoster_path()).into(holder.picture);
        holder.Judul.setText(tv.getOriginal_name());
//        holder.year.setText(movie.getRelease_date());


        String releaseDate = tv.getFirst_air_date();
        if (releaseDate != null && !releaseDate.isEmpty()){
            String year = releaseDate.substring(0,4);
            holder.Year.setText(year);
        }else{
            holder.Year.setText("");
        }

        String poster = "https://image.tmdb.org/t/p/w500" + tv.getPoster_path();
        Glide.with(holder.Picture.getContext())
                .load(poster)
                .into(holder.Picture);
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(), detailTv.class);
            intent.putExtra("datatv", tv);
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return dataFilm.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView Picture;
        TextView Judul,Year;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Picture = itemView.findViewById(R.id.iv_pictv);
            Judul = itemView.findViewById(R.id.tv_judultv);
            Year = itemView.findViewById(R.id.tv_yeartv);
        }
    }
}