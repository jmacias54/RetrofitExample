package com.retrofit.retrofitexample.services;

import com.retrofit.retrofitexample.models.Catalogo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Hitss on 19/12/2017.
 */

public interface ApiService {

    public static final String BASE_URL = "https://www.udacity.com/public-api/v0/";
    @GET("courses")
    Call<Catalogo> listaCatalogo();
}
