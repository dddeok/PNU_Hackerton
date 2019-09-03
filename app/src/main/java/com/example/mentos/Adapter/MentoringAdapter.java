package com.example.mentos.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentos.MentoringDialog;
import com.example.mentos.Model.Mentoring;
import com.example.mentos.R;

import java.util.List;

public class MentoringAdapter extends RecyclerView.Adapter<MentoringAdapter.ViewHolder> {

    private Context mContext;
    private List<Mentoring> mMentorings;

    public MentoringAdapter(Context mContext, List<Mentoring> mMentorings) {
        this.mContext = mContext;
        this.mMentorings = mMentorings;
    }

    @NonNull
    @Override
    public MentoringAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_program, parent, false);
        return new MentoringAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MentoringAdapter.ViewHolder holder, int position) {
        final Mentoring mentoring = mMentorings.get(position);

        holder.title.setText(mentoring.getTitle());
        holder.start.setText(mentoring.getStart());
        holder.start.setText(mentoring.getEnd());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_title = mentoring.getTitle();
                String str_start = mentoring.getStart();
                String str_end = mentoring.getEnd();
                String str_username = mentoring.getUsername();
                String str_mentoring = mentoring.getMetoring();
                String str_contents = mentoring.getContents();

                MentoringDialog mentoringDialog = new MentoringDialog(mContext);
                mentoringDialog.callFunc(str_title, str_start, str_end, str_username, str_mentoring, str_contents);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mMentorings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public TextView start, end;
        public ImageButton btn_apply;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.title);
            start = (TextView)itemView.findViewById(R.id.start);
            end = (TextView)itemView.findViewById(R.id.end);
            btn_apply = (ImageButton)itemView.findViewById(R.id.btn_apply);
        }
    }
}
