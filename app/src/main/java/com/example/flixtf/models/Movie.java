package com.example.flixtf.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;
@Parcel
public class Movie {
    int movieID;
    String poster_path;
    String title;
    String overview;
    double rating;
    //empty constructor needed for Parcel
    public Movie(){

    }

    public Movie(JSONObject jsonObject) throws JSONException {
        poster_path = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        rating = jsonObject.getDouble("vote_average");
        movieID = jsonObject.getInt("id");
    }

    public static List<Movie> fromJSONArray(JSONArray movieJSONArray) throws JSONException {
        List<Movie> movies =  new ArrayList<>();
        for(int i=0; i < movieJSONArray.length(); i++){
            movies.add(new Movie(movieJSONArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getPoster_path() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",poster_path);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public double getRating() {
        return rating;
    }
    public int getMovieID() {
        return movieID;
    }
}
