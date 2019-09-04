package com.example.mentos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.mentos.Adapter.MentoringAdapter;
import com.example.mentos.Model.Mentoring;
import com.example.mentos.Model.MentoringList;

import java.util.ArrayList;
import java.util.List;

public class MentoringActivity extends AppCompatActivity {
    List<Mentoring> mMentorings;
    RecyclerView recyclerView;

    Mentoring mentoring;
    MentoringAdapter mentoringAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentoring);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));

        readContents();


    }

    private  void readContents(){
        mMentorings = new ArrayList<>();

        mMentorings.clear();

        MentoringList mMentoringList = new MentoringList();
        mMentoringList.settings();

        mentoringAdapter = new MentoringAdapter(MentoringActivity.this, mMentoringList.getmMentorings());
        recyclerView.setAdapter(mentoringAdapter);

    }
}
