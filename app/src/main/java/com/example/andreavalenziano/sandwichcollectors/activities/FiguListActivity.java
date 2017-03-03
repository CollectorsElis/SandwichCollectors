package com.example.andreavalenziano.sandwichcollectors.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.andreavalenziano.sandwichcollectors.R;
import com.example.andreavalenziano.sandwichcollectors.adapters.FigurAdapter;

import static android.content.ContentValues.TAG;

/**
 * Created by AndreaValenziano on 03/03/17.
 */
public class FiguListActivity extends AppCompatActivity {

    //recycler view items
    RecyclerView figuListRV;
    RecyclerView.LayoutManager layoutManager;
    FigurAdapter figurAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_figu_list);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");

    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
