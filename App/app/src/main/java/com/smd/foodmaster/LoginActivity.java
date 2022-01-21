package com.smd.foodmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Handler handler;

    ImageView loginRegBg;
    Animation logRegBgAnima;
    LinearLayout newMemberLayout, loginComponent,oldMemberLayout,registerComponent,
            firstRegSection,secondRegSection,thirdRegSection;

    Button newMember,login, oldMember, btnNext,btnNext1,btnBack1,btnBack2,btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        handler = new Handler(Looper.getMainLooper());

        newMember = (Button)findViewById(R.id.btn_new_member);
        oldMember = (Button)findViewById(R.id.btn_old_member);
        btnNext = (Button)findViewById(R.id.btn_next);
        btnNext1 = (Button)findViewById(R.id.btn_next1);
        btnBack1 = (Button)findViewById(R.id.btn_back1);
        btnBack2 = (Button)findViewById(R.id.btn_back2);
        btnRegister = (Button)findViewById(R.id.btn_register);
        login = (Button)findViewById(R.id.login);

        newMemberLayout = (LinearLayout)findViewById(R.id.layout_new_member);
        oldMemberLayout = (LinearLayout)findViewById(R.id.layout_old_member);
        loginComponent = (LinearLayout)findViewById(R.id.login_component);
        registerComponent = (LinearLayout)findViewById(R.id.register_component);
        firstRegSection = (LinearLayout)findViewById(R.id.first_reg_section);
        secondRegSection = (LinearLayout)findViewById(R.id.second_reg_section);
        thirdRegSection = (LinearLayout)findViewById(R.id.third_reg_section);

        loginRegBg = (ImageView) findViewById(R.id.image_bg_login_reg);

        newMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newMember();
            }
        });
        oldMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oldMember();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regSection1();
            }
        });
        btnNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regSection2();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent adminMain = new Intent(getApplicationContext(), AdminMainActivity.class);
//                startActivity(adminMain);
                Toast toast = Toast.makeText(getApplicationContext(),"click login",Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    private void oldMember() {
        newMemberLayout.animate().alpha(1).setDuration(1000).setStartDelay(1000);
        oldMemberLayout.animate().alpha(0).setDuration(1000).setStartDelay(1000);
        loginRegBg.animate().translationY(-1570).setDuration(2200).setStartDelay(200);
        loginComponent.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(1300);
        registerComponent.animate().translationY(0).alpha(0).setDuration(800).setStartDelay(800);
        loginComponent.setVisibility(View.VISIBLE);
    }

    private void newMember() {
        newMemberLayout.animate().alpha(0).setDuration(1000).setStartDelay(1000);
        oldMemberLayout.animate().alpha(1).setDuration(1000).setStartDelay(1000);
        loginRegBg.animate().translationY(1570).setDuration(2200).setStartDelay(200);
        loginComponent.animate().translationY(-270).alpha(0).setDuration(800).setStartDelay(800);
        registerComponent.animate().translationY(-180).alpha(1).setDuration(800).setStartDelay(1300);
        firstRegSection.animate().translationX(0).setDuration(2200).setStartDelay(200);
        secondRegSection.animate().translationX(0).setDuration(1000).setStartDelay(100);
//        thirdRegSection.animate().translationX(0).setDuration(1000).setStartDelay(100);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 100ms
                loginComponent.setVisibility(View.INVISIBLE);
            }
        }, 1300);
    }

    private void regSection1() {
        firstRegSection.animate().translationX(-1500).setDuration(2200).setStartDelay(200);
        secondRegSection.animate().translationX(-840).setDuration(2200).setStartDelay(200);
    }
    private void regSection2() {
        secondRegSection.animate().translationX(-1800).setDuration(2200).setStartDelay(200);
        thirdRegSection.animate().translationX(-1670).setDuration(2200).setStartDelay(200);
    }

}