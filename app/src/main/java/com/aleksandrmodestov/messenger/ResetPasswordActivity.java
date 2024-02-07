package com.aleksandrmodestov.messenger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ResetPasswordActivity extends AppCompatActivity {

    public static final String EXTRA_EMAIL = "email";

    private EditText editTextEmail;
    private Button buttonResetPassword;
    private ResetPasswordViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        initViews();
        String email = getIntent().getStringExtra(EXTRA_EMAIL);
        editTextEmail.setText(email);
        viewModel = new ViewModelProvider(this).get(ResetPasswordViewModel.class);
        observeViewModel();
        setUpClickListeners();
    }

    private void initViews() {
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonResetPassword = findViewById(R.id.buttonResetPassword);
    }

    private void observeViewModel() {
        viewModel.getResetSuccess().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isSuccessful) {
                if (isSuccessful) {
                    Toast.makeText(
                                    ResetPasswordActivity.this,
                                    R.string.reset_link_sent,
                                    Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
        viewModel.getResetErrorMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String resetErrorMessage) {
                Toast.makeText(
                                ResetPasswordActivity.this,
                                resetErrorMessage,
                                Toast.LENGTH_LONG)
                        .show();
            }
        });
    }

    private void setUpClickListeners() {
        buttonResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = StringUtils.getTrimmedValue(editTextEmail);
                if (!email.equals("")) {
                    viewModel.resetPassword(email);
                }
            }
        });
    }

    public static Intent newIntent(Context context, String email) {
        Intent intent = new Intent(context, ResetPasswordActivity.class);
        intent.putExtra(EXTRA_EMAIL, email);
        return intent;
    }
}
