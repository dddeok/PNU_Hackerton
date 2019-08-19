package com.example.mentos.ViewUi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.mentos.R;

public class Register extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        //Spinner
        Spinner jobSpinner = (Spinner)findViewById(R.id.job);
        ArrayAdapter jobAdapter = ArrayAdapter.createFromResource
                (this,R.array.job, android.R.layout.simple_spinner_item);
        jobAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jobSpinner.setAdapter(jobAdapter);
    }
}
