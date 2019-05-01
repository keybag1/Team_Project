package com.knowyourrights;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import static com.knowyourrights.MainActivity.speak;


public class MoneyActivity extends AppCompatActivity {

    //Buttons
    private Button MABsButton;
    private Button RightsButton;
    private Button InclusionIrelandButton;
    private Button RRC;

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
              String addr = getString(R.string.mabs_addr);
              String msg = getString(R.string.mabs_msg);
              openWebView(v, MabsURL, addr, msg);
          }
      });

      MABsButton.setOnLongClickListener(new View.OnLongClickListener() {
          @Override
          public boolean onLongClick(View v) {
              speak("Money and Budgeting Service");
              return true;
          }
      });

      //Rights Button
      RightsButton = findViewById(R.id.TopLeft);
      RightsButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              openWebView(v, RightsURL, null, null);
          }
      });

      RightsButton.setOnLongClickListener(new View.OnLongClickListener() {
          @Override
          public boolean onLongClick(View v) {
              speak("Money Rights");
              return true;
          }
      });

      //Inclusion Ireland Button
      InclusionIrelandButton = findViewById(R.id.TopRight);
      InclusionIrelandButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String addr = getString(R.string.Inclusion_Ireland_addr);
              String msg = getString(R.string.Inclusion_Ireland_moneymsg);
              openWebView(v, InclusionIreland, addr, msg );
          }
      });

      InclusionIrelandButton.setOnLongClickListener(new View.OnLongClickListener() {
          @Override
          public boolean onLongClick(View v) {
              speak("Inclusion Ireland");
              return true;
          }
      });

      //Rights Review Committee Button
      RightsButton = findViewById(R.id.BottomRight);;
      RightsButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
                String addr = getString(R.string.Rights_Review_addr);
                String msg = getString(R.string.Rights_review_msg);
                openMail(v, addr, msg);
          }
      });

      RightsButton.setOnLongClickListener(new View.OnLongClickListener() {
          @Override
          public boolean onLongClick(View v) {
              speak("Rights Review Committee");
              return true;
          }
      });


  }

  public void backToMain(View v){
    Intent intent = new Intent(this, MainActivity.class);
    startActivity(intent);
  }

  public void openWebView(View v, String url, String addr, String msg){
      Intent intent = new Intent(this, WebViewActivity.class);
      intent.putExtra("url",url);
      intent.putExtra("addr", addr);
      intent.putExtra("msg",msg);
      startActivity(intent);
  }

    //open Mail Class
    public void openMail(View v, String addr, String msg){
        Intent mailIntent = new Intent(this, EmailComplaints.class);
        mailIntent.putExtra("addr", addr);
        mailIntent.putExtra("msg",msg);
        startActivity(mailIntent);
    }

}
