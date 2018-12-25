package com.korginska.sofia.lab5sofia.ui.drinks;

import com.korginska.sofia.lab5sofia.data.api.DrinkNetworkModel;
import com.korginska.sofia.lab5sofia.model.Drink;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class DrinksPresenter {

    private DrinkNetworkModel drinkNetworkModel = new DrinkNetworkModel();

    private DrinkView drinkView;

    public DrinksPresenter(DrinkView drinkView) {
        this.drinkView = drinkView;
    }

    public void getDrinks() {
        drinkView.showLoading();
        drinkNetworkModel.getDrinks()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Drink>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Drink> drinks) {
                        drinkView.showDrinks(drinks);
                        drinkView.hideLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        drinkView.showNoData();
                        drinkView.hideLoading();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
