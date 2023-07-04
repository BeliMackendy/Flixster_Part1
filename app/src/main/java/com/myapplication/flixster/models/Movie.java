package com.myapplication.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title;
    private String posterPath;
    private String overView;

    public Movie(JSONObject movieJsonObject) throws JSONException {
        title = movieJsonObject.getString("title");
        overView = movieJsonObject.getString("overview");
        posterPath = movieJsonObject.getString("poster_path");
    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movieList = new ArrayList<>();
        for (int i=0; i<movieJsonArray.length(); i++){
            movieList.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movieList;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",posterPath);
    }

    public String getOverView() {
        return overView;
    }
}
