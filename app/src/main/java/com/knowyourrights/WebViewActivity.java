package com.knowyourrights;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class WebViewActivity extends AppCompatActivity {

    private Button Emailbutton;
    private WebView webView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String webViewURL = getIntent().getStringExtra("url");

        setContentView(R.layout.web_view);

        webView = (WebView) findViewById(R.id.webView1);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(webViewURL);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //Email Complaint button
        Emailbutton = findViewById(R.id.button3);
        Emailbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addr = getIntent().getStringExtra("addr");
                String msg = getIntent().getStringExtra("msg");
                openMail(v,addr, msg );
            }
        });
    }

    /*Method that when the back button is pressed
    you return to the page or previous web page*/
    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }else{
            super.onBackPressed();
        }
    }

    //open Mail Class
    public void openMail(View v, String addr, String msg){
        Intent mailIntent = new Intent(this, EmailComplaints.class);
        mailIntent.putExtra("addr", addr);
        mailIntent.putExtra("msg",msg);
        startActivity(mailIntent);
    }

}
