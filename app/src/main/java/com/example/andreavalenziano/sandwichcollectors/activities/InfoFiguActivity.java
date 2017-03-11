package com.example.andreavalenziano.sandwichcollectors.activities;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.andreavalenziano.sandwichcollectors.R;

/**
 * Created by AndreaValenziano on 10/03/17.
 */

public class InfoFiguActivity extends AppCompatActivity {

    Button salvaBtn;
    TextView numeroFigurinaTV, nomeFigurinaTV, squadraTV;
    EditText quantitaET;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_figu);

        salvaBtn = (Button) findViewById(R.id.salva_btn);
        numeroFigurinaTV = (TextView) findViewById(R.id.empty_num_fig_tv_);
        nomeFigurinaTV = (TextView) findViewById(R.id.nome_figurina_tv);
        squadraTV = (TextView) findViewById(R.id.squadra_tv);
        quantitaET = (EditText) findViewById(R.id.empty_qty_et);
        intent = getIntent();
        numeroFigurinaTV.setText(String.valueOf(intent.getIntExtra(MainActivity.NUM_FIG, 0)));
        nomeFigurinaTV.setText(intent.getStringExtra(MainActivity.NOME_FIG));
        squadraTV.setText(intent.getStringExtra(MainActivity.SQUADRA));
        quantitaET.setText(String.valueOf(intent.getIntExtra(MainActivity.QTY, 0)));

        salvaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int qty = Integer.parseInt(quantitaET.getText().toString());
                int index = intent.getIntExtra(MainActivity.INDEX, 0);
                Intent ris = new Intent();
                ris.putExtra(MainActivity.QTY, qty);
                ris.putExtra(MainActivity.INDEX, index);
                Log.d(ContentValues.TAG, "SET RESULT");
                setResult(Activity.RESULT_OK, ris);
                finish();
            }
        });


    }
}
