package com.exam.cineoo.view.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.exam.cineoo.R;
import com.exam.cineoo.model.Movie;
import com.exam.cineoo.network.NetworkConnectionManager;
import com.exam.cineoo.network.OnNetworkCallback_Movie;
import com.exam.cineoo.view.recycleview.RecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Response;

public class Fragment_Main extends Fragment {
    RecyclerView recycleView;
    RecycleViewAdapter recycleViewAdapter;
    List<String> Data_img;
    List<String> Data_title;
    List<String> Data_genre;
    List<String> Data_release_date;
    List<String> Data_id;
    List<String> Data_nSynopsis_en;
    FragmentManager fragmentManager;
    Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_main, container, false);

        context = getContext();
        recycleView = view.findViewById(R.id.rv_movie);
        fragmentManager = getActivity().getSupportFragmentManager();
        Setup_RecycleView(view);
        return view;
    }

    public void Setup_RecycleView(View view) {
        Data_img = new ArrayList<>();
        Data_genre = new ArrayList<>();
        Data_title = new ArrayList<>();
        Data_release_date = new ArrayList<>();

        Data_id = new ArrayList<>();
        Data_nSynopsis_en = new ArrayList<>();


        new NetworkConnectionManager().callServer_trainer(listener);

        recycleViewAdapter = new RecycleViewAdapter(context,Data_id, Data_img, Data_release_date,Data_title ,Data_nSynopsis_en, Data_genre, fragmentManager);
        recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        recycleView.setAdapter(recycleViewAdapter);

    }

    OnNetworkCallback_Movie listener = new OnNetworkCallback_Movie() {


        @Override
        public void onResponse(List<Movie> data) {
            if (data != null) {
                int dataSize = data.size();

//                Toast.makeText(context, ""+dataSize, Toast.LENGTH_SHORT).show();
                
                for (int i = 0; i< data.size() ;i++){
                    Data_img.add(data.get(i).getPosterUrl());
                    Data_title.add(data.get(i).getTitleEn());
                    Data_genre.add(data.get(i).getGenre());
                    Data_release_date.add(data.get(i).getReleaseDate());
                    Data_id.add(data.get(i).getId().toString());
                    Data_nSynopsis_en.add(data.get(i).getSynopsisEn());

//                    Log.e("TAG", "onResponse: "+Data_title+Data_img );

                }

                if (!Data_img.isEmpty() && !Data_title.isEmpty() && !Data_genre.isEmpty() && !Data_release_date.isEmpty() && !Data_id.isEmpty() && !Data_nSynopsis_en.isEmpty()) {
                    recycleViewAdapter.notifyDataSetChanged();
                }


                
            }else {
                Toast.makeText(context, "Connect but Error", Toast.LENGTH_SHORT).show();
            }
            
        }


        @Override
        public void onBodyError(ResponseBody responseBodyError) {
            Setup_RecycleView(getView());
        }

        @Override
        public void onBodyErrorIsNull() {
            Setup_RecycleView(getView());
        }

        @Override
        public void onFailure(Throwable t) {
            Setup_RecycleView(getView());
        }
    };
}


