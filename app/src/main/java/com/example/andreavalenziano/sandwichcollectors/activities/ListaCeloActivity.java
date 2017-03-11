package com.example.andreavalenziano.sandwichcollectors.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.andreavalenziano.sandwichcollectors.R;
import com.example.andreavalenziano.sandwichcollectors.databases.DatabaseHandler;
import com.example.andreavalenziano.sandwichcollectors.models.Figurina;

import static android.content.ContentValues.TAG;

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "ON ACTIVITY RESULT");
        if (requestCode == MainActivity.REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            int qty = data.getIntExtra(MainActivity.QTY, 0);
            int index = data.getIntExtra(MainActivity.INDEX, 0);

            Figurina fig = figurAdapter.getFigurina(index);
            fig.setQuantita(qty);
            if (dbHandler.updateQty(fig) > 0) {

                snackbar = Snackbar.make(relativeLayout, R.string.updating_success, Snackbar.LENGTH_SHORT);
                figurAdapter.updateQty(fig, index);
                figurAdapter.setDataSet(dbHandler.getFigurinePossedute());
            } else {
                snackbar = Snackbar.make(relativeLayout, R.string.database_error, Snackbar.LENGTH_SHORT);
            }
            snackbar.show();

        }
    }
}
