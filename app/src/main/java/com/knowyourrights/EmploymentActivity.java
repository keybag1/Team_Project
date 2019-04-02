package com.knowyourrights;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class EmploymentActivity extends AppCompatActivity {

    //Buttons
    private Button Employability;
    private Button SupportedEmployability;
    private Button InclusionIreland;

    //URL Strings
    private String welfareURL = "https://www.welfare.ie/en/Pages/EmployAbility-Service.aspx";
    private String sjogWorkURL = "http://easytoread.sjog.ie/work/";
    private String InclusionIrelandURL = "http://inclusionireland.ie/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        setContentView(R.layout.employment_activity_layout);

        //Floating action button for TTS
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Employability button
        Employability = findViewById(R.id.TopLeft);
        Employability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebView(v, welfareURL);
            }
        });
        Employability.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                MainActivity.speak("Employability");
                return true;
            }
        });

        //Supported Employability button
        SupportedEmployability = findViewById(R.id.TopRight);
        SupportedEmployability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebView(v, sjogWorkURL);
            }
        });
        SupportedEmployability.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                MainActivity.speak("Supported Employment");
                return true;
            }

        });

        //Inclusion Ireland button
        InclusionIreland = findViewById(R.id.BottomLeft);
        InclusionIreland.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebView(v, InclusionIrelandURL);
            }
        });
        InclusionIreland.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                MainActivity.speak("Inclusion Ireland");
                return true;
            }
        });


        //Floating back action back button
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMain(v);
            }
        });

    }

    public void backToMain(View m) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openWebView(View v, String url) {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }

}