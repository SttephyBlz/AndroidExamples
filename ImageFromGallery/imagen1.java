package com.example.jjsingh.abonapp.asd;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.jjsingh.abonapp.R;
import com.example.jjsingh.abonapp.Util.App;
import com.example.jjsingh.abonapp.Util.Base64BitmapUtil;

public class imagen1 extends AppCompatActivity {
    ImageView imagen1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen1);

        imagen1 = (ImageView) findViewById(R.id.imagen1);

        //get from realm
        imagenes img =  App.getRealm().where(imagenes.class).findFirst();

        //decode img from realm
        Bitmap bitmap1 = Base64BitmapUtil.decodeBase64(img.getImagen());

        //set on imgview
        imagen1.setImageBitmap(bitmap1);
    }
}
