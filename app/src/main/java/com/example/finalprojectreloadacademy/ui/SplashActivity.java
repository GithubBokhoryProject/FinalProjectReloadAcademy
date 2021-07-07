package com.example.finalprojectreloadacademy.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.finalprojectreloadacademy.R;

public class SplashActivity extends AppCompatActivity {
    ImageView MLogoIV;
    Animation manim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        MLogoIV=findViewById(R.id.logo_id);
        manim= AnimationUtils.loadAnimation(this,R.anim.logo_anim);
        manim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                splashTimer();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        MLogoIV.setAnimation(manim);
    }
    private void splashTimer(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this, LogainActivity.class);
                startActivity(intent);
            }
        },1000);
    }
}