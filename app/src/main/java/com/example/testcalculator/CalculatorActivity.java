package com.example.testcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {

    private TextView tv_mointor, tv_sign, tv_add, tv_minus, tv_multiplication, tv_division;
    private Button btn_cal0, btn_cal1, btn_cal2, btn_cal3, btn_cal4, btn_cal5, btn_cal6, btn_cal7, btn_cal8, btn_cal9,
            btn_add, btn_minus, btn_multiplication, btn_division, btn_equal, btn_point, btn_sign, btn_ac, btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        Intent intent = getIntent();
        String user_name = intent.getStringExtra("user_name");
        Toast.makeText(this, "Hi, " + user_name, Toast.LENGTH_LONG).show();

        uiInit();

    }

    private void uiInit(){
        tv_mointor = findViewById(R.id.tv_calculator_mointor);
        tv_sign = findViewById(R.id.tv_sign);
        tv_add = findViewById(R.id.tv_add);
        tv_minus = findViewById(R.id.tv_minus);
        tv_multiplication = findViewById(R.id.tv_multiplication);
        tv_division = findViewById(R.id.tv_division);

        btn_cal0 = findViewById(R.id.btn_cal_0);
        btn_cal1 = findViewById(R.id.btn_cal_1);
        btn_cal2 = findViewById(R.id.btn_cal_2);
        btn_cal3 = findViewById(R.id.btn_cal_3);
        btn_cal4 = findViewById(R.id.btn_cal_4);
        btn_cal5 = findViewById(R.id.btn_cal_5);
        btn_cal6 = findViewById(R.id.btn_cal_6);
        btn_cal7 = findViewById(R.id.btn_cal_7);
        btn_cal8 = findViewById(R.id.btn_cal_8);
        btn_cal9 = findViewById(R.id.btn_cal_9);

        btn_cal0.setOnClickListener(numberClickListener);
        btn_cal1.setOnClickListener(numberClickListener);
        btn_cal2.setOnClickListener(numberClickListener);
        btn_cal3.setOnClickListener(numberClickListener);
        btn_cal4.setOnClickListener(numberClickListener);
        btn_cal5.setOnClickListener(numberClickListener);
        btn_cal6.setOnClickListener(numberClickListener);
        btn_cal7.setOnClickListener(numberClickListener);
        btn_cal8.setOnClickListener(numberClickListener);
        btn_cal9.setOnClickListener(numberClickListener);

        btn_add = findViewById(R.id.btn_cal_add);
        btn_minus = findViewById(R.id.btn_cal_minus);
        btn_multiplication = findViewById(R.id.btn_cal_multiplication);
        btn_division = findViewById(R.id.btn_cal_division);
        btn_equal = findViewById(R.id.btn_cal_equal);
        btn_point = findViewById(R.id.btn_cal_point);
        btn_sign = findViewById(R.id.btn_cal_sign);
        btn_ac = findViewById(R.id.btn_cal_ac);
        btn_back = findViewById(R.id.btn_cal_back);

        btn_add.setOnClickListener(functionClickListener);
        btn_minus.setOnClickListener(functionClickListener);
        btn_multiplication.setOnClickListener(functionClickListener);
        btn_division.setOnClickListener(functionClickListener);
        btn_equal.setOnClickListener(functionClickListener);
        btn_point.setOnClickListener(functionClickListener);
        btn_sign.setOnClickListener(functionClickListener);
        btn_ac.setOnClickListener(functionClickListener);
        btn_back.setOnClickListener(functionClickListener);
    }

    private Button.OnClickListener numberClickListener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_name_confirm :
            }
        }
    };

    private Button.OnClickListener functionClickListener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_name_confirm :
            }
        }
    };
}