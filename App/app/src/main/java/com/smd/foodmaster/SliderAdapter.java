package com.smd.foodmaster;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
        return main_topic.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container,false);

        ImageView splashImage = (ImageView) view.findViewById(R.id.splashImg);
        TextView mainTopic = (TextView) view.findViewById(R.id.topic1);
        TextView subTopic = (TextView) view.findViewById(R.id.topic2);
        TextView description = (TextView) view.findViewById(R.id.descript);

        splashImage.setImageResource(slide_images[position]);
        mainTopic.setText(main_topic[position]);
        subTopic.setText(sub_topic[position]);
        description.setText(splash_description[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }
}
