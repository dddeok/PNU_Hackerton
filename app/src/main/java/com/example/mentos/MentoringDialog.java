package com.example.mentos;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MentoringDialog{
    private Context mContext;

    TextView start, end, title, mentoring, contents, username;
    ImageButton btn_apply, btn_close;

    public MentoringDialog(Context mContext) {
        this.mContext = mContext;
    }

    public  void callFunc(String str_title, String str_start, String str_end,  String str_username,String str_mentoring, String str_contents, String uri){
        final Dialog dialog = new Dialog(mContext, android.R.style.Theme_Light);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.mentoring_enroll);

        title = (TextView)dialog.findViewById(R.id.title);
        title.setText(str_title);
        start = (TextView)dialog.findViewById(R.id.start);
        start.setText(str_start);
        end = (TextView)dialog.findViewById(R.id.end);
        end.setText(str_end);
        username =  (TextView)dialog.findViewById(R.id.username);
        username.setText(str_username);
        mentoring = (TextView)dialog.findViewById(R.id.mentoring);
        mentoring .setText(str_mentoring);
        contents = (TextView)dialog.findViewById(R.id.contents);
        contents.setText(str_contents);

        final String url = uri;

        btn_close = (ImageButton)dialog.findViewById(R.id.btn_close);
        btn_close.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MainActivity.class);
                mContext.startActivity(intent);
            }
        });

        btn_apply = (ImageButton)dialog.findViewById(R.id.btn_apply);
        btn_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                mContext.startActivity(intent);

            }
        });
        dialog.show();
    }
}
