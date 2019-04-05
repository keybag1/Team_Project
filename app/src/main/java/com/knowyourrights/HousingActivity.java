package com.knowyourrights;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class HousingActivity extends AppCompatActivity {

    //Buttons
    private Button Info_Button;
    private Button RequestInfo_Button;
    private Button RRC_Button;

    //URLS
    private String InformationURL = "http://easytoread.sjog.ie/housing";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        setContentView(R.layout.housing_activity_layout);


        //Floating back action back button
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMain(v);
            }
        });

        //Information Button that links to SJOG easy to read website
        Info_Button = findViewById(R.id.TopRight);
        Info_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebView(v, InformationURL);
            }
        });
        //OnLongClick for Text to Speech
        Info_Button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                MainActivity.speak("Housing Information");
                return true;
            }
        });

        //Request Information Button
        RequestInfo_Button = findViewById(R.id.TopLeft);
        RequestInfo_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //OnLongClick for Text to speech
        RequestInfo_Button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                MainActivity.speak("Request Housing Information");
                return true;
            }
        });

        //Make Complaints Button
        RRC_Button = findViewById(R.id.BottomRight);
        RRC_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //Make Complaints TTS
        RRC_Button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                MainActivity.speak("Rights Review Committee");
                return true;
            }
        });
    }

    public void backToMain(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openWebView(View v, String url){
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra("url",url);
        startActivity(intent);
    }
}
