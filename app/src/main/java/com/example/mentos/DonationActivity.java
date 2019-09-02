package com.example.mentos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mentos.Adapter.DonationAdapter;
import com.example.mentos.Model.Donation;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DonationActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    List<Donation> mDonations;

    FirebaseUser fuser;
    DatabaseReference reference;

    DonationAdapter donationAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));

        fuser = FirebaseAuth.getInstance().getCurrentUser();
        readContents();

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

                donationAdapter = new DonationAdapter(DonationActivity.this, mDonations);
                recyclerView.setAdapter(donationAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
