package com.example.prashanth_871509_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class secondScreen extends AppCompatActivity {
    TextView totalPayment,numofdays,carinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        totalPayment = findViewById(R.id.textView9);
        numofdays =  findViewById(R.id.textView10);
        carinfo =  findViewById(R.id.textView11);
        String s1 = getIntent().getStringExtra("Total Payment");
        String s2 = getIntent().getStringExtra("Number of days");
        String s3 =  getIntent().getStringExtra("Car Selection");
        numofdays.setText("Number of days: "+s2);
        carinfo.setText("Car Model :"+s3);
        totalPayment.setText(s1);
    }
}