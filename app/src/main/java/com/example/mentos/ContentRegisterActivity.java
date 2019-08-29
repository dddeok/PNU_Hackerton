package com.example.mentos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class ContentRegisterActivity extends AppCompatActivity {
    EditText text_title, text_donation, text_start, text_end, text_contents;
    ImageButton btn_cancel, btn_write;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_register);

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.entire_view);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager in;
                in = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                in.hideSoftInputFromWindow(text_title.getWindowToken(), 0);
            }
        });

        text_title = (EditText)findViewById(R.id.write_title);
        text_donation = (EditText)findViewById(R.id.main_content);
        text_start = (EditText)findViewById(R.id.start_date);
        text_end = (EditText)findViewById(R.id.end_date);
        text_contents = (EditText)findViewById(R.id.content_text);

        btn_cancel = (ImageButton)findViewById(R.id.btn_write_cancle);
        btn_write = (ImageButton)findViewById(R.id.btn_write_submit);


    }
}
