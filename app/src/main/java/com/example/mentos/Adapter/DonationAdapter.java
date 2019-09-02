package com.example.mentos.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentos.InformationDialog;
import com.example.mentos.MainActivity;
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
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Donation donation = mDonations.get(position);

        holder.title.setText(donation.getTitle());
        holder.start.setText(donation.getStart());
        holder.end.setText(donation.getEnd());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_title = donation.getTitle();
                String str_start = donation.getStart();
                String str_end = donation.getEnd();
                String str_donation = donation.getDonation();
                String str_contents = donation.getContents();
                String str_username = donation.getUsername();
                String uuid = donation.getUuid();

                InformationDialog informationDialog = new InformationDialog(mContext);
                informationDialog.callFunc(str_title, str_start, str_end, str_donation, str_contents, str_username, uuid);
            }
        });
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
