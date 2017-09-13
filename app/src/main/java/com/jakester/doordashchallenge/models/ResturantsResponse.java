package com.jakester.doordashchallenge.models;

import com.google.gson.annotations.Expose;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Jake on 9/12/2017.
 */

public class ResturantsResponse {
    @Expose
    List<Resturant> resturants;

    public List<Resturant> getResturants(){
        return resturants;
    }

    public void setResturants(List<Resturant> mResturants) {resturants = mResturants;}
}
