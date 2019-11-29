package com.example.ultimaprueba;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLDataException;

public class Inscripciones extends SQLiteOpenHelper {

    private static final String NOMBRE_BD = "Inscripciones.bd";
    private static final int VERSION_BD = 1;
    private static final String TABLA_RAMOS = "CREATE TABLE RAMOS(USUARIOS TEXT PRIMARY KEY, RAMOS TEXT, PROFESION TEXT)";

    public Inscripciones(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(TABLA_RAMOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLA_RAMOS);
        sqLiteDatabase.execSQL(TABLA_RAMOS);
    }

    public void agregarCursos(String usuarios, String ramos, String profesion){
        SQLiteDatabase bd = getWritableDatabase();
        if(bd!=null){
            bd.execSQL("INSERT INTO RAMOS VALUES ('"+usuarios+"','"+ramos+"','"+profesion+"')");
            bd.close();
        }

    }
}