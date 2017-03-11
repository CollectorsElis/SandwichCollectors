package com.example.andreavalenziano.sandwichcollectors.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;

import com.example.andreavalenziano.sandwichcollectors.R;
import com.example.andreavalenziano.sandwichcollectors.adapters.FigurAdapter;
import com.example.andreavalenziano.sandwichcollectors.databases.DatabaseHandler;
import com.example.andreavalenziano.sandwichcollectors.utilities.Utility;

/**
 * Created by AndreaValenziano on 11/03/17.
 */

public class ListaMancantiActivity extends FiguListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        dbHandler = new DatabaseHandler(this);
        figurAdapter.setDataSet(dbHandler.getFigurineMancanti());


    }
}
