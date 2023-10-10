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

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>{

    public Context context;
    private FragmentManager fragmentManager;
    List<String> nID;
    List<String> nImage;
    List<String> nRelease_date;
    List<String> nTitle_en;
    List<String> nSynopsis_en;
    List<String> nGenre;

    public RecycleViewAdapter(Context context , List<String> nID , List<String> nImage , List<String> nRelease_date , List<String> nTitle_en , List<String> nSynopsis_en , List<String> nGenre , FragmentManager fragmentManager) {

        this.context = context;
        this.nID = nID;
        this.nImage = nImage;
        this.nRelease_date = nRelease_date;
        this.nTitle_en = nTitle_en;
        this.nSynopsis_en = nSynopsis_en;
        this.nGenre = nGenre;
        this.fragmentManager = fragmentManager;

    }


    @Override
    public RecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View T;
        T = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycleview,
                parent, false);

        return new ViewHolder(T, context);
    }

    @Override
    public void onBindViewHolder(RecycleViewAdapter.ViewHolder holder, int position) {

        String Release_date_text = dateTotext(nRelease_date.get(position));
        holder.Release_date.setText(Release_date_text);
        holder.Title_en.setText(nTitle_en.get(position));
        holder.Genre.setText(nGenre.get(position));
        holder.setIMG(nImage.get(position));

        holder.setOnClickRecycleView(new OnClickRecycleView() {
            @Override
            public void onClick(View view, int position, boolean isLongClick, MotionEvent motionEvent) {

                openDetailFragment(position);

            }
        });
    }

    @Override
    public int getItemCount() {
        return nID.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{

        private OnClickRecycleView onClickRecycleView;
        Context context;
        ImageView imgUser;
        TextView Release_date;
        TextView Title_en;
        String Synopsis_en;
        TextView Genre;
        public ViewHolder(View itemView , Context context) {
            super(itemView);
            this.context = context;
            imgUser = itemView.findViewById(R.id.iv_image);
            Release_date = itemView.findViewById(R.id.tv_date);
            Title_en = itemView.findViewById(R.id.tv_title);
            Genre = itemView.findViewById(R.id.tv_genre);
            itemView.setOnClickListener(this);
        }
        public void setOnClickRecycleView(OnClickRecycleView onClickRecycleView){
            this.onClickRecycleView =  onClickRecycleView;

        }

        @Override
        public void onClick(View v) {
            onClickRecycleView.onClick(v, getAdapterPosition(), false, null);
        }

        public void setIMG(String url){

            if(!url.isEmpty())
                Picasso.with(context).load(url).into(imgUser);
            else
                imgUser.setImageDrawable(context.getDrawable(R.drawable.ic_placeholder));

        }



    }
    public String dateTotext(String args) {

        String dateStr = args;

        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-M-d", Locale.US);

        String formattedDate = null;
        try {
            Date date = inputDateFormat.parse(dateStr);

            SimpleDateFormat outputDateFormat = new SimpleDateFormat("MMMM d, yyyy", Locale.US);

            formattedDate = outputDateFormat.format(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return formattedDate;
    }
    private void openDetailFragment(int position) {
        Fragment_Detail fragmentDetail = new Fragment_Detail();

        Bundle args = new Bundle();
        args.putString("id", nID.get(position));
        args.putString("image", nImage.get(position));
        args.putString("release_date", nRelease_date.get(position));
        args.putString("title_en", nTitle_en.get(position));
        args.putString("synopsis_en", nSynopsis_en.get(position));
        args.putString("genre", nGenre.get(position));
        fragmentDetail.setArguments(args);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content, fragmentDetail);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
