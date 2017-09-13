package com.jakester.doordashchallenge.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jakester.doordashchallenge.R;
import com.jakester.doordashchallenge.models.FavoritesManager;
import com.jakester.doordashchallenge.models.Resturant;

import java.util.List;

/**
 * Created by Jake on 9/12/2017.
 */

public class ResturantAdapter extends RecyclerView.Adapter<ResturantAdapter.ResturantViewHolder> {

    List<Resturant> resturantList;
    Context mContext;

    public ResturantAdapter(Context pContext){
        this.mContext = pContext;
    }

    public void setAdapter(List<Resturant> pResturants){
        this.resturantList = pResturants;
    }

    @Override
    public ResturantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.resturant_row, parent, false);
        return new ResturantViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(ResturantViewHolder holder, int position) {
        holder.bind(resturantList.get(position), mContext);
    }

    @Override
    public int getItemCount() {
        return resturantList.size();
    }

    public static class ResturantViewHolder extends RecyclerView.ViewHolder{

        ImageView mResturantCover, mFavorite;
        TextView mResturantNameText, mDescriptionText, mStatusText;

        public ResturantViewHolder(View itemView){
            super (itemView);
            this.mResturantCover = (ImageView) itemView.findViewById(R.id.iv_resturant);
            this.mResturantNameText = (TextView) itemView.findViewById(R.id.tv_resturant);
            this.mDescriptionText = (TextView) itemView.findViewById(R.id.tv_resturant_desc);
            this.mFavorite = (ImageView) itemView.findViewById(R.id.iv_favorite);
            this.mStatusText = (TextView) itemView.findViewById(R.id.tv_status);
        }

        public void bind(final Resturant resturant, final Context pContext){
            Glide.with(pContext).load(resturant.getCoverImgUrl()).into(mResturantCover);
            mResturantNameText.setText(resturant.getBusiness().getName());
            mDescriptionText.setText(resturant.getDescription());
            mStatusText.setText(resturant.getStatus());
            mFavorite.setImageResource(resturant.getFavorite() ? R.drawable.ic_star_red_24dp : R.drawable.ic_star_border_black_24dp);
            mFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mFavorite.setImageResource(resturant.getFavorite() ? R.drawable.ic_star_border_black_24dp : R.drawable.ic_star_red_24dp);
                    if(resturant.getFavorite()){
                        FavoritesManager.getInstance(pContext).removeFavorite(resturant.getBusiness().getId());
                    }
                    else{
                        FavoritesManager.getInstance(pContext).addFavorite(resturant.getBusiness().getId());
                    }
                    resturant.setFavorited(resturant.getFavorite() ? false : true);
                }
            });
        }
    }
}
