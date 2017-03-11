package com.example.andreavalenziano.sandwichcollectors.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.andreavalenziano.sandwichcollectors.databases.DatabaseHandler;

/**
 * Created by AndreaValenziano on 11/03/17.
 */

public class ListaCeloActivity extends FiguListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        dbHandler = new DatabaseHandler(this);
        figurAdapter.setDataSet(dbHandler.getFigurinePossedute());


    }
}
