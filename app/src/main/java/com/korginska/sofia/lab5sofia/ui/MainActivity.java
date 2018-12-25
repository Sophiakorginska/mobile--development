package com.korginska.sofia.lab5sofia.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.korginska.sofia.lab5sofia.R;
import com.korginska.sofia.lab5sofia.ui.drinks.ListOfDrinksFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Router router = new Router(this, R.id.fragmentContainer);
        router.replaceFragment(new ListOfDrinksFragment());
    }


}
