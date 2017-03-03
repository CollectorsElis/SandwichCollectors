package com.example.andreavalenziano.sandwichcollectors.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.andreavalenziano.sandwichcollectors.R;

import static android.content.ContentValues.TAG;

/**
 * Created by AndreaValenziano on 02/03/17.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button toListBtn, toChargeAreaBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toListBtn = (Button) findViewById(R.id.to_list_btn);
        toChargeAreaBtn = (Button) findViewById(R.id.to_change_area_btn);

        toListBtn.setOnClickListener(this);
        toChargeAreaBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (toListBtn != null && v.getId() == R.id.to_list_btn) {
            startActivity(new Intent(MainActivity.this, FiguListActivity.class));
        }
        if (toChargeAreaBtn != null && v.getId() == R.id.to_change_area_btn) {
            //go to change area activity

        }
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
