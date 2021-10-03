package com.smd.foodmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class Intro extends AppCompatActivity {

    ImageView splashBg;
    LottieAnimationView splashLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        splashBg = (ImageView)findViewById(R.id.splshImg);
        splashLogo = (LottieAnimationView)findViewById(R.id.splashAnim);

        splashBg.animate().translationY(-5600).setDuration(3000).setStartDelay(4000);
    }
}