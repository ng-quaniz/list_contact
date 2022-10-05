package com.example.bt7;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView ten = (TextView) findViewById(R.id.ten);
        TextView sdt = (TextView) findViewById(R.id.sdt);
        Intent intent= getIntent();
        ten.setText(intent.getStringExtra("ten"));
        sdt.setText(intent.getStringExtra("sdt"));
    }
}