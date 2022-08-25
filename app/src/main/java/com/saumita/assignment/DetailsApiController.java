package com.saumita.assignment;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailsApiController {
    private static DetailsApiController detailsApiController;
    private static Retrofit retrofit;

    DetailsApiController() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constant.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized DetailsApiController getInstance() {
        if (detailsApiController == null)
            detailsApiController = new DetailsApiController();
        return detailsApiController;
    }

    apiset getapi() {
        return retrofit.create(apiset.class);
    }
}
