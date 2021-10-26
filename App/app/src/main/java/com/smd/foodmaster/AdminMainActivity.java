package com.smd.foodmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

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
    private String[] screenIcons;

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

    private String[] loadScreenTitle() {
    }
}