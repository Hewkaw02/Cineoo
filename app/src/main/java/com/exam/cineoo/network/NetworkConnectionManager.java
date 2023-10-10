package com.exam.cineoo.network;

import android.util.Log;

import com.exam.cineoo.model.ApiResponse;
import com.exam.cineoo.model.Movie;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkConnectionManager {

    public void callServer_trainer(final OnNetworkCallback_Movie listener) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.majorcineplex.com/apis/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APIServer callapi = retrofit.create(APIServer.class);

        Call<ApiResponse> call = callapi.getCineoo();

        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    ApiResponse apiResponse = response.body();
                    if (apiResponse != null && apiResponse.getMovies() != null) {
                        List<Movie> movies = apiResponse.getMovies();
                        listener.onResponse(movies);
                    } else {
                        Log.e("Response", "Received null data or empty movies list");
                        // Log more details about the response
                        Log.d("Response", "Response code: " + response.code());
                        Log.d("Response", "Response message: " + response.message());
                        Log.d("Response", "Response raw: " + response.raw().toString());
                        listener.onBodyErrorIsNull();
                    }
                } else {
                    Log.e("Response", "Received unsuccessful response. Status code: " + response.code());
                    // Log more details about the response
                    Log.d("Response", "Response message: " + response.message());
                    Log.d("Response", "Response raw: " + response.raw().toString());
                    listener.onBodyError(response.errorBody());
                }
            }


            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.e("NT", t.getMessage(), t);
                listener.onFailure(t);
            }
        });
    }
}
