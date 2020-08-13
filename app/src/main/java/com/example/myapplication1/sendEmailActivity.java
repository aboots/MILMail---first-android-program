package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class sendEmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);
    }

    public void send(View view) {
        EditText reciever = findViewById(R.id.reciever);
        final String recieverString = reciever.getText().toString();
        EditText subject = findViewById(R.id.subjectEmail);
        final String subjectString = subject.getText().toString();
        EditText body = findViewById(R.id.emailBody);
        final String bodyText = body.getText().toString();
        if (subjectString.equals("")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("your subject is empty.are you sure to send his email?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finalSentProcess(recieverString,subjectString,bodyText);
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                            Toast.makeText(getApplicationContext(), "fill subject",
                                    Toast.LENGTH_LONG).show();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.setTitle("Send email");
            alert.show();
        } else {
            finalSentProcess(recieverString,subjectString,bodyText);
        }
    }

    private void finalSentProcess(String reciever,String subject,String body) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{reciever});
        i.putExtra(Intent.EXTRA_SUBJECT, subject);
        i.putExtra(Intent.EXTRA_TEXT   , body);
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(sendEmailActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }
}