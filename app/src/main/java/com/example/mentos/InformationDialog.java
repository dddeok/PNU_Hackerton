package com.example.mentos;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class InformationDialog {
    private Context mContext;
    TextView start, end, title, donation, contents, uuid;
    ImageButton btn_apply;

    public InformationDialog(Context mContext) {
        this.mContext = mContext;
    }

    public  void callFunc(){
        final Dialog dialog = new Dialog(mContext);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.enroll);
        dialog.show();


    }
}
