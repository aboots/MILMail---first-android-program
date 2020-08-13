package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class mailBoxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_box);
        RecyclerView recyclerView=findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        EmailAdaptor adaptor=new EmailAdaptor(Email.getAllEmails(),this);
        recyclerView.setAdapter(adaptor);
    }

    public void onSentEmail(View view) {
        Intent intent = new Intent(mailBoxActivity.this, sendEmailActivity.class);
        startActivity(intent);
    }
}