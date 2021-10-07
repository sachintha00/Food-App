package com.smd.foodmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.airbnb.lottie.LottieAnimationView;

public class Intro extends AppCompatActivity {

    ImageView splashBg;
    LottieAnimationView splashLogo;
    LinearLayout sliders;
    ViewPager sliderViewPager;
    SliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        splashBg = (ImageView)findViewById(R.id.splshImg);
        splashLogo = (LottieAnimationView)findViewById(R.id.splashAnim);
        sliders = (LinearLayout)findViewById(R.id.sliderLayout);

        splashBg.animate().translationY(-5600).setDuration(2000).setStartDelay(2500);
        splashLogo.animate().translationY(1500).setDuration(1000).setStartDelay(2700);
        sliders.animate().setStartDelay(2700);

        sliderViewPager = (ViewPager)findViewById(R.id.sliders);
        sliderAdapter = new SliderAdapter(this);
        sliderViewPager.setAdapter(sliderAdapter);
    }
}