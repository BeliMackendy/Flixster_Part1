package com.myapplication.flixster.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.myapplication.flixster.R;
import com.myapplication.flixster.models.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.Viewholer> {
    List<Movie> movies;

    public MovieAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public Viewholer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.item_movie, parent, false);

        return new Viewholer(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholer holder, int position) {
        holder.item = movies.get(position);
        holder.tvTitle.setText(holder.item.getTitle());
        holder.tvOverview.setText(holder.item.getOverView());

        Glide.with(holder.mView.getContext()).load(holder.item.getPosterPath()).into(holder.ivPoster);


    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class Viewholer extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvOverview;
        ImageView ivPoster;
        View mView;
        Movie item;

        public Viewholer(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvOverview = itemView.findViewById(R.id.tv_overview);
            ivPoster = itemView.findViewById(R.id.ivposter);
        }
    }
}
