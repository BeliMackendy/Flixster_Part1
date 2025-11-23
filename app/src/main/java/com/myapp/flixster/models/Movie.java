package com.myapp.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title;
    private String poster_path;
    private String overview;
    private String backdrop_path;

    public Movie(JSONObject movieJson) throws JSONException {
        title= movieJson.getString("title");
        poster_path = movieJson.getString("poster_path");
        overview = movieJson.getString("overview");
        backdrop_path = movieJson.getString("backdrop_path");
    }

    public static List<Movie> fromJSonArray(JSONArray movieJson) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for(int i = 0; i<movieJson.length(); i++){
            movies.add(new Movie(movieJson.getJSONObject(i)));
        }
        return  movies;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster_path() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", poster_path);
    }

    public String getBackdrop_path() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdrop_path);
    }

    public String getOverview() {
        return overview;
    }
}
