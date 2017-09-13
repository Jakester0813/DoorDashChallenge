package com.jakester.doordashchallenge.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Jake on 9/12/2017.
 */

public class Resturant {

    @SerializedName("business")
    @Expose
    Business mBusiness;

    @SerializedName("tags")
    @Expose
    List<String> mTags;

    @SerializedName("cover_img_url")
    @Expose
    String mCoverImgUrl;

    @SerializedName("status")
    @Expose
    String mStatus;

    @SerializedName("delivery_fee")
    @Expose
    String mDeliveryFee;

    boolean favorited;

    public Resturant() {
        favorited = false;
    }


    public void setBusiness(Business pBusiness){
        this.mBusiness = pBusiness;
    }

    public Business getBusiness(){
        return mBusiness;
    }

    public void setTags(List<String> pTags){
        this.mTags = pTags;
    }

    public String getDescription(){
        StringBuilder mBuilder = new StringBuilder(mTags.get(0));
        for(int i = 1; i < mTags.size(); i++){
            mBuilder.append(", ").append(mTags.get(i));
        }
        return mBuilder.toString();
    }

    public void setCoverImgUrl(String pCoverImgUrl){
        this.mCoverImgUrl = pCoverImgUrl;
    }

    public String getCoverImgUrl(){
        return mCoverImgUrl;
    }

    public void setStatus(String pStatus){
        this.mStatus = pStatus;
    }

    public String getStatus(){
        return mStatus;
    }

    public void setDeliveryTime(String pDeliveryFee){
        this.mDeliveryFee = pDeliveryFee;
    }

    public String getDeliveryTime(){
        return mDeliveryFee;
    }

    public void setFavorited(boolean favorite){
        this.favorited = favorite;
    }

    public boolean getFavorite(){
        return favorited;
    }
}
