package com.exam.cineoo.network;

import com.exam.cineoo.model.Movie;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Response;

public interface OnNetworkCallback_Movie {
    public void onResponse(List<Movie> movie);

    public void onBodyError(ResponseBody responseBodyError);

    public void onBodyErrorIsNull();

    public void onFailure(Throwable t);
}
