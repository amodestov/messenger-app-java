package com.aleksandrmodestov.messenger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user == null) {
            Intent intent = LoginActivity.newIntent(this);
            startActivity(intent);
        } else {
            Log.d(TAG, "АВТОРИЗОВАН " + user.getUid());
        }
        //firebaseAuth.signOut();
        //firebaseAuth.createUserWithEmailAndPassword("modestov.1998@gmail.com", "12341234");


//        firebaseAuth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                if (user == null) {
//                    Log.d(TAG, "НЕ АВТОРИЗОВАН");
//                } else {
//                    Log.d(TAG, "АВТОРИЗОВАН " + user.getUid());
//                }
//            }
//        });
//        firebaseAuth.signOut();
//        firebaseAuth.sendPasswordResetEmail("modestov.1998@gmail.com").
//
//                addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void unused) {
//                        Log.d(TAG, "sent");
//                    }
//                }).
//
//                addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.d(TAG, e.getMessage());
//                    }
//                });


//        firebaseAuth.signInWithEmailAndPassword("modestov.1998@gmail.com", "123445321").addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Log.d(TAG, e.getMessage());
//            }
//        });
//        if (user == null) {
//            Log.d(TAG, "НЕ АВТОРИЗОВАН");
//        } else {
//            Log.d(TAG, "АВТОРИЗОВАН " + user.getUid());
//        }
//        firebaseAuth.createUserWithEmailAndPassword("sasha@gmail.com", "12341234")
//                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
//                    @Override
//                    public void onSuccess(AuthResult authResult) {
//                        FirebaseUser user = firebaseAuth.getCurrentUser();
//                        if (user == null) {
//                            Log.d(TAG, "НЕ АВТОРИЗОВАН");
//                        } else {
//                            Log.d(TAG, "АВТОРИЗОВАН");
//                        }
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.d(TAG, e.getMessage());
//                        Toast.makeText(MainActivity.this,
//                                        e.getMessage(),
//                                        Toast.LENGTH_SHORT)
//                                .show();
//                    }
//                });
//    }
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }
}
