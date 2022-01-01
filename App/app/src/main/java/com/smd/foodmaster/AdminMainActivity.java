package com.smd.foodmaster;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.smd.foodmaster.AdminAdapters.AdminDrawerAdapter;
import com.smd.foodmaster.AdminAdapters.AdminDrawerItem;
import com.smd.foodmaster.AdminClasses.Item;
import com.smd.foodmaster.AdminClasses.SpaceItem;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.ArrayList;
import java.util.Arrays;

public class AdminMainActivity extends AppCompatActivity implements AdminDrawerAdapter.OnItemSelectedListener{

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

        AdminDrawerAdapter adminDrawerAdapter = new AdminDrawerAdapter(Arrays.asList(
                createItemFor(POS_CLOSE),
                createItemFor(POS_DASHBOARD).setChecked(true),
                createItemFor(POS_MY_PROFILE),
                createItemFor(POS_NEARBY_RES),
                createItemFor(POS_SETTINGS),
                createItemFor(POS_ABOUT_US),
                new SpaceItem(260),
                createItemFor(POS_LOGOUT)
        ));

        adminDrawerAdapter.setListner(this);

        RecyclerView list = findViewById(R.id.drawer_list);

    }

    private AdminDrawerItem createItemFor(int position){
        return new Item(screenIcons[position],screenTitles[position])
                .withNormalIconTint(R.color.colorPrimary)
                .withNoramalTextTint(R.color.colorPrimaryDark)
                .withSelectedIconTint(R.color.colorPrimary)
                .withSelectedTextTint(R.color.colorPrimary);
    }

    @ColorInt
    private int color(@ColorRes int res){
        return ContextCompat.getColor(this,res);
        }

    private Drawable[] loadScreenIcons() {
    }

    private String[] loadScreenTitle() {
        return getResources().getStringArray(R.array.id_activityScreenTitles);
    }

    @Override
    public void onItemSelected(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if(position == POS_DASHBOARD){
            AdminDashBoardFragment dashBoardFragment = new AdminDashBoardFragment();
            transaction.replace(R.id.container,dashBoardFragment);
        }
    }
}