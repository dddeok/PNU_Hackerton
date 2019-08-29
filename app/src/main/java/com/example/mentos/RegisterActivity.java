package com.example.mentos;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class RegisterActivity extends AppCompatActivity {
    LinearLayout linearLayout;

    EditText txt_email, txt_name, txt_password, txt_passwordConfirm, txt_phoneNumber;
    Button btn_cancel, btn_register;

    FirebaseAuth auth;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txt_email = (EditText)findViewById(R.id.email);
        txt_name = (EditText)findViewById(R.id.name);
        txt_password = (EditText)findViewById(R.id.password);
        txt_passwordConfirm = (EditText)findViewById(R.id.password2);
        txt_phoneNumber = (EditText)findViewById(R.id.hp);

        btn_cancel = (Button)findViewById(R.id.btn_cancel);
        btn_register = (Button)findViewById(R.id.btn_register);


        auth = FirebaseAuth.getInstance();

        linearLayout = (LinearLayout)findViewById(R.id.entire_view);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager in;
                in = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                in.hideSoftInputFromWindow(txt_email.getWindowToken(), 0);
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_name = txt_name.getText().toString();
                String str_email = txt_email.getText().toString();
                String str_password = txt_password.getText().toString();
                String str_phoneNumber = txt_phoneNumber.getText().toString();

                if(TextUtils.isEmpty(str_name) || TextUtils.isEmpty(str_email) || TextUtils.isEmpty(str_password) || TextUtils.isEmpty(str_phoneNumber)){
                    Toast.makeText(RegisterActivity.this, "All filed are required", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(str_password)!=TextUtils.isEmpty(txt_passwordConfirm.getText().toString())){
                    Toast.makeText(RegisterActivity.this, "Check your password", Toast.LENGTH_SHORT).show();
                } else {
                    register(str_name, str_email,str_password, str_phoneNumber);
                }
            }
        });

        //Spinner
        Spinner jobSpinner = (Spinner)findViewById(R.id.job);
        ArrayAdapter jobAdapter = ArrayAdapter.createFromResource
                (this, R.array.job, android.R.layout.simple_spinner_item);
        jobAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jobSpinner.setAdapter(jobAdapter);


    }

    private void register(String str_name, String str_email, String str_password, String str_phoneNumber) {
        
    }
}
