package com.example.mentos.Ui.ViewModel;


import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class MyChatModel extends RecyclerView.ItemDecoration {
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state){
        if(parent.getChildAdapterPosition(view) != parent.getAdapter().getItemCount() - 1){
            outRect.right = 20;
        }
    }
}
