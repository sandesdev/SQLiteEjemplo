package com.example.sqlite_ejemplo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.security.KeyStore;

public class DeveloperuBD extends SQLiteOpenHelper {
    private static final String Nombre_BD="developerubd.bd";
    private static final int Version_BD=1;
    private static final String TABLA_CURSOS="CREATE TABLE CURSOS(CODIGO INTEGER PRIMARY KEY ,CURSO TEXT,CARRERA TEXT)";

    public DeveloperuBD(Context context) {
        super(context, Nombre_BD, null, Version_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_CURSOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS '" + TABLA_CURSOS + "'");
        sqLiteDatabase.execSQL(TABLA_CURSOS);
    }
    public void agregarCursos(String codigo,String curso,String carrera)
    {
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null)
        {
            bd.execSQL("INSERT INTO CURSOS VALUES('"+codigo+"','"+curso+"','"+carrera+"')");
            bd.close();
        }
    }
}
