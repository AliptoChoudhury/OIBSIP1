package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.Array;

public class MainActivity extends AppCompatActivity {

    EditText input1;
    Spinner input2;
    TextView alipto1, alipto2,alipto3,alipto4,alipto5,alipto6,alipto7,alipto8,alipto9,alipto10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1=findViewById(R.id.input1);
        input2=findViewById(R.id.input2);
        alipto1=findViewById(R.id.alipto1);
        alipto2=findViewById(R.id.alipto2);
        alipto3=findViewById(R.id.alipto3);
        alipto4=findViewById(R.id.alipto4);
        alipto5=findViewById(R.id.alipto5);
        alipto6=findViewById(R.id.alipto6);
        alipto7=findViewById(R.id.alipto7);
        alipto8=findViewById(R.id.alipto8);
        alipto9=findViewById(R.id.alipto9);
        alipto10=findViewById(R.id.alipto10);

        String[] arr= {"alipto1","alipto2","alipto3","alipto4","alipto5","alipto6","alipto7","alipto8","alipto9","alipto10"};
        input2.setAdapter(new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arr));

        input2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                update();
            }
        });

        input1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                update();

            }
        });


    }

    private void update(){
        if(!input1.getText().toString().equals("")&& !input2.getSelectedItem().toString().equals("")){
            double in = Double.parseDouble(input1.getText().toString());
            switch (input2.getSelectedItem().toString()){
                case "alipto1":
                    setkm(in);
                    break;
                case "alipto2":
                    setkm(in/1000);
                    break;
                case "alipto3":
                    setkm(in/100000);
                    break;
                case "alipto4":
                    setkm(in/1000000);
                    break;
                case "alipto5":
                    double d = 1000000 * 1000000;
                    setkm(in/d);
                    break;
                case "alipto6":
                    setkm(in*1.609);
                    break;
                case "alipto7":
                    setkm(in/1094);
                    break;
                case "alipto8":
                    setkm(in/3281);
                    break;
                case "alipto9":
                    setkm(in/39370);
                    break;
                case "alipto10":
                    setkm(in/1000000000);
                    break;


            }
        }
    }
    private void setkm(double km_in){

        alipto1.setText(String.valueOf(km_in));
        alipto2.setText(String.valueOf(km_in*1000));
        alipto3.setText(String.valueOf(km_in*100000));
        alipto4.setText(String.valueOf(km_in*1000000));
        alipto5.setText(String.valueOf(km_in*1000000 * 1000000));
        alipto6.setText(String.valueOf(km_in/1.609));
        alipto7.setText(String.valueOf(km_in*1094));
        alipto8.setText(String.valueOf(km_in*3281));
        alipto9.setText(String.valueOf(km_in*39370));
        alipto10.setText(String.valueOf(km_in*1000000000));

    }
}