package com.smd.foodmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class LoginActivity extends AppCompatActivity {

    ImageView loginRegBg;
    Animation logRegBgAnima;
    LinearLayout newMemberLayout;

    Button newMember,login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        newMember = (Button)findViewById(R.id.btn_new_member);
        login = (Button)findViewById(R.id.login);
        newMemberLayout = (LinearLayout)findViewById(R.id.layout_new_member);

        loginRegBg = (ImageView) findViewById(R.id.image_bg_login_reg);

        newMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginRegBg.animate().translationY(1570).setDuration(1500).setStartDelay(300);
//                newMemberLayout.setVisibility(View.INVISIBLE);
                newMemberLayout.animate().scaleX(0).setDuration(1000);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                newMemberLayout.setVisibility(View.VISIBLE);
                loginRegBg.animate().translationY(-1570).setDuration(1000).setStartDelay(300);
                newMemberLayout.animate().scaleX(1).setDuration(1000);
            }
        });
    }
}