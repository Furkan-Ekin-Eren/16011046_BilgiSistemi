package com.example.asdf;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ekran2 extends AppCompatActivity {
    TextView ad2, soyad2, Email2, telno2, kimlik2;
    ImageView fotokop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekran22);
        ad2 = findViewById(R.id.adT);
        soyad2 = findViewById(R.id.soyadT);
        Email2 = findViewById(R.id.EmailT);
        telno2 = findViewById(R.id.telNoT);
        kimlik2 = findViewById(R.id.kimliknoT);
        fotokop = findViewById(R.id.kullanıcıFoto);

        Bundle extras =getIntent().getExtras();
       // Bitmap bmp = (Bitmap) extras.getParcelable("imagebitmap");
        String[] dizi = extras.getStringArray("dizi");
        ad2.setText(dizi[0]);
        soyad2.setText(dizi[1]);
        Email2.setText(dizi[2]);
        telno2.setText(dizi[3]);
        kimlik2.setText(dizi[4]);
       // fotokop.setImageBitmap(bmp);


    }

    public void sendMail(View v){
        if (v.getId() == R.id.mailAt) {
            String recipientList = Email2.getText().toString();
            String[] recipients = recipientList.split(",");

            String subject = "Mail konusu";
            String message = "Mail içeriği";

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_EMAIL, recipients);
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, message);

            intent.setType("message/rfc822");
            startActivity(Intent.createChooser(intent, "Choose an email client"));
        }
    }

    public void aramaYap(View v) {
        if (v.getId() == R.id.Ara) {
            final int REQUEST_PHONE_CALL = 1;
            Intent makeCall = new Intent(Intent.ACTION_CALL);
            makeCall.setData(Uri.parse("tel:" + telno2.getText().toString()));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (ContextCompat.checkSelfPermission(ekran2.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ekran2.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_PHONE_CALL);
                } else {
                    startActivity(makeCall);
                }
            }

        }
    }

    public void Tikla2(View v) {
        if (v.getId() == R.id.dersler) {
            Intent istek = new Intent(getApplicationContext(), ekran3.class);
            startActivity(istek);
        }

    }


}
