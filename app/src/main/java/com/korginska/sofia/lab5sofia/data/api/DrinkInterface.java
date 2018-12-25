package com.korginska.sofia.lab5sofia.data.api;

import com.korginska.sofia.lab5sofia.model.Example;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface DrinkInterface {
    @GET("/api/json/v1/1/search.php?s=margarita")
    public Observable<Example> imageOfAlcohol();
}
