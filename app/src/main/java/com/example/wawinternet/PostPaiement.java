package com.example.wawinternet;

import com.example.wawinternet.Activity.Paiement;
import com.example.wawinternet.Modeles.ModelCarte;
import com.example.wawinternet.Modeles.ModelPaiement;
import com.example.wawinternet.Modeles.ModelUser;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PostPaiement {
    //@POST("paiement/")
    //Call<JsonObject> createPaiemnt(@Body ModelPaiement modelPaiement);
    @FormUrlEncoded
    @POST("paiement/")
    Call<JsonObject> createPaiement(@Field ("quipaie") String quipaie, @Field ("debit")String debit, @Field ("Abonnement_id") int Abonnement_id, @Field ("codecarte") int codecarte);


    @POST("carte/")
    Call<JsonObject> createCarte(@Body ModelCarte modelCarte);
}
