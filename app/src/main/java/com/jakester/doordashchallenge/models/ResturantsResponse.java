package com.jakester.doordashchallenge.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Jake on 9/12/2017.
 */

public class ResturantsResponse {
    @SerializedName("resturant")
    @Expose
    List<Resturant> resturants;

    public List<Resturant> getResturantList(){
        return resturants;
    }

    public void setResturants(List<Resturant> mResturants) {resturants = mResturants;}
}
