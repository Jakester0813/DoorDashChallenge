package com.jakester.doordashchallenge.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jake on 9/12/2017.
 */

public class Business {

    @SerializedName("id")
    @Expose
    String mId;

    @SerializedName("name")
    @Expose
    String mName;

    public void setId(String pId){
        this.mId = pId;
    }

    public String getId(){
        return mId;
    }

    public void setName(String pName){
        this.mName = pName;
    }

    public String getName(){
        return mName;
    }
}
