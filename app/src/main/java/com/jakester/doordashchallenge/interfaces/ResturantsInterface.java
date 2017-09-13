package com.jakester.doordashchallenge.interfaces;

import com.jakester.doordashchallenge.models.Resturant;
import com.jakester.doordashchallenge.utils.DoorDashContants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Jake on 9/12/2017.
 */

public interface ResturantsInterface {
    @GET(DoorDashContants.QUERY_URL)
    Call<List<Resturant>> getResturants();
}
