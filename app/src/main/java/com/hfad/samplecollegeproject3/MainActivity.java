package com.hfad.samplecollegeproject3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authlistener;
    private static final int RC_SIGN_IN = 1;
    private Button mButton;


    private String mUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth=FirebaseAuth.getInstance();
        mButton=findViewById(R.id.btnSignout);

        authlistener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user!=null)
                {
                    Toast.makeText(MainActivity.this,"Welcome",Toast.LENGTH_SHORT).show();
                }else
                {
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder().setIsSmartLockEnabled(false)
                                    .setAvailableProviders(Arrays.asList(new AuthUI.IdpConfig.EmailBuilder().build()
                                    ))
                                    .build(),
                            RC_SIGN_IN);
                }
            }
        };
    }




    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // RC_SIGN_IN is the request code you passed into startActivityForResult(...) when starting the sign in flow.
        if (requestCode == RC_SIGN_IN) {
            if(resultCode==RESULT_OK)
            {
                Toast.makeText(this,"Signed in!",Toast.LENGTH_SHORT).show();
            }
            else if(resultCode==RESULT_CANCELED)
            {
                Toast.makeText(this,"Login Cancelled",Toast.LENGTH_SHORT).show();
                finish();
            }

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        auth.removeAuthStateListener(authlistener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        auth.addAuthStateListener(authlistener);
    }

    public void gotoStart(View view) {
        Intent intent = new Intent(this,startpoem.class);
        startActivity(intent);

    }

    public void gotocontinue(View view) {
        Intent intent = new Intent(this,continuepoem.class);
        startActivity(intent);
    }

    public void gotoread(View view) {
        Intent intent = new Intent(this,readpoem.class);
        startActivity(intent);
    }

    public void gotouserpoem(View view) {
        Intent intent = new Intent(this,userpoem.class);
        startActivity(intent);
    }

    public void SIGNOut(View view) {
        auth.getInstance().signOut();
    }
}
