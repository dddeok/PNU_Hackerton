package com.example.mentos.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.mentos.DonationActivity;
import com.example.mentos.FavoriteActivity;
import com.example.mentos.MentoringActivity;
import com.example.mentos.MyChatActivity;
import com.example.mentos.ProfileActivitiy;
import com.example.mentos.QnaActivity;
import com.example.mentos.R;
public class MenuFragment extends Fragment {

    LinearLayout linearProfile;
    LinearLayout linearChat;
    LinearLayout linearFavorite;
    LinearLayout linearDonation;
    LinearLayout linearMentoring;
    LinearLayout linearQna;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        linearProfile = (LinearLayout)view.findViewById(R.id.profile);
        linearProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ProfileActivitiy.class);
                startActivity(intent);
            }
        });
        linearChat = (LinearLayout)view.findViewById(R.id.chat);
        linearChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MyChatActivity.class);
                startActivity(intent);
            }
        });
        linearFavorite = (LinearLayout)view.findViewById(R.id.favorite);
        linearFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FavoriteActivity.class);
                startActivity(intent);
            }
        });
        linearDonation = (LinearLayout)view.findViewById(R.id.donation);
        linearDonation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DonationActivity.class);
                startActivity(intent);
            }
        });
        linearMentoring = (LinearLayout)view.findViewById(R.id.metoring);
        linearMentoring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MentoringActivity.class);
                startActivity(intent);
            }
        });
        linearQna = (LinearLayout)view.findViewById(R.id.qna);
        linearQna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), QnaActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
