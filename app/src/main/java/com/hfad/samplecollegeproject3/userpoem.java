package com.hfad.samplecollegeproject3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.hfad.samplecollegeproject3.Adapter.UserPoemAdapter;

public class userpoem extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private UserPoemAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference1;
    private FirebaseUser mUser;
    private String mEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userpoem);

        mDatabase=FirebaseDatabase.getInstance();
        mReference1=mDatabase.getReference("Poems");

        mUser = FirebaseAuth.getInstance().getCurrentUser();
        mEmail = mUser.getEmail();

        Query mQuery = mReference1.orderByChild("users").equalTo(mEmail);




    }
}
