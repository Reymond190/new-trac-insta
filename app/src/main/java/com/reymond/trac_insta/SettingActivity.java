package com.reymond.trac_insta;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.reymond.trac_insta.admin.Admin_authentication;

import java.util.Objects;

public class SettingActivity extends AppCompatActivity {
    ImageButton buttonn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide(); // hide the title bar3
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_setting);


        Button pdfbutton = findViewById(R.id.CreatepdfButton);
        pdfbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, pdf_activity.class);
                startActivity(intent);
            }
        });


        Button button = (Button)findViewById(R.id.LogoutButton);
        // set corner radius value
        // Implement onClickListener event on CardView
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View.OnClickListener context = this;
                Intent intent = new Intent(SettingActivity.this, LogoutActivity.class);
                startActivity(intent);

            }
        });



        Button button1 = (Button)findViewById(R.id.AdminButton);
        // set corner radius value
        // Implement onClickListener event on CardView
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View.OnClickListener context = this;
                Intent intent = new Intent(SettingActivity.this, Admin_authentication.class);
                startActivity(intent);

            }
        });


        buttonn = findViewById(R.id.SettingBack);



        buttonn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(i);
            }

        });








    }
}
