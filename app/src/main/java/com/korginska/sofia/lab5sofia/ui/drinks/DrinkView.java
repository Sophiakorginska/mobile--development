package com.korginska.sofia.lab5sofia.ui.drinks;

import com.korginska.sofia.lab5sofia.model.Drink;
import com.korginska.sofia.lab5sofia.mvp.BaseView;

import java.util.List;

public interface DrinkView extends BaseView {
    void showDrinks(List<Drink> drinks);

    void showNoData();
}
