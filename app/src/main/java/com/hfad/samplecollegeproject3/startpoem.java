package com.hfad.samplecollegeproject3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hfad.samplecollegeproject3.Data.PoemData;
import com.hfad.samplecollegeproject3.Data.UserData;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class startpoem extends AppCompatActivity {

    EditText et_title,et_poemlines;
    NumberPicker np1;
    int coupletno;
    String title=null;                                      // check if string data type will later throw an npe
    String poemLines=null;
    private FirebaseDatabase mfirebasedatabase;
    private DatabaseReference mdatabasereference;
    private DatabaseReference mdatabasereference2;
    private FirebaseUser User;
    private List<String> Users = new ArrayList<>();
    private String Username;
    private String Time;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startpoem);

        et_title=findViewById(R.id.newpoemtitle);
        et_poemlines=findViewById(R.id.NewPoemLines);

        np1=findViewById(R.id.np1);
        np1.setMinValue(5);
        np1.setMaxValue(300);
        np1.setWrapSelectorWheel(true);


       mfirebasedatabase= FirebaseDatabase.getInstance();
       mdatabasereference = mfirebasedatabase.getReference();
       mdatabasereference2= mfirebasedatabase.getReference();
       User = FirebaseAuth.getInstance().getCurrentUser();
       Username = User.getEmail();

        title= et_title.getText().toString();
        poemLines=et_poemlines.getText().toString();
        np1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                coupletno = newVal;
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    public void CreatePoem(View view) {

        calendar=Calendar.getInstance();
        String Month = calendar.getDisplayName(Calendar.MONTH,Calendar.LONG, Locale.getDefault());
        Time= calendar.get(Calendar.DAY_OF_MONTH) +"th "+Month+", " + calendar.get(Calendar.YEAR) + " " ;
        UserData userdata = new UserData(title,poemLines,coupletno,Username,Time);
        Users.add(Username);
        DatabaseReference mdatabasereference3= mdatabasereference.child("Users").push();
        mdatabasereference3.setValue(userdata);
        String key = mdatabasereference3.getKey();
        PoemData poemdata = new PoemData(Users,poemLines,coupletno,title,Time,key);
        mdatabasereference2.child("Poems").child(key).setValue(poemdata);
        Toast.makeText(getApplicationContext(),"An amazing poem has been created ",Toast.LENGTH_SHORT).show();

        //Write code for displaying the poem in the newly added poems
        // It should update in User's POJO and in the separate POJO created for the poem
    }
}

