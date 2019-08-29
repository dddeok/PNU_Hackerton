package com.example.mentos;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

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
                String str_name = txt_name.getText().toString().trim();
                String str_email = txt_email.getText().toString().trim();
                String str_password = txt_password.getText().toString().trim();
                String str_phoneNumber = txt_phoneNumber.getText().toString().trim();

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

    private void register(final String str_name, String str_email, String str_password, final String str_phoneNumber) {

        auth.createUserWithEmailAndPassword(str_email, str_password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser firebaseUser = auth.getCurrentUser();
                            String userid =firebaseUser.getUid();

                            reference = FirebaseDatabase.getInstance().getReference("Users").child(userid);

                            HashMap<String, String>hashMap = new HashMap<>();
                            hashMap.put("id", userid);
                            hashMap.put("username", str_name);
                            hashMap.put("phonenumber", str_phoneNumber);

                            reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        finish();
                                    }
                                }
                            });
                        } else {
                            Log.e("TAG","On completed Failed : " + task.getException().getMessage());
                            Toast.makeText(RegisterActivity.this, "You can't register with this email or password", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
