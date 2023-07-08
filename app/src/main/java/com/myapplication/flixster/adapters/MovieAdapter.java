package com.myapplication.flixster.adapters;

import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.myapplication.flixster.R;
import com.myapplication.flixster.models.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Movie> movies;

    public MovieAdapter(List<Movie> movies) {
        this.movies = movies;
    }

//    @NonNull
//    @Override
//    public Viewholer1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//
//        View view = inflater.inflate(R.layout.item_movie, parent, false);
//
//        return new Viewholer1(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull Viewholer1 holder, int position) {
//        holder.item = movies.get(position);
//        holder.tvTitle.setText(holder.item.getTitle());
//        holder.tvOverview.setText(holder.item.getOverView());
//
//        int orientation = holder.mView.getResources().getConfiguration().orientation;
//
//        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
//            Glide.with(holder.mView.getContext())
//                    .load(holder.item.getPosterPath())
//                    .placeholder(R.drawable.placeholder_movie)
//                    .transition(new DrawableTransitionOptions().crossFade(5000))
//                    .transform(new RoundedCorners(10))
//                    .into(holder.ivPoster);
//        } else {
//            Glide.with(holder.mView.getContext())
//                    .load(holder.item.getBackdropPath())
//                    .placeholder(R.drawable.placeholder_movie)
//                    .transition(new DrawableTransitionOptions().crossFade(5000))
//                    .transform(new RoundedCorners(10))
//                    .into(holder.ivPoster);
//        }
//    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case 1:
                View view2 = inflater.inflate(R.layout.item_movie_image, parent, false);
                viewHolder = new Viewholer2(view2);
                break;
            default:
                View view = inflater.inflate(R.layout.item_movie, parent, false);
                viewHolder = new Viewholer1(view);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case 1:
                Viewholer2 holder2 = (Viewholer2) holder;
                configureHolder2(holder2, position);
                break;
            default:
                Viewholer1 holder1 = (Viewholer1) holder;
                configureHolder1(holder1, position);
                break;
        }
    }

    private void configureHolder1(Viewholer1 holder, int position) {
        holder.item = movies.get(position);
        holder.tvTitle.setText(holder.item.getTitle());
        holder.tvOverview.setText(holder.item.getOverView());

        int orientation = holder.mView.getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            Glide.with(holder.mView.getContext())
                    .load(holder.item.getPosterPath())
                    .placeholder(R.drawable.placeholder_movie)
                    .transition(new DrawableTransitionOptions().crossFade(5000))
                    .transform(new RoundedCorners(10))
                    .into(holder.ivPoster);
        } else {
            Glide.with(holder.mView.getContext())
                    .load(holder.item.getBackdropPath())
                    .placeholder(R.drawable.placeholder_movie)
                    .transition(new DrawableTransitionOptions().crossFade(5000))
                    .transform(new RoundedCorners(10))
                    .into(holder.ivPoster);
        }
    }

    private void configureHolder2(Viewholer2 holder, int position) {
        holder.item = movies.get(position);
        int orientation = holder.mView.getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            Glide.with(holder.mView.getContext())
                    .load(holder.item.getPosterPath())
                    .placeholder(R.drawable.placeholder_movie)
                    .transition(new DrawableTransitionOptions().crossFade(5000))
                    .transform(new RoundedCorners(10))
                    .into(holder.ivmovie);
        } else {
            Glide.with(holder.mView.getContext())
                    .load(holder.item.getBackdropPath())
                    .placeholder(R.drawable.placeholder_movie)
                    .transition(new DrawableTransitionOptions().crossFade(5000))
                    .transform(new RoundedCorners(10))
                    .into(holder.ivmovie);
        }
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    @Override
    public int getItemViewType(int position) {
        Double voteAverage = movies.get(position).getVoteAverage();
        if (voteAverage > 6)
            return 1;
        else
            return 0;
    }

    public class Viewholer1 extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvOverview;
        ImageView ivPoster;
        View mView;
        Movie item;

        public Viewholer1(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvOverview = itemView.findViewById(R.id.tv_overview);
            ivPoster = itemView.findViewById(R.id.ivposter);
        }
    }

    public class Viewholer2 extends RecyclerView.ViewHolder {

        ImageView ivmovie;
        View mView;
        Movie item;

        public Viewholer2(@NonNull View itemView) {
            super(itemView);
            mView = itemView;

            ivmovie = itemView.findViewById(R.id.iv_movie);
        }
    }
}
