package com.jakester.doordashchallenge.models;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.HashSet;
import java.util.Iterator;

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

    public void removeFavorite(String id) {
        mFavoriteIds.remove(id);
    }

    public boolean containsFavorite(String id){
        return mFavoriteIds.contains(id);
    }

    public String convertToStringArray(){
        JSONArray arr = new JSONArray();
        Iterator<String> iterator = mFavoriteIds.iterator();
        int i = 0;
        while(iterator.hasNext()){
            arr.put(iterator.next());
        }

        return arr.toString();
    }

    public void convertToHashSet(String str){
        try {
            JSONArray arr = new JSONArray(str);
            for (int i = 0; i < arr.length(); i++) {
                mFavoriteIds.add(arr.getString(i));
            }
        }
        catch(JSONException e){
            e.printStackTrace();
        }
    }
}
