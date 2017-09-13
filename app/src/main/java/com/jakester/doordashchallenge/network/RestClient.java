package com.jakester.doordashchallenge.network;

import com.jakester.doordashchallenge.utils.DoorDashContants;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jake on 9/12/2017.
 */

public class RestClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        retrofit = new Retrofit.Builder()
                .baseUrl(DoorDashContants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();



        return retrofit;
    }
}
