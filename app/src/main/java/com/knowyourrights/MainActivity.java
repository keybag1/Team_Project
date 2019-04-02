package com.knowyourrights;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnLongClickListener;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button MoneyButton;
    private Button HousingButton;
    private Button CommunicationButton;
    private Button EmploymentButton;
    static TextToSpeech tts;

    private String test = "Employability";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Floating action button for TTS
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS){
                    int result = tts.setLanguage(Locale.ENGLISH);

                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                        Log.e("TTS", "Language not supported");
                    }
                }else{
                    Log.e("TTS", "Initialization failed");
                }
            }
        });

        //Button for money menu
         MoneyButton = findViewById(R.id.Money);
         MoneyButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View mview) {
                 MoneyMenu(mview);
             }
         });

         MoneyButton.setOnLongClickListener(new OnLongClickListener() {
             @Override
             public boolean onLongClick(View v) {
                 tts.setLanguage(Locale.ENGLISH);
                 tts.speak("Money",TextToSpeech.QUEUE_FLUSH, null, null);
                 return true;
             }
         });
         //Button for Housing Menu
        HousingButton = findViewById(R.id.Housing);
        HousingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View hview) {
                HousingMenu(hview);
            }
        });

        HousingButton.setOnLongClickListener(new OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                tts.setLanguage(Locale.ENGLISH);
                tts.speak("Housing",TextToSpeech.QUEUE_FLUSH, null, null);
                return true;
            }
        });

        //Button for Communication Menu
        CommunicationButton = findViewById(R.id.Communication);
        CommunicationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View cview) {
                CommunicationMenu(cview);
            }
        });

        CommunicationButton.setOnLongClickListener(new OnLongClickListener(){

            @Override
            public boolean onLongClick(View v) {
                speak(test);
                return true;
            }
        });

        //Button for Employment Menu
        EmploymentButton = findViewById(R.id.Employment);
        EmploymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View eview) {
                EmploymentMenu(eview);
            }
        });

        EmploymentButton.setOnLongClickListener(new OnLongClickListener(){

            @Override
            public boolean onLongClick(View v) {
                speak("Employment");
                //tts.setLanguage(Locale.ENGLISH);
                //tts.speak("Employment",TextToSpeech.QUEUE_FLUSH, null, null);
                return true;
            }
        });

    }

    static public void speak(String phrase){
        tts.speak(phrase, TextToSpeech.QUEUE_FLUSH, null, null);
    }

    //Money Menu Activity
    public void MoneyMenu(View mview) {
        Intent moneyIntent = new Intent(this, MoneyActivity.class);
        startActivity(moneyIntent);
    }
    //Housing Menu Activity
    public void HousingMenu(View hview) {
        Intent HousingIntent = new Intent(this, HousingActivity.class);
        startActivity(HousingIntent);
    }
    //Communication Menu Activity
    public void CommunicationMenu(View cview) {
        Intent CommunicationIntent = new Intent(this, CommunicationActivity.class);
        startActivity(CommunicationIntent);
    }
    //Employment Menu Activity
    public void EmploymentMenu(View eview) {
        Intent EmploymentIntent = new Intent(this, EmploymentActivity.class);
        startActivity(EmploymentIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
