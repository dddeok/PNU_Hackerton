package com.example.mentos;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class InformationDialog extends AppCompatActivity {
    private Context mContext;

    TextView start, end, title, donation, contents, uuid, username;
    ImageButton btn_apply, btn_close;
    ImageButton btn_favorite;

    FirebaseUser fuser;
    public InformationDialog(Context mContext) {
        this.mContext = mContext;
    }

    public  void callFunc(String str_title, String str_start, String str_end, String str_donation, String str_contents, String str_username, final String uuid){
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        final SharedPreferences.Editor editor = sharedPreferences.edit();


        final Dialog dialog = new Dialog(mContext, android.R.style.Theme_Light);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.enroll);

        title = (TextView)dialog.findViewById(R.id.title);
        title.setText(str_title);
        start = (TextView)dialog.findViewById(R.id.start);
        start.setText(str_start);
        end = (TextView)dialog.findViewById(R.id.end);
        end.setText(str_end);
        username =  (TextView)dialog.findViewById(R.id.username);
        username.setText(str_username);
        contents = (TextView)dialog.findViewById(R.id.contents);
        contents.setText(str_contents);
        donation = (TextView)dialog.findViewById(R.id.donation);
        donation .setText(str_donation);
        this.uuid = (TextView)dialog.findViewById(R.id.uuid);
        this.uuid.setText(uuid);

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
                fuser = FirebaseAuth.getInstance().getCurrentUser();
                if(!uuid.equals(fuser.getUid())) {
                    Intent intent = new Intent(mContext, MessageActivity.class);
                    intent.putExtra("userid", uuid);
                    mContext.startActivity(intent);
                } else {
                    Toast.makeText(mContext, "자신의 게시글에 신청할 수 없습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_favorite = (ImageButton)dialog.findViewById(R.id.btn_favorite);
        btn_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(title.getText().toString().equals(sharedPreferences.getString(title.getText().toString(), ""))) {
                    editor.remove(title.getText().toString());
                    btn_favorite.setBackgroundResource(R.drawable.emptystar);
                } else {
                    editor.putString(title.getText().toString(), title.getText().toString());
                    btn_favorite.setBackgroundResource(R.drawable.star);
                }
                editor.commit();
            }
        });

        if(title.getText().toString().equals(sharedPreferences.getString(title.getText().toString(), ""))) {
            btn_favorite.setBackgroundResource(R.drawable.star);
        } else {
            btn_favorite.setBackgroundResource(R.drawable.emptystar);
        }
        dialog.show();
    }
}
