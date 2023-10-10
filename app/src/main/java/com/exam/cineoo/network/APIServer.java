package com.exam.cineoo.network;

import com.exam.cineoo.model.ApiResponse;
import com.exam.cineoo.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIServer {

//    @GET("get_movie_avaiable")
//    Call<List<Movie>> getCineoo();

    @GET("get_movie_avaiable")
    Call<ApiResponse> getCineoo();
}
