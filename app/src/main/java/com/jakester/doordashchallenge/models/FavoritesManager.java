package com.jakester.doordashchallenge.models;

import android.content.Context;
import android.content.SharedPreferences;

import com.jakester.doordashchallenge.utils.DoorDashContants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jake on 9/13/2017.
 */

public class FavoritesManager {
    private static FavoritesManager mInstance;
    private Favorites mFavorites;
    SharedPreferences mPrefs;

    public static FavoritesManager getInstance(Context mContext){
        if(mInstance == null){
            mInstance = new FavoritesManager(mContext);
        }
        return mInstance;
    }

    private FavoritesManager(Context mContext){
        mFavorites = new Favorites();
        mPrefs = mContext.getSharedPreferences(DoorDashContants.FAVORITE_PREFS, Context.MODE_PRIVATE);
    }

    public void addFavorite(String id){
        mFavorites.addFavorite(id);
    }

    public void removeFavorite(String id){
        mFavorites.removeFavorite(id);
    }

    public void storeFavorites(){
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        prefsEditor.putString(DoorDashContants.FAVORITE, mFavorites.convertToStringArray());
        prefsEditor.commit();
    }

    public void getFavorites(){
        String json = mPrefs.getString(DoorDashContants.FAVORITE, DoorDashContants.EMPTY_STRING);
        mFavorites.convertToHashSet(json);

    }

    public List<Resturant> rearrangeResturantsWithFavorites(List<Resturant> list){
        List<Resturant> tempResturant = new ArrayList<Resturant>();
        for(Resturant resturant : list){
            if(mFavorites.containsFavorite(resturant.getBusiness().getId())){
                tempResturant.add(resturant);
            }
        }

        for(Resturant resturant : tempResturant){
            list.remove(resturant);
            resturant.setFavorited(true);
            list.add(0,resturant);
        }
        return list;
    }
}
