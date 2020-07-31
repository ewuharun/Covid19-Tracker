package com.example.coronatracker;

import com.example.coronatracker.Model.MyResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface JsonPlaceHolderApi {
    @GET("/countries")
    Call<List<MyResponse>> getData();
}