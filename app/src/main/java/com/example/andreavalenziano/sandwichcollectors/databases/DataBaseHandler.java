package com.example.andreavalenziano.sandwichcollectors.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.andreavalenziano.sandwichcollectors.models.Figurina;
import com.example.andreavalenziano.sandwichcollectors.models.Squadra;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by AndreaValenziano on 08/03/17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    //figurine columns names
    private static final String KEY_ID_FIG = "id_figurina";
    private static final String KEY_NUM_FIGURINA = "num_figurina";
    private static final String KEY_NAME = "name";
    private static final String KEY_QTY = "quantity";
    private static final String KEY_SECTION = "section";

    //teams columns names
    private static final String KEY_ID_TEAM = "id_team";
    private static final String KEY_NAME_TEAM = "name_team";


    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 9;

    // Database Name
    private static final String DATABASE_NAME = "collectors";

    //  tables's names
    private static final String TABLE_FIGURINE = "figurina";
    private static final String TABLE_TEAMS = "team";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*String CREATE_FIGURINE_TABLE = "CREATE TABLE " + TABLE_FIGURINE + "("
                + KEY_ID_FIG + " INTEGER PRIMARY KEY," + KEY_NUM_FIGURINA + " INTEGER,"
                + KEY_NAME + " TEXT, " + KEY_QTY + " INTEGER, " +
                " FOREIGN KEY"+"("+ KEY_ID_TEAM +") "+" REFERENCES "+TABLE_TEAMS+"("+KEY_ID_TEAM+"), "
                + KEY_SECTION + " TEXT" +  ")";
        db.execSQL(CREATE_FIGURINE_TABLE);


        String CREATE_TEAMS_TABLE = "CREATE TABLE " + TABLE_TEAMS + "("
                + KEY_ID_TEAM + " INTEGER PRIMARY KEY," + KEY_NAME_TEAM + " TEXT" +")";*/
        Log.d(TAG, "ON CREATE DATABSE");

        String CREATE_TEAM =
                "CREATE TABLE team (\n" +
                        "\t`id_team`\tINTEGER PRIMARY KEY ,\n" +
                        "\t`name_team`\tTEXT\n" +
                        ");\n";
        String INSERT_TEAMS =
                "INSERT INTO team (id_team,name_team) VALUES (1,'Milan'),\n" +
                        " (2,'Juventus');\n";
        String CREATE_FIGURINA = "CREATE TABLE figurina (\n" +
                "\t`id_figurina`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`num_figurina`\tINTEGER,\n" +
                "\t`name`\tTEXT,\n" +
                "\t`quantity`\tINTEGER,\n" +
                "\t`section`\tTEXT,\n" +
                "\t`id_team`\tINTEGER,\n" +
                "\tFOREIGN KEY(`id_team`) REFERENCES Teams(id_team)\n" +
                ");\n";
        String INSERT_FIGURINE =
                "INSERT INTO figurina (id_figurina,num_figurina,name,quantity,section,id_team) VALUES (1,1,'Donnarumma',0,'Serie A',1),\n" +
                        " (2,2,'Bonaventura',0,'Serie A',1),\n" +
                        " (3,3,'Deulofeu',0,'Serie A',1),\n" +
                        " (4,4,'Buffon',0,'Serie A',2),\n" +
                        " (5,5,'Bonucci',0,'Serie A',2),\n" +
                        " (6,6,'Higuain',0,'Serie A',2);";
        try {
            db.execSQL(CREATE_TEAM);
            db.execSQL(INSERT_TEAMS);
            db.execSQL(CREATE_FIGURINA);
            db.execSQL(INSERT_FIGURINE);

        } catch (SQLException s) {
            Log.d(TAG, "EXCEPTION: " + s.getMessage());

        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //  Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FIGURINE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TEAMS);
        // Create tables again
        onCreate(db);
    }

    //READ OPERATIONS
    public ArrayList<Figurina> getAllFigurine() {
        ArrayList<Figurina> figArrayListList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT * FROM figurina, team WHERE figurina.id_team=team.id_team";
        //  String selectQuery = "SELECT * FROM figurina";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Figurina fig = new Figurina();
                Squadra squadra = new Squadra();
                fig.setIdFigurina(Integer.parseInt(cursor.getString(0)));
                fig.setNumFigurina(cursor.getInt(1));
                fig.setNome(cursor.getString(2));
                fig.setQuantita(cursor.getInt(3));
                fig.setSezione(cursor.getString(4));
                squadra.setIdSquadra(cursor.getInt(6));
                squadra.setNomeSquadra(cursor.getString(7));
                fig.setSquadra(squadra);

                figArrayListList.add(fig);
            } while (cursor.moveToNext());
        }
        db.close();


        // return notes list
        return figArrayListList;
    }

    //UPDATE QTY

    public int updateQty(Figurina fig) {


        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QTY, fig.getQuantita());
        int up = db.update(TABLE_FIGURINE, values, KEY_ID_FIG + " = ?",
                new String[]{String.valueOf(fig.getIdFigurina())});

        db.close();
        return up;

    }




}
