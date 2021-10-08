package com.smd.foodmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class Intro extends AppCompatActivity {

    ImageView splashBg;
    LottieAnimationView splashLogo;
    LinearLayout sliders, dotLayout;
    ViewPager sliderViewPager;
    SliderAdapter sliderAdapter;

    private TextView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        dotLayout = (LinearLayout) findViewById(R.id.slideDotes);
        splashBg = (ImageView) findViewById(R.id.splshImg);
        splashLogo = (LottieAnimationView) findViewById(R.id.splashAnim);
        sliders = (LinearLayout) findViewById(R.id.sliderLayout);

        splashBg.animate().translationY(-5600).setDuration(2000).setStartDelay(2500);
        splashLogo.animate().translationY(1500).setDuration(1000).setStartDelay(2700);
        sliders.animate().setStartDelay(2700);

        sliderViewPager = (ViewPager) findViewById(R.id.sliders);

        sliderAdapter = new SliderAdapter(this);
        sliderViewPager.setAdapter(sliderAdapter);

        addDotIndecator(0);
        sliderViewPager.addOnPageChangeListener(viewLister);
    }

    public void addDotIndecator(int position) {
        dots = new TextView[3];
        dotLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(45);
            dots[i].setTextColor(getResources().getColor(R.color.colorTransparent));

            dotLayout.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.colorAccent));
        }
    }

    ViewPager.OnPageChangeListener viewLister = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotIndecator(i);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}