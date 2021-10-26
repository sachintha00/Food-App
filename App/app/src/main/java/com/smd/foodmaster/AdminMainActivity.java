package com.smd.foodmaster;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.smd.foodmaster.AdminAdapters.AdminDrawerItem;
import com.smd.foodmaster.AdminClasses.Item;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

public class AdminMainActivity extends AppCompatActivity {

    public static final int POS_CLOSE = 0;
    public static final int POS_DASHBOARD = 0;
    public static final int POS_MY_PROFILE = 0;
    public static final int POS_NEARBY_RES = 0;
    public static final int POS_SETTINGS = 0;
    public static final int POS_ABOUT_US = 0;
    public static final int POS_LOGOUT = 0;

    private String[] screenTitles;
    private Drawable[] screenIcons;

    private SlidingRootNav slidingRootNav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        slidingRootNav = new SlidingRootNavBuilder(this)
                .withDragDistance(180)
                .withRootViewScale(0.75f)
                .withRootViewElevation(25)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withSavedState(savedInstanceState)
                .inject();

        screenIcons = loadScreenIcons();
        screenTitles = loadScreenTitle();
    }

    private AdminDrawerItem createItemFor(int position){
        return new Item(screenIcons[position],screenTitles[position])
                .withNormalIconTint(R.color.colorPrimary)
                .withNoramalTextTint(R.color.colorPrimaryDark)
                .withSelectedIconTint(R.color.colorPrimary)
                .withSelectedTextTint(R.color.colorPrimary);
    }

    @ColorInt
    private int color(@ColorRes int res{
        return ContextCompat.getColor(this,res);
    }

    private Drawable[] loadScreenIcons() {
    }

    private String[] loadScreenTitle() {
    }
}