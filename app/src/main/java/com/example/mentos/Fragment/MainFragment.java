package com.example.mentos.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentos.Adapter.DonationAdapter;
import com.example.mentos.Model.Donation;
import com.example.mentos.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {


    ImageButton btn_apply;

    DonationAdapter contentAdapter;

    List<Donation> mDonations;
    RecyclerView recyclerView;

    DatabaseReference reference;
    FirebaseUser fuser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        fuser = FirebaseAuth.getInstance().getCurrentUser();
        readContents();

        btn_apply = (ImageButton)view.findViewById(R.id.btn_apply);

        //popup
        ImageButton popup_btn = (ImageButton)view.findViewById(R.id.popup_btn);
        final LinearLayout popup = (LinearLayout)view.findViewById(R.id.popup);
        popup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.setVisibility(View.GONE);
            }
        });

        return view;
    }

    private void readContents() {
        mDonations = new ArrayList<>();

        reference = FirebaseDatabase.getInstance().getReference("Donations");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mDonations.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Donation donation = snapshot.getValue(Donation.class);
                    mDonations.add(donation);
                }

                contentAdapter = new DonationAdapter(getContext(), mDonations);
                recyclerView.setAdapter(contentAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
