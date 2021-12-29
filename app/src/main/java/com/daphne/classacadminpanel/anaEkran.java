package com.daphne.classacadminpanel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class anaEkran extends AppCompatActivity {
    private Button urunEkle;
    private Button cikis;
    private SharedPreferences sp;
    private SharedPreferences editor;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_ekran);

        urunEkle=(Button)findViewById(R.id.urunEkle);
        cikis = (Button)findViewById(R.id.cikis);

        sp = getSharedPreferences("GirisBilgi", MODE_PRIVATE);


        urunEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(anaEkran.this,urunEkran.class));
            }

        });

        cikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(anaEkran.this,MainActivity.class));
            }
        });
    }
}