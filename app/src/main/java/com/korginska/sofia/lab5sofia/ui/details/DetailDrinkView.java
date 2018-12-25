package com.korginska.sofia.lab5sofia.ui.details;

import android.content.Context;

import com.korginska.sofia.lab5sofia.model.Drink;

public interface DetailDrinkView {
    void isFavorite(Boolean isFavorite);

    Context getContext();

    Drink getDrink();
}
