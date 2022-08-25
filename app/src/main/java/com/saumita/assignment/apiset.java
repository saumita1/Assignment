package com.saumita.assignment;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface apiset {
    @FormUrlEncoded
    @POST("test-login")
    Call<LoginResponse> verifyuser(@Field("email") String email,
                                   @Field("password") String password);

    @GET("contactus-category")
    Call<DetailsResponse> getVerticalData();
}
