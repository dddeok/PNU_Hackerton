package com.example.mentos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;

import com.example.mentos.Adapter.DonationAdapter;
import com.example.mentos.Adapter.MentoringAdapter;
import com.example.mentos.Model.Donation;
import com.example.mentos.Model.Mentoring;
import com.example.mentos.Model.MentoringList;
import com.example.mentos.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FavoriteActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    List<Donation> mDonations;
    List<Mentoring> mMentorings;
    List<Mentoring> tmp_mMentorings;

    MentoringList mMentoringList;

    FirebaseUser fuser;
    DatabaseReference reference;
    DonationAdapter donationAdapter;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = sharedPreferences.edit();

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));

        fuser = FirebaseAuth.getInstance().getCurrentUser();
        readContents();
    }

    private void readContents() {

        final String[] current_User = new String[1];

        fuser = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users").child(fuser.getUid());

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                current_User[0] = user.getJob();
                if(current_User[0].equals("멘티")) {
                    mDonations = new ArrayList<>();
                    reference = FirebaseDatabase.getInstance().getReference("Donations");
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            mDonations.clear();
                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                Donation donation = snapshot.getValue(Donation.class);
                                if (donation.getTitle().equals(sharedPreferences.getString(donation.getTitle(), ""))) {
                                    mDonations.add(donation);
                                }
                            }
                            donationAdapter = new DonationAdapter(FavoriteActivity.this, mDonations);
                            recyclerView.setAdapter(donationAdapter);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
                else {
                    mMentoringList = new MentoringList();
                    mMentoringList.settings();
                    tmp_mMentorings = new ArrayList<>();
                    tmp_mMentorings = mMentoringList.getmMentorings();

                    mMentorings = new ArrayList<>();
                    mMentorings.clear();

                    if (tmp_mMentorings != null) {
                        for (int i = 0; i < tmp_mMentorings.size(); i++) {
                            Mentoring mentoring = tmp_mMentorings.get(i);
                            if (mentoring.getTitle().equals(sharedPreferences.getString(mentoring.getTitle(), ""))) {
                                mMentorings.add(mentoring);
                                Log.d("Tag", "Success");
                            }
                        }
                        MentoringAdapter mentoringAdapter = new MentoringAdapter(FavoriteActivity.this, mMentorings);
                        recyclerView.setAdapter(mentoringAdapter);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
