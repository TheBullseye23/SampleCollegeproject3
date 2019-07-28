package com.hfad.samplecollegeproject3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hfad.samplecollegeproject3.Adapter.ContinuedPoemAdapter;
import com.hfad.samplecollegeproject3.Data.PoemData;

import java.util.ArrayList;
import java.util.List;

public class continuepoem extends AppCompatActivity {

    private RecyclerView mrecyclerview;
    private ContinuedPoemAdapter madapter;
    private RecyclerView.LayoutManager mlayoutmanager;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private List<PoemData> mPoems=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continuepoem);

        mFirebaseDatabase=FirebaseDatabase.getInstance();
        mDatabaseReference=mFirebaseDatabase.getReference("Poems");
        mrecyclerview=findViewById(R.id.RVcontinuepoem);
        mlayoutmanager = new LinearLayoutManager(this);
        mrecyclerview.setLayoutManager(mlayoutmanager);
        mrecyclerview.setHasFixedSize(true);
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mPoems.clear();
                for(DataSnapshot ds:dataSnapshot.getChildren())
                {
                    PoemData mPoem = ds.getValue(PoemData.class);
                    mPoems.add(mPoem);
                }

                madapter = new ContinuedPoemAdapter(mPoems,getApplicationContext());
                mrecyclerview.setAdapter(madapter);
                madapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
