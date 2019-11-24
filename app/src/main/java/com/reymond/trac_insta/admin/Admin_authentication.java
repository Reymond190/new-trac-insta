package com.reymond.trac_insta.admin;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.reymond.trac_insta.R;
import com.reymond.trac_insta.SettingActivity;


public class Admin_authentication extends AppCompatActivity {
    Button button;
    ImageButton buttonn;
    EditText edituser,editpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_admin_authentication);


        edituser = findViewById(R.id.EditUser);
        editpass = findViewById(R.id.EditPass);
        button = findViewById(R.id.buttonContinue);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = String.valueOf(edituser.getText());
                String p = String.valueOf(editpass.getText());
                if(s.equals("tracalogic") && p.equals("tracalogic@123"))
                {
                    ((global_vars) getApplication()).setSomeVariable("admin");
                    SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("key", "admin");
                    editor.apply();
                    Toast.makeText(Admin_authentication.this, "you are now an admin, You can now update or delete from database", Toast.LENGTH_SHORT).show();
                    edituser.setText("");
                    editpass.setText("");
                }
                else{
                    edituser.setText("");
                    editpass.setText("");
                    Toast.makeText(Admin_authentication.this, "wrong password or username", Toast.LENGTH_SHORT).show();
                }

            }

        });


        buttonn = findViewById(R.id.AdminBack);



        buttonn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SettingActivity.class);
                startActivity(i);
            }

        });

    }
}
