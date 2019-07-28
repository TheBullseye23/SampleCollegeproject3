package com.hfad.samplecollegeproject3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hfad.samplecollegeproject3.Data.PoemData;

public class ContinuePoem3 extends AppCompatActivity {

   private FirebaseDatabase mdatabase1;
   private DatabaseReference mreference;
   private DatabaseReference mreference2;
   private String key;
   private TextView poemdisplay;
   private EditText addedlines;
   private Button mButton;
   private PoemData mPoem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue_poem3);

         Intent intent=getIntent();
         key=intent.getStringExtra("KEY");

         poemdisplay=findViewById(R.id.CP3poemdisplay);
         addedlines=findViewById(R.id.CP3addedlines);
         mButton=findViewById(R.id.AddPoem);

         mdatabase1=FirebaseDatabase.getInstance();
         mreference=mdatabase1.getReference("Poems").child(key);
         mreference2=mdatabase1.getReference("Poems").child(key);
         mreference.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                  mPoem = dataSnapshot.getValue(PoemData.class);
                 addedlines.setText(mPoem.getPoemLines());

             }

             @Override
             public void onCancelled(@NonNull DatabaseError databaseError) {

             }
         });
    }

    public void Addlines(View view) {
        mreference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String NewLines=null;
                String OldLines = mPoem.getPoemLines();
                NewLines = OldLines + addedlines.getText().toString();
                mPoem.setPoemLines(NewLines);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mreference.setValue(mPoem);
        Toast.makeText(this,"Added to poem!",Toast.LENGTH_SHORT).show();

    }
}
