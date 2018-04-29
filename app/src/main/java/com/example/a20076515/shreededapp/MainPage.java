package com.example.a20076515.shreededapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainPage extends AppCompatActivity implements View.OnClickListener {


    ImageButton imageBack, imageLegs, imageArms, imageChest;
     Button buttonLogout,buttonMap;
     FirebaseAuth firebaseAuth;
    TextView textViewUserEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);


        imageBack = (ImageButton) findViewById(R.id.image_Back);
        imageLegs = (ImageButton) findViewById(R.id.image_Legs);
        imageArms = (ImageButton) findViewById(R.id.image_Arms);
        imageChest = (ImageButton) findViewById(R.id.image_Chest);
        buttonMap = (Button) findViewById(R.id.buttonMaps);



        buttonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPage.this, MapsActivity.class);
                startActivity(intent);
            }
        });




        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainPage.this, BackWorkout.class);
                startActivity(intentLoadNewActivity);

            }
        });

        imageLegs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainPage.this, LegWorkout.class);
                startActivity(intentLoadNewActivity);

            }
        });

        imageArms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainPage.this, ArmsWorkout.class);
                startActivity(intentLoadNewActivity);

            }
        });

        imageChest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainPage.this, ChestWorkout.class);
                startActivity(intentLoadNewActivity);

            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadNewActivity = new Intent(MainPage.this, ContactActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });





            firebaseAuth = FirebaseAuth.getInstance();

            //checking if user is logged in

            if(firebaseAuth.getCurrentUser() == null){
                finish();
                //starting login activity
                startActivity(new Intent(this, Login.class));
            }


            FirebaseUser user = firebaseAuth.getCurrentUser();



            buttonLogout = (Button) findViewById(R.id.buttonLogout);



            //listener
            buttonLogout.setOnClickListener(this);
        }


// Logs out

    public void onClick(View view) {
        //if logout is pressed
        if (view == buttonLogout) {
            //logging out the user
            firebaseAuth.signOut();
            //closing activity
            finish();
            //starting login activity
            startActivity(new Intent(this, Login.class));
        }
    }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
