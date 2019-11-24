package com.reymond.trac_insta;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.reymond.trac_insta.installation.TabActivity;
import com.reymond.trac_insta.planner.PlannerActivity;
import com.reymond.trac_insta.requirement.Tab3Activity;
import com.reymond.trac_insta.service.Tab2Activity;
import com.reymond.trac_insta.support.SupportActivity;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        if (!isNetworkConnected()) {
            Toast.makeText(this, "Not connected please connect to internet!", Toast.LENGTH_SHORT).show();
        }

        CardView cardView = (CardView) findViewById(R.id.card1);
        // set corner radius value
        // Implement onClickListener event on CardView
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View.OnClickListener context = this;

                Intent intent = new Intent(HomeActivity.this, TabActivity.class);
                startActivity(intent);
            }
        });


        CardView cardView1 = (CardView) findViewById(R.id.card2);
        // set corner radius value
        // Implement onClickListener event on CardView
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View.OnClickListener context = this;

                Intent intent = new Intent(HomeActivity.this, Tab2Activity.class);
                startActivity(intent);

            }
        });


        CardView cardView2 = (CardView) findViewById(R.id.card3);
        // set corner radius value
        // Implement onClickListener event on CardView
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View.OnClickListener context = this;

                Intent intent = new Intent(HomeActivity.this, PlannerActivity.class);
                startActivity(intent);

            }
        });


        CardView cardView3 = (CardView) findViewById(R.id.card5);
        // set corner radius value
        // Implement onClickListener event on CardView
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View.OnClickListener context = this;

                Intent intent = new Intent(HomeActivity.this, SupportActivity.class);
                startActivity(intent);

            }
        });


        CardView cardView4 = (CardView) findViewById(R.id.card6);
        // set corner radius value
        // Implement onClickListener event on CardView
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View.OnClickListener context = this;

                Intent intent = new Intent(HomeActivity.this, SettingActivity.class);
                startActivity(intent);

            }
        });


        CardView cardView5 = (CardView) findViewById(R.id.card4);
        // set corner radius value
        // Implement onClickListener event on CardView
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View.OnClickListener context = this;

                Intent intent = new Intent(HomeActivity.this, Tab3Activity.class);
                startActivity(intent);

            }
        });
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        assert cm != null;
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }
}

































