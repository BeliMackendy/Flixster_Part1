package com.myapp.flixster.adapter;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
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

public class MovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Movie> movies;
    int images = 1;

    public MovieAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == images) {
            View view = inflater.inflate(R.layout.item_movie_full, parent, false);
            return new ViewHolder2(view);
        }
        View view = inflater.inflate(R.layout.item_movie, parent, false);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Movie movie = movies.get(position);
        if (holder.getItemViewType() == images) {
            ViewHolder2 v2 = (ViewHolder2) holder;
            v2.Bind_movie(movie);
        } else {
            ViewHolder1 v1 = (ViewHolder1) holder;
            v1.Bind_movie(movie);
        }
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (movies.get(position).getVote_average() > 5)
            return images;
        else
            return 0;
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {
        TextView tv_title, tv_overview;
        ImageView iv_movie;
        View view;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_overview = itemView.findViewById(R.id.tv_overview);
            iv_movie = itemView.findViewById(R.id.iv_movie);
            view = itemView;
        }

        public void Bind_movie(Movie movie) {
            tv_title.setText(movie.getTitle());
            tv_overview.setText(movie.getOverview());
            Context context = view.getContext();
            String images = movie.getPoster_path();
            int x = Target.SIZE_ORIGINAL, y = Target.SIZE_ORIGINAL;

            int orientation = view.getResources().getConfiguration().orientation;

            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                images = movie.getBackdrop_path();
                x = 1000;
                y = 1000;
            }

            GlideApp.with(view.getContext())
                    .load(images)
                    .override(x, y)
                    .placeholder(R.drawable.placeholder)
                    .transition(DrawableTransitionOptions.withCrossFade(10000))
                    .into(iv_movie);
        }
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {
        ImageView iv_movie_full;
        View view;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            iv_movie_full = itemView.findViewById(R.id.iv_movie_full);
            view = itemView;
        }

        public void Bind_movie(Movie movie) {
            String images = movie.getPoster_path();
            int x = Target.SIZE_ORIGINAL, y = Target.SIZE_ORIGINAL;
            int orientation = view.getResources().getConfiguration().orientation;

            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                images = movie.getBackdrop_path();
                x = 4000;
                y = 4000;
            }
            GlideApp.with(view.getContext())
                    .load(images)
                    .override(x, y)
                    .placeholder(R.drawable.placeholder)
                    .transition(DrawableTransitionOptions.withCrossFade(10000))
                    .into(iv_movie_full);
        }
    }
}
