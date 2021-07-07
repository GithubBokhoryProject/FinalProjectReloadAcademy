package com.example.finalprojectreloadacademy.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalprojectreloadacademy.R;

public class LogainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText userName, userPassword;
    AppCompatButton mSignupBtn, mSignInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logain);
        initView();
    }

    private void initView() {
        userName = findViewById(R.id.user_name);
        userPassword = findViewById(R.id.user_pass);
        mSignInBtn = findViewById(R.id.signIn_btn);
        mSignupBtn = findViewById(R.id.signUp_btn);
        mSignInBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signIn_btn:
                // validation
                if (!(userName.getText().toString().equalsIgnoreCase("admin@gmail.com"))) {
                    Toast.makeText(getApplicationContext(), "من فضلك ادخل البريد الالكتروني صحيح", Toast.LENGTH_SHORT).show();
                } else if (!(userPassword.getText().toString().equalsIgnoreCase("123456789"))) {
                    Toast.makeText(getApplicationContext(), "من فضلك ادخل كلمه المرور صحيحه", Toast.LENGTH_SHORT).show();
                } else {
                    // Go To Home Activity
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("username", userName.getText().toString());
                    intent.putExtra("userpass", userPassword.getText().toString());
                    startActivity(intent);
                }
                break;
            case R.id.signUp_btn:
                break;
        }
    }
}