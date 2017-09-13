package com.jakester.doordashchallenge.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.jakester.doordashchallenge.R;
import com.jakester.doordashchallenge.adapters.ResturantAdapter;
import com.jakester.doordashchallenge.interfaces.ResturantsInterface;
import com.jakester.doordashchallenge.models.Resturant;
import com.jakester.doordashchallenge.models.ResturantsResponse;
import com.jakester.doordashchallenge.network.RestClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView mResturantRecycler;
    LinearLayoutManager mLinearLayoutManager;
    ResturantAdapter mResturantAdapter;
    ResturantsInterface mInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mResturantRecycler = (RecyclerView) findViewById(R.id.rv_resturants);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mResturantRecycler.setLayoutManager(mLinearLayoutManager);
        mResturantAdapter = new ResturantAdapter(this);
        loadResturants();
    }

    public void loadResturants() {
        mInterface = RestClient.getClient().create(ResturantsInterface.class);
        mInterface.getResturants().enqueue(new Callback<List<Resturant>>() {
            @Override
            public void onResponse(Call<List<Resturant>> call, Response<List<Resturant>> response) {

                if(response.isSuccessful()) {
                    mResturantAdapter.setAdapter(response.body());
                    mResturantAdapter.notifyDataSetChanged();
                    mResturantRecycler.setAdapter(mResturantAdapter);
                }else {
                    int statusCode  = response.code();
                    switch (statusCode){
                        case 404:
                            Toast.makeText(MainActivity.this, "Your request cannot be found", Toast.LENGTH_SHORT).show();
                            break;
                        case 408:
                            Toast.makeText(MainActivity.this, "Your request has timed out", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(MainActivity.this, "Something's wrong with the server", Toast.LENGTH_SHORT).show();
                            break;
                        case 503:
                            Toast.makeText(MainActivity.this, "The service is unavailable", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Resturant>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
