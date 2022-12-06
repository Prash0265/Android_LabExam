package com.example.prashanth_871509_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemSelectedListener {
    Spinner spinner;
    SeekBar seekbar;
    TextView numOfDays;

    List<String> categories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        seekbar = findViewById(R.id.seekBar);
        numOfDays = findViewById(R.id.textView3);

        spinner.setOnItemSelectedListener(this);
        categories = new ArrayList<>();
        categories.add("Please choose a car");
        categories.add("BMW");
        categories.add("Audi");
        categories.add("Mercedes");
        categories.add("Bentley");
        categories.add("Cadillac");
        categories.add("Chevrolet");
        categories.add("Ford");
        categories.add("Volvo");
        categories.add("Tesla");


        // SEEKBAR CODE
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                Log.i("TAG","OnProgressChanged " + progress);
                numOfDays.setText("Days: "+progress);
//                value = progress;
//                totalPrice.setText(""+(rate*value));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }


        });

        // SPINNER CODE
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        }

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }






}