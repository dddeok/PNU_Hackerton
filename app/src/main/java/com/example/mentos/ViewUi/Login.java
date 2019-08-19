package com.example.mentos.ViewUi;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.mentos.R;

public class Login extends AppCompatActivity {
    private static final int MY_PERMISSION_STORAGE = 1111;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        checkPermission();
    }

    private void checkPermission(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
            != PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CALL_PHONE)){
                new AlertDialog.Builder(this)
                        .setMessage("멘또띠아를 사용하려면 전화, 저장소, 주소록 접근 권한이 필요합니다.")
                        .setCancelable(false)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i){
                                finish();
                            }
                })
                        .create()
                        .show();
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE,
                Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_CONTACTS}, MY_PERMISSION_STORAGE);
            }
        }
    }

    public void onRequestPermissionResult(int requestCode, @NonNull String[] permissions,
                                          @NonNull int[] grantResults){
        switch(requestCode){
            case MY_PERMISSION_STORAGE:
            for (int i = 0; i< grantResults.length; i++){
                if(grantResults[i]<0){
                    Toast.makeText(Login.this, "해당 권한을 활성화 하셔야 합니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            break;
        }
    }
}
