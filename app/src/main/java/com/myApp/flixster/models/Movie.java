package com.myApp.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    String posterPath;
    String backdropPath;
    String title;
    String overview;
    Double vote_average;

    public Movie(JSONObject MovieObject) throws JSONException {
        posterPath = MovieObject.getString("poster_path");
        backdropPath = MovieObject.getString("backdrop_path");
        title = MovieObject.getString("title");
        overview = MovieObject.getString("overview");
        vote_average = MovieObject.getDouble("vote_average");
    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i =0; i<movieJsonArray.length(); i++){
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w300/%s", backdropPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public Double getVote_average() {
        return vote_average;
    }
}
