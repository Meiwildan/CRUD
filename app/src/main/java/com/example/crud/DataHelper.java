package com.example.crud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "perpustakaan.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper (Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "Create table perpustakaan(editnama text null, editjudulbuku text null, namapengarang text null, edittahun integer primary key, editjenisbuku text null, editpinjam integer primary key);";
        Log.d("Data", "onCreate: "+sql);
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db0, int db1, int db2){

    }
}
