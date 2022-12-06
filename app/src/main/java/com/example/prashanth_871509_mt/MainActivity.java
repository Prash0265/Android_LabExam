package com.example.prashanth_871509_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import java.text.DecimalFormat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemSelectedListener {
    Spinner spinner;
    SeekBar seekbar;
    TextView numOfDays, Amount, totalPayment,carSelected;
    EditText carPrice;
    List<String> categories;
    int Price, duration;
    double finalAmount;
    Button btn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        seekbar = findViewById(R.id.seekBar);
        numOfDays = findViewById(R.id.textView3);
        carPrice = findViewById(R.id.editTextTextPersonName);
        carPrice.setEnabled(false);
        Amount = findViewById(R.id.textView6);
        totalPayment = findViewById(R.id.textView7);
        carSelected =findViewById(R.id.textView12);
        btn = findViewById(R.id.button);

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


        btn.setOnClickListener(view -> {
            Intent intent  = new Intent(MainActivity.this, secondScreen.class);
            intent.putExtra("Total Payment", totalPayment.getText().toString());
            intent.putExtra("Number of days", numOfDays.getText().toString());
            intent.putExtra("Car Selection",carSelected.getText().toString());
           // spinner.setAdapter(dataAdapter)
            //intent.putExtra("carselected");
////        intent.putExtra("height", height.getText().toString());
            startActivity(intent);
        });

        // SEEKBAR CODE
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("TAG","OnProgressChanged " + progress);
                numOfDays.setText("Days: "+progress);
                duration = progress;
                Amount.setText("Amount: "+(Price*duration) +"$");
                totalPayment.setText("Amount: "+decfor.format((Price*duration)*1.13) +"$");

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
            String item =spinner.getSelectedItem().toString();
            if (item.equals("BMW")) {
                Price = 50;
                carPrice.setText(""+Price+"$" );
                carSelected.setText("BMW");
            }
            else if (item.equals("Audi")){
                Price = 80;
                carPrice.setText( ""+Price+"$" );
            }
            else if (item == "Mercedes"){
                Price = 90;
                carPrice.setText(""+Price+"$");

            }
            else if (item == "Bentley"){
                Price = 50;

                carPrice.setText( ""+Price+"$" );
            }
            else if (item == "Cadillac"){
                Price = 30;
                carPrice.setText(""+Price+"$");

            }
            else if (item == "Chevrolet"){
                Price = 40;
                carPrice.setText( ""+Price+"$" );
            }
            else if (item == "Ford"){
                Price = 15;
                carPrice.setText(""+Price+"$");
            }
            else if (item == "Volvo"){
                Price = 70;
                carPrice.setText( ""+Price+"$" );
            }
            else if (item == "Tesla"){
                Price = 100;
                carPrice.setText( ""+Price+"$" );
            }

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }


    public void radioClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();
        double ageSelection;
        switch (view.getId()){
            case R.id.rb1:
                if (checked){
                    ageSelection = 5;
                    Amount.setText("Amount: "+((Price*duration)+ageSelection) +"$");
                    totalPayment.setText("Total Payement: "+decfor.format(((Price*duration)+ageSelection)*1.13) +"$");
                    finalAmount = ((Price*duration)+ageSelection)*1.13;
                }
                break;
            case R.id.rb2:
                if (checked){
                    Amount.setText("Amount: "+(Price*duration) +"$");
                    totalPayment.setText("Total Payement: "+decfor.format((Price*duration*1.13)) +"$");
                    finalAmount = Price*duration*1.13;
                }
                break;
            case R.id.rb3:
                if (checked){
                    ageSelection = 10;
                    Amount.setText("Amount: "+((Price*duration)-ageSelection) +"$");
                    Amount.setText("Total Payement: "+decfor.format(((Price*duration)-ageSelection)*1.13) +"$");
                    finalAmount = ((Price*duration)-ageSelection)*1.13;
                }
                break;
        }



    }


    public void checkBoxClicked(View view){
        boolean checked = ((CheckBox) view).isChecked();
        double checkSelection;
        switch (view.getId()){
            case R.id.ch1:
                if (checked){
                    checkSelection = 5;
                    finalAmount = finalAmount + checkSelection;
                    Amount.setText("Amount: "+ decfor.format(finalAmount) +"$");
                    totalPayment.setText("Total Payement: "+ decfor.format(finalAmount) +"$");
                }
                break;
            case R.id.rb2:
                if (checked){
                    checkSelection = 7;
                    finalAmount = finalAmount + checkSelection;
                    Amount.setText("Amount: "+ decfor.format(finalAmount) +"$");
                    totalPayment.setText("Total Payement: "+ decfor.format(finalAmount) +"$");
                }
                break;
            case R.id.rb3:
                if (checked){
                    checkSelection = 10;
                    finalAmount = finalAmount + checkSelection;
                    Amount.setText("Amount: "+ decfor.format(finalAmount) +"$");
                    totalPayment.setText("Total Payement: "+ decfor.format(finalAmount) +"$");
                }
                break;
        }



    }

    private static final DecimalFormat decfor = new DecimalFormat("0.00");


}