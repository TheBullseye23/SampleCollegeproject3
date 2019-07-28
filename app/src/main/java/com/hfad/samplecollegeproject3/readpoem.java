package com.hfad.samplecollegeproject3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hfad.samplecollegeproject3.Adapter.ReadPoemAdapter;
import com.hfad.samplecollegeproject3.Data.PoemData;

import java.util.ArrayList;
import java.util.List;

public class readpoem extends AppCompatActivity {

    private ReadPoemAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference1;
    private List<PoemData> mReadPoems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readpoem);

        mDatabase = FirebaseDatabase.getInstance();
        mReference1 = mDatabase.getReference().child("Poems");
        mRecyclerView = findViewById(R.id.RVreadPoem);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mReference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mReadPoems.clear();
                for(DataSnapshot ds:dataSnapshot.getChildren())
                {
                    PoemData mPoem = ds.getValue(PoemData.class);
                    mReadPoems.add(mPoem);
                }

                mAdapter = new ReadPoemAdapter(mReadPoems,getApplicationContext());
                mRecyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


}
