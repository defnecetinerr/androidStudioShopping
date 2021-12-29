package com.daphne.classacadminpanel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class bilgiEkran extends AppCompatActivity {

    private TextView isimBilgi;
    private TextView fiyatBilgi;
    private ImageView resimSonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilgi_ekran);

        isimBilgi =(TextView)findViewById(R.id.isimBilgi);
        fiyatBilgi =(TextView)findViewById(R.id.fiyatBilgi);
        resimSonuc = (ImageView)findViewById(R.id.resimSonuc);

        Intent intent = getIntent();
        String tanimla = intent.getStringExtra("urunIsim");
        isimBilgi.setText(tanimla);

        int fiyatTanimla = intent.getIntExtra("urunFiyat",0);
        fiyatBilgi.setText(fiyatTanimla+"tl");






    }
}