package com.example.testcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        Intent intent = getIntent();
        String user_name = intent.getStringExtra("user_name");
        Toast.makeText(this, "Hi, " + user_name, Toast.LENGTH_LONG).show();

    }
}