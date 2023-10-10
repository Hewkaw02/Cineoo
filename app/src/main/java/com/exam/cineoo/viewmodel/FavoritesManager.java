package com.exam.cineoo.viewmodel;import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashSet;
import java.util.Set;

public class FavoritesManager {
    private static final String PREF_NAME = "FavoriteMovies";
    private static final String KEY_FAVORITES = "favoriteSet";

    private SharedPreferences sharedPreferences;

    public FavoritesManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    // Add a movie ID to favorites
    public void addToFavorites(String movieId) {
        Set<String> favorites = getFavorites();
        favorites.add(movieId);
        saveFavorites(favorites);
    }

    // Remove a movie ID from favorites
    public void removeFromFavorites(String movieId) {
        Set<String> favorites = getFavorites();
        favorites.remove(movieId);
        saveFavorites(favorites);
    }

    // Get the set of favorite movie IDs
    public Set<String> getFavorites() {
        return sharedPreferences.getStringSet(KEY_FAVORITES, new HashSet<>());
    }

    // Save the set of favorite movie IDs
    private void saveFavorites(Set<String> favorites) {
        sharedPreferences.edit().putStringSet(KEY_FAVORITES, favorites).apply();
    }

}
