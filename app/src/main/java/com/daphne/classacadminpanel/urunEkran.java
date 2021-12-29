package com.daphne.classacadminpanel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class urunEkran extends AppCompatActivity {

    private Button urunGiris;
    private Button imageSec;
    private EditText urunAdi,editTextNumber;
    private SharedPreferences sp;
    private SharedPreferences editor;
    public  ImageView urunResim;
    static final int SELECT_İMAGE=12;
    public Uri imageUri;
    String tanimla;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urun_ekran);

        urunGiris = (Button)findViewById(R.id.urunGiris);
        imageSec = (Button)findViewById(R.id.imageSec);
        urunAdi = (EditText)findViewById(R.id.urunAdi);
        editTextNumber = (EditText)findViewById(R.id.editTextNumber);
        urunResim= (ImageView)findViewById(R.id.urunResim);
        tanimla="";



        sp = getSharedPreferences("GirisBilgi", MODE_PRIVATE);

        imageSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,SELECT_İMAGE);

            }

        });

        urunGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tanimla = urunAdi.getText().toString();
                int fiyatTanimla = Integer.parseInt(editTextNumber.getText().toString());
                Intent intent = new Intent(urunEkran.this,bilgiEkran.class);
                intent.putExtra("urunIsim",tanimla);
                intent.putExtra("urunFiyat",fiyatTanimla);
                startActivity(intent);

            }
        });



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==12 && resultCode == RESULT_OK) {
           imageUri= data.getData();
           urunResim.setImageURI(imageUri);
            startActivity(new Intent(urunEkran.this,bilgiEkran.class));
        }
    }

}