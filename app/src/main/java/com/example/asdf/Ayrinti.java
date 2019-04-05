package com.example.asdf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Ayrinti extends AppCompatActivity {
    TextView aAD,aNot,aSay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayrinti);
        Intent gel = getIntent();
        String[] diz= gel.getStringArrayExtra("dizi");
        aAD=findViewById(R.id.ayAd);
        aNot=findViewById(R.id.ayNot);
        aSay=findViewById(R.id.aySay);

        aAD.setText(diz[0]);
        aNot.setText("Not Ortalaması:"+diz[1]);
        aSay.setText("Ögrenci Sayısı:"+diz[2]);
    }
}
