package com.jakester.doordashchallenge.interfaces;

import com.jakester.doordashchallenge.models.Resturant;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Jake on 9/12/2017.
 */

public interface ResturantsInterface {
    @GET("v2/resturant/?lat=37.422740&lng=-122.139956")
    Call<List<Resturant>> getResturants();
}
