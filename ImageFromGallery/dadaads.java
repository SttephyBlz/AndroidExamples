package com.example.jjsingh.abonapp.asd;


import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.jjsingh.abonapp.R;
import com.example.jjsingh.abonapp.Util.App;
import com.example.jjsingh.abonapp.Util.Base64BitmapUtil;

import java.io.IOException;

public class dadaads extends AppCompatActivity {
    ImageView imagenSeleccionada;
    String image;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dadaads);

        imagenSeleccionada = (ImageView) findViewById(R.id.seleccionada);

        imagenSeleccionada.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent galleryIntent = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, 1);
            }
        });

        b = (Button) findViewById(R.id.b);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(dadaads.this, imagen1.class));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK)
        {
            //Get URI of Image
            Uri imageUri = data.getData();
            try {
                //Get Bitmap of the image.
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);

                //Set the image on imageView
                imagenSeleccionada.setImageBitmap(bitmap);

                //Encode to save on realm
                image = Base64BitmapUtil.encodeToBase64(bitmap, Bitmap.CompressFormat.JPEG, 10);

                App.getRealm().beginTransaction();
                    imagenes img = new imagenes();
                    img.setImagen(image);

                    App.getRealm().copyToRealm(img);
                App.getRealm().commitTransaction();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
