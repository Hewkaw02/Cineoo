package com.exam.cineoo.model;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository {
    private List<Movie> movieList;

    public MovieRepository() {
        movieList = fetchMoviesFromDataSource();
    }

    public Movie fetchMovieById(String movieId) {
        for (Movie movie : movieList) {
            if (movie.getId().equals(movieId)) {
                return movie;
            }
        }
        return null;
    }

    private List<Movie> fetchMoviesFromDataSource() {
        List<Movie> movies = new ArrayList<>();

        return movies;
    }
}
