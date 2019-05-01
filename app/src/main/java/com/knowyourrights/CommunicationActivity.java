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

public class CommunicationActivity extends AppCompatActivity {

    //Buttons
    private Button Technology;
    private Button CitizenInfo;
    private Button Complaints;
    private Button RightsReviewCommittee;

    //TTS Strings
    private String TTS_Tech = "Assistive Technology";
    private String TTS_CitizensInformation = "Citizen's Information";
    private String TTS_Complaints = "Complaints";
    private String TTS_RightsReviewCommittee = "Rights Review Committee";

    //URLS
    private String citizenURL = "www.citizensinformationboard.ie/downloads/accessibility/Accessible_Information_For_All.pdf";
    private String complaintURL = "https://www.vimeo.com/167750269";
    private String rightsReviewCommittee = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        setContentView(R.layout.communication_activity_layout);


        //Floating back action back button
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMain(v);
            }
        });

        //Technology Button
        Technology = findViewById(R.id.TopLeft);
        Technology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View tview) {
                TechMenu(tview);
            }
        });
        Technology.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                speak(TTS_Tech);
                return true;
            }
        });

        //Citizen Information Button
        CitizenInfo = findViewById(R.id.TopRight);
        CitizenInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View Cview) {
                openWebView(Cview, citizenURL, null, null);
            }
        });
        CitizenInfo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                speak(TTS_CitizensInformation);
                return true;
            }
        });

        //Complaints Button
        Complaints = findViewById(R.id.BottomLeft);
        Complaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebView(v, complaintURL, null, null);
            }
        });
        Complaints.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                speak(TTS_Complaints);
                return true;
            }
        });

        //Rights Review Committee Button
        RightsReviewCommittee = findViewById(R.id.BottomRight);
        RightsReviewCommittee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open Email Activity
                String addr = getString(R.string.Rights_Review_addr);
                String msg = getString(R.string.Rights_review_msg);
                openMail(v, addr, msg);
            }
        });
        RightsReviewCommittee.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v){
                speak(TTS_RightsReviewCommittee);
                return  true;
            }
        });

    }

    //backToMain Method that returns to the main menu
    public void backToMain(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //openWebView Method that opens webview
    public void openWebView(View v, String url, String addr, String msg) {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra("url", url);
        intent.putExtra("addr", addr);
        intent.putExtra("msg",msg);
        startActivity(intent);
    }

    //TechMenu method that opens the tech view
    public void TechMenu(View tview) {
        Intent TechIntent = new Intent(this, TechActivity.class);
        startActivity(TechIntent);
    }

    //open Mail Class
    public void openMail(View v, String addr, String msg){
        Intent mailIntent = new Intent(this, EmailComplaints.class);
        mailIntent.putExtra("addr", addr);
        mailIntent.putExtra("msg",msg);
        startActivity(mailIntent);
    }

}
