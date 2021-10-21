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
    LinearLayout newMemberLayout, loginComponent,oldMemberLayout;

    Button newMember,login, oldMember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        newMember = (Button)findViewById(R.id.btn_new_member);
        oldMember = (Button)findViewById(R.id.btn_old_member);
        newMemberLayout = (LinearLayout)findViewById(R.id.layout_new_member);
        oldMemberLayout = (LinearLayout)findViewById(R.id.layout_old_member);
        loginComponent = (LinearLayout)findViewById(R.id.login_component);

        loginRegBg = (ImageView) findViewById(R.id.image_bg_login_reg);

        newMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newMemberLayout.animate().alpha(0).setDuration(1000).setStartDelay(1000);
                loginRegBg.animate().translationY(1570).setDuration(2200).setStartDelay(200);
                oldMemberLayout.setVisibility(View.VISIBLE);
            }
        });
        oldMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newMemberLayout.animate().alpha(1).setDuration(1000).setStartDelay(1000);
                loginRegBg.animate().translationY(-1570).setDuration(2200).setStartDelay(200);
                oldMemberLayout.setVisibility(View.INVISIBLE);
            }
        });
    }
}