package com.smd.foodmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    ImageView loginRegBg;
    Animation logRegBgAnima;
    LinearLayout newMemberLayout, loginComponent,oldMemberLayout,registerComponent,firstRegSection;

    Button newMember,login, oldMember, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        newMember = (Button)findViewById(R.id.btn_new_member);
        oldMember = (Button)findViewById(R.id.btn_old_member);
        btnNext = (Button)findViewById(R.id.btn_next);
        login = (Button)findViewById(R.id.login);

        newMemberLayout = (LinearLayout)findViewById(R.id.layout_new_member);
        oldMemberLayout = (LinearLayout)findViewById(R.id.layout_old_member);
        loginComponent = (LinearLayout)findViewById(R.id.login_component);
        registerComponent = (LinearLayout)findViewById(R.id.register_component);
        firstRegSection = (LinearLayout)findViewById(R.id.first_reg_section);

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
                Toast toast = Toast.makeText(getApplicationContext(),"sachinthaa",Toast.LENGTH_LONG);
                toast.show();
            }
        });
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent adminMain = new Intent(getApplicationContext(), AdminMainActivity.class);
//                startActivity(adminMain);
//            }
//        });
    }

    private void oldMember() {
        newMemberLayout.animate().alpha(1).setDuration(1000).setStartDelay(1000);
        oldMemberLayout.animate().alpha(0).setDuration(1000).setStartDelay(1000);
        loginRegBg.animate().translationY(-1570).setDuration(2200).setStartDelay(200);
        loginComponent.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(1300);
        registerComponent.animate().translationY(0).alpha(0).setDuration(800).setStartDelay(800);
    }

    private void newMember() {
        newMemberLayout.animate().alpha(0).setDuration(1000).setStartDelay(1000);
        oldMemberLayout.animate().alpha(1).setDuration(1000).setStartDelay(1000);
        loginRegBg.animate().translationY(1570).setDuration(2200).setStartDelay(200);
        loginComponent.animate().translationY(-270).alpha(0).setDuration(800).setStartDelay(800);
        registerComponent.animate().translationY(-180).alpha(1).setDuration(800).setStartDelay(1300);
    }

    private void regFirstSection() {
//        firstRegSection.animate().alpha(0).setDuration(1000).setStartDelay(1000);
//        oldMemberLayout.animate().alpha(1).setDuration(1000).setStartDelay(1000);
//        firstRegSection.animate().translationX(150).setDuration(2200).setStartDelay(200);
//        loginComponent.animate().translationY(-270).alpha(0).setDuration(800).setStartDelay(800);
//        registerComponent.animate().translationY(-180).alpha(1).setDuration(800).setStartDelay(1300);
        Toast toast = Toast.makeText(getApplicationContext(),"sachinthaa",Toast.LENGTH_LONG);
        toast.show();
    }
}