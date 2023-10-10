package com.exam.cineoo.view.recycleview;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.exam.cineoo.R;
import com.exam.cineoo.model.Movie;
import com.exam.cineoo.view.fragment.Fragment_Detail;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class RecycleViewAdapter_Fav extends RecyclerView.Adapter<RecycleViewAdapter_Fav.ViewHolder> {

    private Context context;
    private FragmentManager fragmentManager;
    private List<Movie> movies;

    public RecycleViewAdapter_Fav(Context context, List<Movie> movies, FragmentManager fragmentManager) {
        this.context = context;
        this.movies = movies;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycleview, parent, false);
        return new ViewHolder(itemView, context);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = movies.get(position);

        String releaseDateText = dateToText(movie.getReleaseDate());
        holder.releaseDate.setText(releaseDateText);
        holder.titleEn.setText(movie.getTitleEn());
        holder.genre.setText(movie.getGenre());
        holder.setIMG(movie.getPosterUrl());

        holder.setOnClickRecycleView(new OnClickRecycleView() {
            @Override
            public void onClick(View view, int position, boolean isLongClick, MotionEvent motionEvent) {
                openDetailFragment(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private OnClickRecycleView onClickRecycleView;
        private Context context;
        private ImageView imgUser;
        private TextView releaseDate;
        private TextView titleEn;
        private String synopsisEn;
        private TextView genre;

        public ViewHolder(View itemView, Context context) {
            super(itemView);
            this.context = context;
            imgUser = itemView.findViewById(R.id.iv_image);
            releaseDate = itemView.findViewById(R.id.tv_date);
            titleEn = itemView.findViewById(R.id.tv_title);
            genre = itemView.findViewById(R.id.tv_genre);
            itemView.setOnClickListener(this);
        }

        public void setOnClickRecycleView(OnClickRecycleView onClickRecycleView) {
            this.onClickRecycleView = onClickRecycleView;
        }

        @Override
        public void onClick(View v) {
            onClickRecycleView.onClick(v, getAdapterPosition(), false, null);
        }

        public void setIMG(String url) {
            if (!url.isEmpty()) {
                Picasso.with(context).load(url).into(imgUser);
            } else {
                imgUser.setImageDrawable(context.getDrawable(R.drawable.ic_placeholder));
            }
        }
    }

    public String dateToText(String dateStr) {
        return dateStr;
    }

    private void openDetailFragment(int position) {
        Fragment_Detail fragmentDetail = new Fragment_Detail();

        Bundle args = new Bundle();
        Movie movie = movies.get(position);
        args.putString("id", movie.getId().toString());
        args.putString("image", movie.getPosterUrl());
        args.putString("release_date", movie.getReleaseDate());
        args.putString("title_en", movie.getTitleEn());
        args.putString("synopsis_en", movie.getSynopsisEn());
        args.putString("genre", movie.getGenre());
        fragmentDetail.setArguments(args);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content, fragmentDetail);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
