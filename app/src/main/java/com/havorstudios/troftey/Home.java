package com.havorstudios.troftey;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Home extends AppCompatActivity {

    //UI Components
    ImageView btnGetStarted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //This method hides the action bar
        getSupportActionBar().hide();

        //Initialise Get Started Button
        btnGetStarted = findViewById(R.id.homeButtonOne);

        //Set an onClick listener for the button
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent is used to switch from one activity to another.
                Intent i = new Intent(Home.this, MainActivity.class);
                startActivity(i); // invoke the Main Activity.
            }
        });




    }

}