package com.example.crud;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dataHelper;
    Button btn_simpan;
    TextView editnama, editjudulbuku, namapengarang, edittahun, editjenisbuku, editpinjam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        dataHelper = new DataHelper(this);
        editnama = findViewById(R.id.editnama);
        editjudulbuku = findViewById(R.id.editjudulbuku);
        namapengarang = findViewById(R.id.namapengarang);
        edittahun = findViewById(R.id.edittahun);
        editjenisbuku = findViewById(R.id.editjenisbuku);
        editpinjam = findViewById(R.id.editpinjam);
        btn_simpan = findViewById(R.id.btn_simpan);

        SQLiteDatabase db = dataHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM perpustakaan WHERE editnama= '" +
                getIntent().getStringExtra("editnama")+"'", null);
        cursor.moveToFirst();
        if(cursor.getCount() >0){
            cursor.moveToPosition(0);
            editnama.setText(cursor.getString(0).toString());
            editjudulbuku.setText(cursor.getString(1).toString());
            namapengarang.setText(cursor.getString(2).toString());
            edittahun.setText(cursor.getString(3).toString());
            editjenisbuku.setText(cursor.getString(4).toString());
            editpinjam.setText(cursor.getString(5).toString());

        }
    }
}
