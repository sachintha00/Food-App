package com.smd.foodmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AdminMainActivity extends AppCompatActivity {

    public static final int POS_CLOSE = 0;
    public static final int POS_DASHBOARD = 0;
    public static final int POS_MY_PROFILE = 0;
    public static final int POS_NEARBY_RES = 0;
    public static final int POS_SETTINGS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);

//        setSupportActionBar();
    }
}