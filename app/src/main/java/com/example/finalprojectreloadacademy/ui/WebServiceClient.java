package com.example.finalprojectreloadacademy.ui;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebServiceClient {
    private static Retrofit retrofit=null;
    public static Retrofit getRetrofit(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl("https://simplifiedcoding.net/").addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
