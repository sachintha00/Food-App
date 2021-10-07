package com.smd.foodmaster;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    public int[] slide_images={
            R.drawable.splash_image1,
            R.drawable.splash_image2,
            R.drawable.splash_image3
    };

    public String[] main_topic = {
            "Fresh",
            "Home",
            "Easy"
    };
    public String[] sub_topic = {
            "Everything",
            "Delivery",
            "Payment"
    };
    public String[] splash_description = {
            "Lorem ipsum dolor sit amet, consetetur \\nsadipscing elitr, sed diam nonumy \\neirmod tempor invidunt ut labore et \\ndolore magna aliquyam erat, sed diam \\nvoluptua. At vero eos et accusam et",
            "Lorem ipsum dolor sit amet, consetetur \\nsadipscing elitr, sed diam nonumy \\neirmod tempor invidunt ut labore et \\ndolore magna aliquyam erat, sed diam \\nvoluptua. At vero eos et accusam et",
            "Lorem ipsum dolor sit amet, consetetur \\nsadipscing elitr, sed diam nonumy \\neirmod tempor invidunt ut labore et \\ndolore magna aliquyam erat, sed diam \\nvoluptua. At vero eos et accusam et"
    };

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }
}
