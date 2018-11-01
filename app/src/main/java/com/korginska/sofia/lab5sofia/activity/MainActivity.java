package com.korginska.sofia.lab5sofia.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.korginska.sofia.lab5sofia.DrinkInterface;
import com.korginska.sofia.lab5sofia.R;
import com.korginska.sofia.lab5sofia.model.Drink;
import com.korginska.sofia.lab5sofia.model.Example;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;
    private DrinkInterface drinkInterface;
    private Call<Example> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.image_view);
        initRetrofit();
        getDrinks();
    }

    private void initRetrofit() {
        Log.i("TAG", "init retrofit");
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://www.thecocktaildb.com")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        drinkInterface = retrofit.create(DrinkInterface.class);
    }

    private void getDrinks() {
        call = drinkInterface.imageOfAlcohol();
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.i("TAG", "Get" + response.body().toString());
                Example example = response.body();
                List<Drink> drinkList = example.getDrinks();
                for (Drink drink : drinkList) {
                    Log.i("TAG", drink.getStrDrinkThumb());
                    Picasso.get()
                            .load(drink.getStrDrinkThumb())
                            .into(mImageView);

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.i("TAG", "error: " + t.toString());
            }
        });
    }


}
