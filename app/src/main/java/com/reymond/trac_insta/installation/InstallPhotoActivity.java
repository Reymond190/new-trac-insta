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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.reymond.trac_insta.HomeActivity;
import com.reymond.trac_insta.R;
import com.reymond.trac_insta.service.ServiceimageActivity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class InstallPhotoActivity extends AppCompatActivity {
    Button send1,send2,send3,send4,send5;
    Bitmap thumbnail,thumbnail1,thumbnail2,thumbnail3,thumbnail4;
    File pic,pic1,pic2,pic3,pic4;
    EditText address, subject, emailtext;
    protected static final int CAMERA_PIC_REQUEST = 0,CAMERA_PIC_REQUEST1 = 1,CAMERA_PIC_REQUEST2= 2,CAMERA_PIC_REQUEST3 = 3,CAMERA_PIC_REQUEST4 = 4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide(); // hide the title bar3
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_install_photo);


        send1=(Button) findViewById(R.id.send1);
        send2=(Button) findViewById(R.id.send2);
        send3=(Button) findViewById(R.id.send3);
        send4=(Button) findViewById(R.id.send4);
        send5=(Button) findViewById(R.id.send5);


        Button camera = (Button) findViewById(R.id.btnChoose);
        camera.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0){
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);

            }
        });




        Button camera1 = (Button) findViewById(R.id.btnChoose1);
        camera1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0){
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST1);

            }
        });




        Button camera2 = (Button) findViewById(R.id.btnChoose2);
        camera2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0){
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST2);

            }
        });


        Button camera3 = (Button) findViewById(R.id.btnChoose3);
        camera3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0){
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST3);

            }
        });




        Button camera4 = (Button) findViewById(R.id.btnChoose4);
        camera4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0){
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST4);

            }
        });



        send1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){

                Intent i = new Intent(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"abhiraj@tracalogic.com"});
                i.putExtra(Intent.EXTRA_SUBJECT,"Vehicle Photos");
                //Log.d("URI@!@#!#!@##!", Uri.fromFile(pic).toString() + "   " + pic.exists());
                i.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(pic));
                send1.setVisibility(v.INVISIBLE);

                i.setType("image/png");
                startActivity(Intent.createChooser(i,"Share you on the jobing"));

            }

        });

        send2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){

                Intent i = new Intent(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"abhiraj@tracalogic.com"});
                i.putExtra(Intent.EXTRA_SUBJECT,"Vehicle Photos");
                //Log.d("URI@!@#!#!@##!", Uri.fromFile(pic).toString() + "   " + pic.exists());
                i.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(pic1));
                send2.setVisibility(v.INVISIBLE);

                i.setType("image/png");
                startActivity(Intent.createChooser(i,"Share you on the jobing"));

            }

        });
        send3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){

                Intent i = new Intent(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"abhiraj@tracalogic.com"});
                i.putExtra(Intent.EXTRA_SUBJECT,"Vehicle Photos");
                //Log.d("URI@!@#!#!@##!", Uri.fromFile(pic).toString() + "   " + pic.exists());
                i.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(pic2));
                send3.setVisibility(v.INVISIBLE);

                i.setType("image/png");
                startActivity(Intent.createChooser(i,"Share you on the jobing"));

            }

        });

        send4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){

                Intent i = new Intent(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"abhiraj@tracalogic.com"});
                i.putExtra(Intent.EXTRA_SUBJECT,"Vehicle Photos");
                //Log.d("URI@!@#!#!@##!", Uri.fromFile(pic).toString() + "   " + pic.exists());
                i.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(pic3));
                send4.setVisibility(v.INVISIBLE);

                i.setType("image/png");
                startActivity(Intent.createChooser(i,"Share you on the jobing"));

            }

        });

        send5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){

                Intent i = new Intent(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"abhiraj@tracalogic.com"});
                i.putExtra(Intent.EXTRA_SUBJECT,"Vehicle Photos");
                //Log.d("URI@!@#!#!@##!", Uri.fromFile(pic).toString() + "   " + pic.exists());
                i.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(pic4));
                send5.setVisibility(v.INVISIBLE);

                i.setType("image/png");
                startActivity(Intent.createChooser(i,"Share you on the jobing"));
            }
        });
    }





    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_PIC_REQUEST) {
            thumbnail = (Bitmap) data.getExtras().get("data");
            ImageView image = (ImageView) findViewById(R.id.vehicle_photo);
            image.setImageBitmap(thumbnail);


            try {
                File root = Environment.getExternalStorageDirectory();
                if (root.canWrite()) {
                    pic = new File(root, "pic.png");
                    FileOutputStream out = new FileOutputStream(pic);
                    thumbnail.compress(Bitmap.CompressFormat.PNG, 100, out);
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                Log.e("BROKEN", "Could not write file " + e.getMessage());
            }

        }



        if (requestCode == CAMERA_PIC_REQUEST1) {
            thumbnail1 = (Bitmap) data.getExtras().get("data");
            ImageView image1 = (ImageView) findViewById(R.id.vehicle_photo1);
            image1.setImageBitmap(thumbnail1);


            try {
                File root = Environment.getExternalStorageDirectory();
                if (root.canWrite()) {
                    pic1 = new File(root, "pic1.png");
                    FileOutputStream out1 = new FileOutputStream(pic1);
                    thumbnail1.compress(Bitmap.CompressFormat.PNG, 100, out1);
                    out1.flush();
                    out1.close();
                }
            } catch (IOException e) {
                Log.e("BROKEN", "Could not write file " + e.getMessage());
            }
        }


        if (requestCode == CAMERA_PIC_REQUEST2) {
            thumbnail2 = (Bitmap) data.getExtras().get("data");
            ImageView image2 = (ImageView) findViewById(R.id.vehicle_photo2);
            image2.setImageBitmap(thumbnail2);


            try {
                File root = Environment.getExternalStorageDirectory();
                if (root.canWrite()) {
                    pic2= new File(root, "pic2.png");
                    FileOutputStream out2 = new FileOutputStream(pic2);
                    thumbnail2.compress(Bitmap.CompressFormat.PNG, 100, out2);
                    out2.flush();
                    out2.close();
                }
            } catch (IOException e) {
                Log.e("BROKEN", "Could not write file " + e.getMessage());
            }
        }


        if (requestCode == CAMERA_PIC_REQUEST3) {
            thumbnail3 = (Bitmap) data.getExtras().get("data");
            ImageView image3 = (ImageView) findViewById(R.id.vehicle_photo3);
            image3.setImageBitmap(thumbnail3);


            try {
                File root = Environment.getExternalStorageDirectory();
                if (root.canWrite()) {
                    pic3 = new File(root, "pic3.png");
                    FileOutputStream out3 = new FileOutputStream(pic3);
                    thumbnail3.compress(Bitmap.CompressFormat.PNG, 100, out3);
                    out3.flush();
                    out3.close();
                }
            } catch (IOException e) {
                Log.e("BROKEN", "Could not write file " + e.getMessage());
            }
        }


        if (requestCode == CAMERA_PIC_REQUEST4) {
            // Activity.RESULT_OK

            thumbnail4 = (Bitmap) data.getExtras().get("data");
            ImageView image4 = (ImageView) findViewById(R.id.vehicle_photo4);
            image4.setImageBitmap(thumbnail4);


            try {
                File root = Environment.getExternalStorageDirectory();
                if (root.canWrite()) {
                    pic4 = new File(root, "pic4.png");
                    FileOutputStream out4 = new FileOutputStream(pic4);
                    thumbnail4.compress(Bitmap.CompressFormat.PNG, 100, out4);
                    out4.flush();
                    out4.close();
                }
            } catch (IOException e) {
                Log.e("BROKEN", "Could not write file " + e.getMessage());
            }
        }



    }


    public void backbutton(View view) {
        Intent intent = new Intent(InstallPhotoActivity.this,HomeActivity.class);
        startActivity(intent);
    }

}
