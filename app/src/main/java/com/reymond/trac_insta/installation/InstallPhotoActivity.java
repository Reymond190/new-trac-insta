package com.reymond.trac_insta.installation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.reymond.trac_insta.HomeActivity;
import com.reymond.trac_insta.R;
import com.reymond.trac_insta.service.ServiceimageActivity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class InstallPhotoActivity extends AppCompatActivity {
    int TAKE_PHOTO_CODE = 0;
    public static int count = 0;
    Button btnChoose, btnChoose1, btnChoose2, btnChoose3, btnChoose4, submit;
    ImageView imageView, imageView1, imageView2, imageView3, imageView4;
    private static final int CAMERA_REQUEST = 1888,CAMERA_REQUEST1 = 1999,CAMERA_REQUEST2 = 1777,CAMERA_REQUEST3 = 1666,CAMERA_REQUEST4 = 1555;

    private static final int MY_CAMERA_PERMISSION_CODE = 100,MY_CAMERA_PERMISSION_CODE1 = 200,MY_CAMERA_PERMISSION_CODE2 = 300,MY_CAMERA_PERMISSION_CODE3 = 400,MY_CAMERA_PERMISSION_CODE4 = 500;

    public  static final int RequestPermissionCode  = 1 ;
    Intent intent ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide(); // hide the title bar3
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_install_photo);


        Button btnChoose = (Button) findViewById(R.id.btnChoose);
        Button btnChoose1 = (Button) findViewById(R.id.btnChoose1);
        Button btnChoose2 = (Button) findViewById(R.id.btnChoose2);
        Button btnChoose3 = (Button) findViewById(R.id.btnChoose3);
        Button btnChoose4 = (Button) findViewById(R.id.btnChoose4);
        imageView = findViewById(R.id.vehicle_photo);
        imageView1 = findViewById(R.id.vehicle_photo1);
        imageView2 = findViewById(R.id.vehicle_photo2);
        imageView3 = findViewById(R.id.vehicle_photo3);
        imageView4 = findViewById(R.id.vehicle_photo4);

        Button submit = (Button) findViewById(R.id.signup);
        EnableRuntimePermission();





        submit.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                // TODO:
                // This function closes Activity Two
                // Hint: use Context's finish() method

                Toast.makeText(InstallPhotoActivity.this, "Submitted successfully", Toast.LENGTH_SHORT).show();
                finish();

            }
        });

        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
                {
                    intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                    startActivityForResult(intent, 7);

                }
        });
        btnChoose1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(intent, 6);

            }
        });
        btnChoose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(intent, 8);

            }
        });
        btnChoose3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(intent, 9);

            }
        });
        btnChoose4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(intent, 10);

            }
        });
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 7 && resultCode == RESULT_OK) {

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

            imageView.setImageBitmap(bitmap);
        }
        if (requestCode == 6 && resultCode == RESULT_OK) {

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

            imageView1.setImageBitmap(bitmap);
        }
        if (requestCode == 8 && resultCode == RESULT_OK) {

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

            imageView2.setImageBitmap(bitmap);
        }
        if (requestCode == 9 && resultCode == RESULT_OK) {

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

            imageView3.setImageBitmap(bitmap);
        }
        if (requestCode == 10 && resultCode == RESULT_OK) {

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

            imageView4.setImageBitmap(bitmap);
        }
    }

    public void EnableRuntimePermission(){

        if (ActivityCompat.shouldShowRequestPermissionRationale(InstallPhotoActivity.this,
                Manifest.permission.CAMERA))
        {

            Toast.makeText(InstallPhotoActivity.this,"CAMERA permission allows us to Access CAMERA app", Toast.LENGTH_LONG).show();

        } else {

            ActivityCompat.requestPermissions(InstallPhotoActivity.this,new String[]{
                    Manifest.permission.CAMERA}, RequestPermissionCode);

        }
    }

    @Override
    public void onRequestPermissionsResult(int RC, String per[], int[] PResult) {

        switch (RC) {

            case RequestPermissionCode:

                if (PResult.length > 0 && PResult[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(InstallPhotoActivity.this,"Permission Granted, Now your application can access CAMERA.", Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(InstallPhotoActivity.this,"Permission Canceled, Now your application cannot access CAMERA.", Toast.LENGTH_LONG).show();

                }
                break;
        }
    }
    public void backbutton(View view) {
        Intent intent = new Intent(InstallPhotoActivity.this,HomeActivity.class);
        startActivity(intent);
    }

}

