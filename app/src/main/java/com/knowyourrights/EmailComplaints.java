package com.knowyourrights;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EmailComplaints extends AppCompatActivity
{

    private TextView TextViewTo;
    private EditText mEditTextSubject;
    private EditText mEditTextMessage;
    public String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emailcomplaintsmenu);

        email = getIntent().getStringExtra("msg");


        TextViewTo = findViewById(R.id.text_view);
        mEditTextSubject = findViewById(R.id.edit_text_subject);
        mEditTextMessage = findViewById(R.id.edit_text_message);
        mEditTextMessage.setText(getIntent().getStringExtra("msg"));
        TextViewTo.setText(getIntent().getStringExtra("addr"));


        Button buttonSend = findViewById(R.id.button_send);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail(email);
            }
        });
    }

    private void sendMail(String email) {
        String recipientList = TextViewTo.getText().toString();
        String[] recipients = recipientList.split(",");

        String subject = mEditTextSubject.getText().toString();
        String message = mEditTextMessage.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an email client"));
        email = null;
    }

}
