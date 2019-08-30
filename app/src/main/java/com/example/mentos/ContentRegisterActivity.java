package com.example.mentos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mentos.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ContentRegisterActivity extends AppCompatActivity {
    EditText text_title, text_donation, text_start, text_end, text_contents;
    ImageButton btn_cancel, btn_write;

    TextView usename, email, uuid;

    FirebaseUser firebaseUser;
    DatabaseReference reference;

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

        usename = (TextView)findViewById(R.id.username);
        email = (TextView)findViewById(R.id.email);
        uuid = (TextView)findViewById(R.id.uuid);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                usename.setText(user.getUsername());
                email.setText(user.getEmail());
                uuid.setText(user.getId());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}