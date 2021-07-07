package com.example.finalprojectreloadacademy.model;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {
    @GET("demos/marvel/")
    public Call<ArrayList<MoviesModel>> getMovies();
}
