package com.example.jesusmartinez.alumnoscurseradapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jesusmartinez on 26/12/15.
 */
public class AlumnosDatabase extends SQLiteOpenHelper {

    static String TABLE_NAME="alumnos";
    static String BASE_NAME="infanteDB";
    static int VERSION=4;


    public AlumnosDatabase(Context context) {
        super(context, BASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" +
                " _id" + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre " + "TEXT, " +
                "grupo " + "TEXT );");

        ContentValues contentValues=new ContentValues();


        contentValues.put("nombre", "Luis");
        contentValues.put("grupo","Primero A");
        db.insert(TABLE_NAME, null, contentValues);


        contentValues.put("nombre", "Juan");
        contentValues.put("grupo", "Primero B");
        db.insert(TABLE_NAME, null, contentValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                if (oldVersion<newVersion) {
                    db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
                    onCreate(db);

                }

    }


    public void nuevoalumno (SQLiteDatabase database,String nombre,String grupo) {

        ContentValues contentValues=new ContentValues();
        contentValues.put("nombre",nombre);
        contentValues.put("grupo",grupo);
        database.insert(TABLE_NAME,null,contentValues);
        database.close();
    }
}
