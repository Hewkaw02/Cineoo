package com.exam.cineoo.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.exam.cineoo.R;
import com.exam.cineoo.viewmodel.FavoritesManager;
import com.squareup.picasso.Picasso;

import java.util.Set;

public class Fragment_Detail extends Fragment implements View.OnClickListener {

    String id;
    String title;
    String genre;
    String release_date;
    String synopsis_en;
    String image;
    Context context;
    ImageView tv_image;
    Button btnAddtoFav;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        context = getContext();
        btnAddtoFav = view.findViewById(R.id.btn_favorite);
        btnAddtoFav.setOnClickListener(this);
        set_text(view);


        return view;
    }


    public void set_text(View view) {

        Bundle args = getArguments();
        if (args != null) {
            id = args.getString("id", "");
            title = args.getString("title_en", "");
            genre = args.getString("genre", "");
            release_date = args.getString("release_date", "");
            synopsis_en = args.getString("synopsis_en", "");
            image = args.getString("image", "");

        }

        TextView tv_title = view.findViewById(R.id.tv_title_detail);
        TextView tv_genre = view.findViewById(R.id.tv_genre_detail);
        TextView tv_synopsis_en = view.findViewById(R.id.tv_synopsis_en_detail);
        tv_image = view.findViewById(R.id.iv_image_detail);

        tv_title.setText(title);
        tv_genre.setText(genre);
        tv_synopsis_en.setText(synopsis_en);
        setIMG(image);


    }

    public void setIMG(String url) {

        if (!url.isEmpty())
            Picasso.with(context).load(url).into(tv_image);
        else
            tv_image.setImageDrawable(context.getDrawable(R.drawable.ic_placeholder));

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_favorite) {

            FavoritesManager favoritesManager = new FavoritesManager(getContext());
            String movieId = getArguments().getString("id");
            boolean isFavorite = isFavorite(movieId);

            if (isFavorite) {

                favoritesManager.removeFromFavorites(movieId);
                Toast.makeText(getContext(), "Removed from Favorites", Toast.LENGTH_SHORT).show();
            } else {
                // Add to favorites
                favoritesManager.addToFavorites(movieId);
                Toast.makeText(getContext(), "Added to Favorites", Toast.LENGTH_SHORT).show();
            }

            updateFavoriteButtonUI(!isFavorite);
        }
    }

    private boolean isFavorite(String movieId) {
        FavoritesManager favoritesManager = new FavoritesManager(getContext());
        Set<String> favorites = favoritesManager.getFavorites();
        return favorites.contains(movieId);
    }

    private void updateFavoriteButtonUI(boolean isFavorite) {
        String buttonText = isFavorite ? "Remove from Favorites" : "Add to Favorites";
        btnAddtoFav.setText(buttonText);
    }



}