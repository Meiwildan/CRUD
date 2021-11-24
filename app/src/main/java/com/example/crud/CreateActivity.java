package com.example.crud;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateActivity extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dataHelper;
    Button btn_simpan;
    EditText editnama, editjudulbuku, namapengarang, edittahun, editjenisbuku, editpinjam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        dataHelper = new DataHelper(this);
        editnama = findViewById(R.id.editnama);
        editjudulbuku = findViewById(R.id.editjudulbuku);
        namapengarang = findViewById(R.id.namapengarang);
        edittahun = findViewById(R.id.edittahun);
        editjenisbuku = findViewById(R.id.editjenisbuku);
        editpinjam = findViewById(R.id.editpinjam);
        btn_simpan = findViewById(R.id.btn_simpan);
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dataHelper.getWritableDatabase();
                db.execSQL("insert into perpustakaan(editnama, editjudulbuku, namapengarang, edittahun, editjenisbuku, editpinjam) values('" +
                        editnama.getText().toString() + "','" +
                        editjudulbuku.getText().toString() + "','" +
                        namapengarang.getText().toString() + "','" +
                        edittahun.getText().toString() + "','" +
                        editjenisbuku.getText().toString() + "','" +
                        editpinjam.getText().toString() + "','')");
                Toast.makeText(CreateActivity.this, "Buku Tersimpan", Toast.LENGTH_SHORT).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
    }
}
