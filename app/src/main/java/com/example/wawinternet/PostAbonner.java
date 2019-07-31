package com.example.wawinternet;

import com.example.wawinternet.Modeles.ModelUser;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PostAbonner {
    @POST("abonnement/")
    Call<JsonObject> createAbonnement(@Body ModelUser modelUser);
}
