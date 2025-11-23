package com.myapp.flixster.adapter;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.target.Target;
import com.myapp.flixster.GlideApp;
import com.myapp.flixster.R;
import com.myapp.flixster.models.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    List<Movie> movies;

    public MovieAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_movie,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = movies.get(position);

        holder.tv_title.setText(movie.getTitle());
        holder.tv_overview.setText(movie.getOverview());
        Context context = holder.view.getContext();
        String images = movie.getPoster_path();
        int x = Target.SIZE_ORIGINAL, y= Target.SIZE_ORIGINAL;

        int orientation = holder.view.getResources().getConfiguration().orientation;

        if(orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            images = movie.getBackdrop_path();
            x= 1000; y=1000;
        }


        GlideApp.with(context)
                .load(images)
                .override(x, y)
                .placeholder(R.drawable.placeholder)
                .transition(DrawableTransitionOptions.withCrossFade(10000))
                .into(holder.iv_movie);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title,tv_overview;
        ImageView iv_movie;
        View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_overview = itemView.findViewById(R.id.tv_overview);
            iv_movie = itemView.findViewById(R.id.iv_movie);
            view = itemView;
        }
    }
}
