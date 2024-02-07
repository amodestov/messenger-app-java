package com.aleksandrmodestov.messenger;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPasswordViewModel extends ViewModel {

    private MutableLiveData<Boolean> resetSuccess = new MutableLiveData<>();
    private MutableLiveData<String> resetErrorMessage = new MutableLiveData<>();

    private FirebaseAuth firebaseAuth;

    public ResetPasswordViewModel() {
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public LiveData<Boolean> getResetSuccess() {
        return resetSuccess;
    }

    public LiveData<String> getResetErrorMessage() {
        return resetErrorMessage;
    }

    public void resetPassword(String email) {
        firebaseAuth.sendPasswordResetEmail(email)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        resetSuccess.setValue(true);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        resetErrorMessage.setValue(e.getMessage());
                    }
                });
    }
}
