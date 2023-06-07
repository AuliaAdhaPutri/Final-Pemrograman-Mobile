package com.example.h071211055_finalmobile.Fragment;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.h071211055_finalmobile.Adapter.AdapterMovie;
import com.example.h071211055_finalmobile.Adapter.AdapterTv;
import com.example.h071211055_finalmobile.Api.ApiConfig;
import com.example.h071211055_finalmobile.DataResponse.DataMovie;
import com.example.h071211055_finalmobile.DataResponse.DataTv;
import com.example.h071211055_finalmobile.DataResponse.Movie;
import com.example.h071211055_finalmobile.DataResponse.Tv;
import com.example.h071211055_finalmobile.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieFragment extends Fragment {
    private ProgressBar progressBar;
    private TextView disconnect;
    private RecyclerView recyclerView;
    private Handler handler;

    public static ArrayList<Movie> dataFilm1 = new ArrayList<>();

    public MovieFragment() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        disconnect = view.findViewById(R.id.disconnect_movie);
        recyclerView = view.findViewById(R.id.rv_movie);
        progressBar = view.findViewById(R.id.pb_movie);

        handler = new Handler();

        loading();
        getDataApi();
    }

    private void getDataApi() {
        if (isNetworkAvailable()) {
            progressBar.setVisibility(View.VISIBLE);
            disconnect.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);

            Call<DataMovie> client = ApiConfig.getApiService().getDataMovie(ApiConfig.getApiKey());
            client.enqueue(new Callback<DataMovie>() {
                @Override
                public void onResponse(Call<DataMovie> call, Response<DataMovie> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            List<Movie> movie = response.body().getDataMovie();
                            AdapterMovie adapter = new AdapterMovie(getActivity(), movie);
                            recyclerView.setAdapter(adapter);

                            // Mengatur layout manager dengan GridLayoutManager
                            GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
                            recyclerView.setLayoutManager(layoutManager);
                        } else {
                            Log.e("MovieFragment", "onResponse: Response body is null");
                        }
                    } else {
                        Log.e("MovieFragment", "onResponse: Response is not successful");
                    }
                }

                @Override
                public void onFailure(Call<DataMovie> call, Throwable t) {
                    Toast.makeText(getActivity(), "Unable to fetch data!", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Retry();
        }
    }

    private void loading() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                for (int i = 0; i <= 10; i++) {
                    Thread.sleep(100);
                    int percentage = i * 10;
                    handler.post(() -> {
                        if (percentage == 100) {
                            progressBar.setVisibility(View.GONE);
                            recyclerView.setVisibility(View.VISIBLE);
                        } else {
                            progressBar.setVisibility(View.VISIBLE);
                            recyclerView.setVisibility(View.GONE);
                        }
                    });
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private void Retry() {
        disconnect.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);

        disconnect.setOnClickListener(view -> {
            disconnect.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
            handler.post(() -> {
                getDataApi();
            });
        });
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) requireContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}
