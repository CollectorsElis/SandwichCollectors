package com.example.andreavalenziano.sandwichcollectors.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.andreavalenziano.sandwichcollectors.R;
import com.example.andreavalenziano.sandwichcollectors.adapters.FigurAdapter;
import com.example.andreavalenziano.sandwichcollectors.models.Figurina;

import java.util.ArrayList;

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

        figuListRV = (RecyclerView) findViewById(R.id.figu_list_rv);
        layoutManager = new LinearLayoutManager(this);
        figurAdapter = new FigurAdapter();

        figuListRV.setLayoutManager(layoutManager);
        figuListRV.setAdapter(figurAdapter);


        figurAdapter.setDataSet(getElencoProva());
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

    public ArrayList getElencoProva() {
        ArrayList<Figurina> elencoProva = new ArrayList<>();
        elencoProva.add(new Figurina(1, "Donnarumma"));
        elencoProva.add(new Figurina(2, "Romagnoli"));
        elencoProva.add(new Figurina(3, "Paletta"));
        elencoProva.add(new Figurina(4, "De Sciglio"));
        elencoProva.add(new Figurina(5, "Abate"));
        elencoProva.add(new Figurina(6, "Locatelli"));
        elencoProva.add(new Figurina(7, "Sosa"));
        elencoProva.add(new Figurina(8, "Pasalic"));
        elencoProva.add(new Figurina(9, "Bonaventura"));
        elencoProva.add(new Figurina(10, "Deulofeu"));
        elencoProva.add(new Figurina(11, "Bacca"));
        elencoProva.add(new Figurina(12, "Suso"));
        elencoProva.add(new Figurina(13, "lapadula"));
        return elencoProva;
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
