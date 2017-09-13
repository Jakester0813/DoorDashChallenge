package com.jakester.doordashchallenge.models;

import java.util.HashSet;

/**
 * Created by Jake on 9/12/2017.
 */

public class Favorites {
    HashSet<String> mFavoriteIds;

    public Favorites(){
        mFavoriteIds = new HashSet<String>();
    }

    public void addFavorite(String id){
        mFavoriteIds.add(id);
    }

    public boolean containsFavorite(String id){
        return mFavoriteIds.contains(id);
    }
}
