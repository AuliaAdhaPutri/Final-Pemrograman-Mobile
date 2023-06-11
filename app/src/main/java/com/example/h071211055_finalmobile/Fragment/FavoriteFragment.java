package com.example.h071211055_finalmobile.Fragment;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.h071211055_finalmobile.Adapter.AdapterFavorite;
import com.example.h071211055_finalmobile.DataResponse.Movie;
import com.example.h071211055_finalmobile.Database.DatabaseHelper;
import com.example.h071211055_finalmobile.R;

import java.util.List;

public class FavoriteFragment extends Fragment {
    private RecyclerView recyclerView;
    private ProgressBar pb_favorite;
    private TextView disconnect;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        recyclerView = view.findViewById(R.id.rv_fav);
        pb_favorite = view.findViewById(R.id.pb_fav);
        disconnect = view.findViewById(R.id.disconnect_fav);


        return view;
    }


}

