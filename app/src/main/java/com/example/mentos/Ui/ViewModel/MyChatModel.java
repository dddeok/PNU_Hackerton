package com.example.mentos.Ui.ViewModel;


import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MyChatModel extends RecyclerView.ItemDecoration {
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state){
        if(parent.getChildAdapterPosition(view) != parent.getAdapter().getItemCount() - 1){
            outRect.right = 20;
        }
    }
}
