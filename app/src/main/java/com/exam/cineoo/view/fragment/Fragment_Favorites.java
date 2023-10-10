package com.exam.cineoo.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.exam.cineoo.R;
import com.exam.cineoo.model.Movie;
import com.exam.cineoo.model.MovieRepository;
import com.exam.cineoo.view.recycleview.RecycleViewAdapter;
import com.exam.cineoo.view.recycleview.RecycleViewAdapter_Fav;
import com.exam.cineoo.viewmodel.FavoritesManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Fragment_Favorites extends Fragment {

    RecyclerView recyclerView;
    RecycleViewAdapter_Fav favoritesAdapter;
    Context context;
    FragmentManager fragmentManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);

        context = getContext();
        recyclerView = view.findViewById(R.id.rv_movie_favorite);

        FavoritesManager favoritesManager = new FavoritesManager(getContext());
        Set<String> favoriteMovieIds = favoritesManager.getFavorites();

        List<Movie> favoriteMovies = getFavoriteMoviesFromIds(favoriteMovieIds);


        fragmentManager = getActivity().getSupportFragmentManager();
        favoritesAdapter = new RecycleViewAdapter_Fav(context, favoriteMovies, fragmentManager);
        recyclerView.setAdapter(favoritesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    private List<Movie> getFavoriteMoviesFromIds(Set<String> favoriteMovieIds) {
        List<Movie> favoriteMovies = new ArrayList<>();
        MovieRepository movieRepository = new MovieRepository();

        for (String movieId : favoriteMovieIds) {
            Movie movie = movieRepository.fetchMovieById(movieId);
            if (movie != null) {
                favoriteMovies.add(movie);
            }
        }

        return favoriteMovies;
    }

    private List<Movie> fetchAllMovies() {
        List<Movie> allMoviesList = new ArrayList<>();
        return allMoviesList;
    }
}
