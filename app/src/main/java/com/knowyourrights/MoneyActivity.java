package com.knowyourrights;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;


public class MoneyActivity extends AppCompatActivity {

    //Buttons
    private Button MABsButton;
    private Button RightsButton;
    private Button InclusionIrelandButton;

    //URLS
    private String RightsURL = "https://www.un.org/development/desa/disabilities/convention-on-the-rights-of-persons-with-disabilities.html";
    private String MabsURL = "https://www.mabs.ie/en/";
    private String InclusionIreland = "http://www.inclusionireland.ie/";



  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    //setSupportActionBar(toolbar);

    setContentView(R.layout.money_activity_layout);

    //Floating action button for TTS
    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
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

    //MABS Button
      MABsButton = findViewById(R.id.BottomLeft);
      MABsButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
                openWebView(v, MabsURL);
          }
      });

      //Rights Button
      RightsButton = findViewById(R.id.TopLeft);
      RightsButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              openWebView(v, RightsURL);
          }
      });

      //Inclusion Ireland Button
      InclusionIrelandButton = findViewById(R.id.TopRight);
      InclusionIrelandButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              openWebView(v, InclusionIreland );
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
