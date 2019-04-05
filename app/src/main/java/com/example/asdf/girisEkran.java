package com.example.asdf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class girisEkran extends AppCompatActivity {
    EditText kullanıcıAdı,sifre;
    String kul="admin",sif="password";
    Button giris;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_ekran);
        kullanıcıAdı=findViewById(R.id.userName);
        sifre=findViewById(R.id.password);
        giris=findViewById(R.id.logIn);

        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                giril(kullanıcıAdı.getText().toString(),sifre.getText().toString());
            }
        });
    }


    private void giril(String kulad,String sifree){
        Intent istek=new Intent(getApplicationContext(),MainActivity.class);
        if( kulad.equals(kul) && sifree.equals(sif)){
            startActivity(istek);
        }
        else{
            Toast.makeText(getApplicationContext(),"Şifre veya Kullanıcı adı hatalı",Toast.LENGTH_SHORT).show();
        }
    }

}
