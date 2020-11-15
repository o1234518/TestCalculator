package com.example.testcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout layout_name;
    private EditText edit_name;
    private Button btn_nameConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        layout_name = findViewById(R.id.layout_name);
        layout_name.setErrorEnabled(true);
        edit_name = findViewById(R.id.edit_name);
        btn_nameConfirm = findViewById(R.id.btn_name_confirm);
        btn_nameConfirm.setOnClickListener(clickListener);
    }

    private Button.OnClickListener clickListener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_name_confirm :
                    String user_name = edit_name.getText().toString();
                    if(user_name.length() <= 0) {
                        layout_name.setError(getResources().getString(R.string.name_error));
                    } else {
                        Intent intent = new Intent(getApplicationContext(), CalculatorActivity.class);
                        intent.putExtra("user_name", user_name);
                        startActivity(intent);
                    }
            }
        }
    };
}