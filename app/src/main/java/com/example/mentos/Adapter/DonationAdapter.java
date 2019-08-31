package com.example.mentos.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentos.Model.Donation;
import com.example.mentos.R;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class DonationAdapter extends RecyclerView.Adapter<DonationAdapter.ViewHolder> {

    private Context mContext;
    private List<Donation> mDonations;

    public DonationAdapter(Context mContext, List<Donation> mDonations) {
        this.mContext = mContext;
        this.mDonations = mDonations;
    }

    FirebaseUser fuser;

    @NonNull
    @Override
    public DonationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_program, parent, false);
        return new DonationAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Donation donation = mDonations.get(position);

        holder.title.setText(donation.getTitle());
        holder.start.setText(donation.getStart());
        holder.end.setText(donation.getEnd());
    }

    @Override
    public int getItemCount() {
        return mDonations.size();
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
