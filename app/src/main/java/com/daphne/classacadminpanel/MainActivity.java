package com.daphne.classacadminpanel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText userName,password;
    private Button giris;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName=(EditText) findViewById(R.id.userName);
        password=(EditText)findViewById(R.id.password);
        giris=(Button)findViewById(R.id.giris);

        sp = getSharedPreferences("GirisBilgi", MODE_PRIVATE);
        editor = sp.edit();

        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userName.getText().toString().equals("defnecetinerr")&& password.getText().toString().equals("9999")){
                    editor.putString("username",userName.getText().toString());
                    editor.putString("password",password.getText().toString());

                    startActivity(new Intent(MainActivity.this,anaEkran.class));

                } else{
                    Toast.makeText(getApplicationContext(),"hatalı giriş yaptınız",Toast.LENGTH_SHORT).show();

                }


            }
        });

    }
}