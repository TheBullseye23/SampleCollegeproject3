package com.hfad.samplecollegeproject3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hfad.samplecollegeproject3.Data.PoemData;

public class ContinuedPoems2 extends AppCompatActivity {

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference ;
    private DatabaseReference mDatabaseReference2;
    private String key;

    private TextView CP2title;
    private TextView CP2poem;
    private TextView CP2authors;
    private TextView CP2time;
    private TextView CP2favno;
    private TextView CP2turnsleft;
    private Button   cp2Button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continued_poems2);


        Bundle mBundle = this.getIntent().getExtras();
        key = mBundle.getString("KEY");

        CP2title=findViewById(R.id.CP2title);
        CP2poem=findViewById(R.id.CP2poem);
        CP2authors=findViewById(R.id.CP2Authors);
        CP2time=findViewById(R.id.CP2timemade);
        CP2favno=findViewById(R.id.CP2favno);
        CP2turnsleft=findViewById(R.id.CP2turnsleft);
        cp2Button=findViewById(R.id.btngotoCP3);


        mFirebaseDatabase= FirebaseDatabase.getInstance();
        mDatabaseReference=mFirebaseDatabase.getReference("Poems");
        mDatabaseReference2=mDatabaseReference.child(key);
        mDatabaseReference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 PoemData mpoem = dataSnapshot.getValue(PoemData.class);
                CP2title.setText(mpoem.getPoemTitle());
                CP2time.setText(mpoem.getTime());
                CP2poem.setText(mpoem.getPoemLines());
                String USERS="";
                for(int i=0;i<mpoem.getUsers().size();i++)
                {
                    USERS+=mpoem.getUsers().get(i);
                    USERS+=",";

                }
                CP2authors.setText(USERS);
                CP2turnsleft.setText(String.valueOf(mpoem.getPoemLength()));
                CP2favno.setText("Hi");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





    }

    public void continuepoem(View view) {

            Intent intent = new Intent(this,ContinuePoem3.class);
            intent.putExtra("KEY", key);
            startActivity(intent);

    }
}