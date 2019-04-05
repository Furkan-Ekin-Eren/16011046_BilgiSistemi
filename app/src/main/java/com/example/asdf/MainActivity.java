package com.example.asdf;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
    EditText ad,soyad,Emaill,Telno,kimlik;
    Button kaydet,temizle;
    ImageView foto;
    Uri imageUri;
    private static final int PICK_IMAGE=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ad=findViewById(R.id.Adtext);
        soyad=findViewById(R.id.SoyAdText);
        Emaill=findViewById(R.id.EmailText);
        Telno=findViewById(R.id.TelefonText);
        kimlik=findViewById(R.id.KimlikText);
        kaydet=findViewById(R.id.kaydet);
        temizle=findViewById(R.id.temizle);
        foto=findViewById(R.id.kullanıcıFoto);

        temizle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ad.setText("");
                soyad.setText("");
                Emaill.setText("");
                Telno.setText("");
                kimlik.setText("");

            }
        });

        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resimSec();
            }
        });
    }


    private void resimSec(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery,PICK_IMAGE);
    }


    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            foto.setImageURI(imageUri);
        }
    }

    public void kaydetyol(View v){

        Intent istek=new Intent(getApplicationContext(),ekran2.class);
        String[] dizi={ad.getText().toString(),soyad.getText().toString(),Emaill.getText().toString(),Telno.getText().toString(),kimlik.getText().toString()};

        //foto.buildDrawingCache();
        //Bitmap image=foto.getDrawingCache();
        Bundle extras = new Bundle();
        //extras.putParcelable("imagebitmap",image);
        extras.putStringArray("dizi",dizi);
        istek.putExtras(extras);
        if(dizi[0].length()==0 || dizi[1].length()==0 || dizi[2].length()==0 || dizi[3].length()==0 || dizi[4].length()==0 ){
            Toast.makeText(getApplicationContext(),"Lütfen tüm alanları doldurunuz.",Toast.LENGTH_SHORT).show();
        }else if(dizi[4].length()!=11)
        {
            Toast.makeText(getApplicationContext(),"T.C 11 haneli olmalı",Toast.LENGTH_SHORT).show();
        }
        else{startActivity(istek);
        }

    }

}
