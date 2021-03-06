package com.smd.foodmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.smd.foodmaster.Classes.NIC;
import com.smd.foodmaster.Database.DBhandler;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private Handler handler;

    TextInputLayout fname,lname,nicNo,addrrs,mail,mobile,uname,pw,loginUsername,loginPassword;

    ImageView loginRegBg;
    Animation logRegBgAnima;
    LinearLayout newMemberLayout, loginComponent,oldMemberLayout,registerComponent,
            firstRegSection,secondRegSection,thirdRegSection;

    Button newMember,login, oldMember, btnNext,btnNext1,btnBack1,btnBack2,btnRegister;

    String firstName,lastName,nic,gender,address,email,mobileNumber,username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        fname = (TextInputLayout)findViewById(R.id.txt_first_name);
        lname = (TextInputLayout)findViewById(R.id.txt_last_name);
        nicNo = (TextInputLayout)findViewById(R.id.txt_nic);
        addrrs = (TextInputLayout)findViewById(R.id.txt_address);
        mail = (TextInputLayout)findViewById(R.id.txt_email_address);
        mobile = (TextInputLayout)findViewById(R.id.txt_mobile);
        uname = (TextInputLayout)findViewById(R.id.txt_username);
        pw = (TextInputLayout)findViewById(R.id.txt_password);

        loginUsername = (TextInputLayout)findViewById(R.id.txt_login_username);
        loginPassword = (TextInputLayout)findViewById(R.id.txt_login_password);

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
                firstName = Objects.requireNonNull(fname.getEditText()).getText().toString();
                lastName = Objects.requireNonNull(lname.getEditText()).getText().toString();
                nic = Objects.requireNonNull(nicNo.getEditText()).getText().toString();
                NIC obj = new NIC(nic);
                gender = obj.GENDER;
                regSection1();
            }
        });
        btnNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                address = Objects.requireNonNull(addrrs.getEditText()).getText().toString();
                email = Objects.requireNonNull(mail.getEditText()).getText().toString();
                mobileNumber = Objects.requireNonNull(mobile.getEditText()).getText().toString();
                regSection2();
            }
        });
        btnBack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sectionBack1();
            }
        });
        btnBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sectionBack2();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                username = Objects.requireNonNull(uname.getEditText()).getText().toString();
                password = Objects.requireNonNull(pw.getEditText()).getText().toString();
                DBhandler dBhandler = new DBhandler(getApplicationContext());
                long id = dBhandler.addUserDetails("USER",firstName,lastName,address,email,mobileNumber,gender,nic,username,password);
                oldMember();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String username = Objects.requireNonNull(loginUsername.getEditText()).getText().toString();
                String password = Objects.requireNonNull(loginPassword.getEditText()).getText().toString();

                DBhandler dBhandler = new DBhandler(getApplicationContext());
                try {
                    String returnValue = dBhandler.readLogin(username,password);
//                    Toast.makeText(getApplicationContext(), " read value "+returnValue, Toast.LENGTH_SHORT).show();
                    if(returnValue!=null){
                        Intent userMain = new Intent(getApplicationContext(), userMainActivity.class);
                        userMain.putExtra(userMainActivity.ROLLID,returnValue);
                        startActivity(userMain);
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), " Error = "+e, Toast.LENGTH_SHORT).show();
                }
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
        thirdRegSection.animate().translationX(0).setDuration(1000).setStartDelay(100);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 100ms
                loginComponent.setVisibility(View.INVISIBLE);
            }
        }, 1300);
    }

    private void regSection1() {
        firstRegSection.animate().translationX(-1500).setDuration(1200).setStartDelay(200);
        secondRegSection.animate().translationX(-840).setDuration(1200).setStartDelay(200);
    }
    private void regSection2() {
        secondRegSection.animate().translationX(-1800).setDuration(1200).setStartDelay(200);
        thirdRegSection.animate().translationX(-1670).setDuration(1200).setStartDelay(200);
    }
    private void sectionBack1() {
        firstRegSection.animate().translationX(0).setDuration(1200).setStartDelay(200);
        secondRegSection.animate().translationX(0).setDuration(1200).setStartDelay(200);
    }
    private void sectionBack2() {
        secondRegSection.animate().translationX(-840).setDuration(1200).setStartDelay(200);
        thirdRegSection.animate().translationX(0).setDuration(1200).setStartDelay(200);
    }

}