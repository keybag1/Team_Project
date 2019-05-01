package com.knowyourrights;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import static com.knowyourrights.MainActivity.speak;

public class TechActivity extends AppCompatActivity {

    //Buttons
    private Button breakDown;
    private Button speechToText;
    private Button claroScanPen;
    private Button switchAccess;

    //URL Strings
    private String claroPackage = "com.clarosoftware.scanpen.scanpen_android&hl=en_IE";

    //TTS Strings
    private String TTS_claro = "Claro Scan Pen";
    private String TTS_STT = "Speech to Text";
    private String TTS_Breakdown = "Text to Speech Breakdown";
    private String TTS_switchAccess = "Switch Access";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        setContentView(R.layout.tech_layout);


        //Floating back action back button
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMain(v);
            }
        });

        //Claro ScanPen
        claroScanPen = findViewById(R.id.TopLeft);
        claroScanPen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlayStore(v, claroPackage);
            }
        });
        claroScanPen.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                speak(TTS_claro);
                return true;
            }
        });

        // Speech To Text
        speechToText = findViewById(R.id.TopRight);
        speechToText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        speechToText.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                speak(TTS_STT);
                return true;
            }
        });

        // Speech to text Break Down
        breakDown = findViewById(R.id.BottomLeft);
        breakDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Add speech to text breakdown
            }
        });
        breakDown.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                speak(TTS_Breakdown);
                return true;
            }
        });
        // Switch Access
        switchAccess = findViewById(R.id.BottomRight);
        switchAccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add switch access
            }
        });
        switchAccess.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                speak(TTS_switchAccess);
                return true;
            }
        });

    }

    public void backToMain(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openWebView(View v, String url) {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }

    public void openPlayStore(View v ,String pack) {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + pack)));
        }catch (ActivityNotFoundException e){
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + pack)));
        }
    }
}
