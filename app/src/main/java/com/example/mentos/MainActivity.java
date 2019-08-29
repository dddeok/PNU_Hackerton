package com.example.mentos;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn_temp;
    Button btn_temp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_temp = (Button)findViewById(R.id.btn_temp);
        btn_temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyChatActivity.class);
                startActivity(intent);
            }
        });

        btn_temp2 = (Button)findViewById(R.id.btn_temp2);
        btn_temp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContentRegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
