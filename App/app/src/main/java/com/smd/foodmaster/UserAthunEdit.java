package com.smd.foodmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class UserAthunEdit extends AppCompatActivity {

    TextInputEditText OLDPASSWORD,USERNAME,NEWPASSWORD,COMFIRMPASSWORD;

    Button SAVEBUTTON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_athun_edit);

        OLDPASSWORD = (TextInputEditText) findViewById(R.id.ol_pass_edit);
        USERNAME = (TextInputEditText) findViewById(R.id.username_edit);
        NEWPASSWORD = (TextInputEditText) findViewById(R.id.new_pass_edit);
        COMFIRMPASSWORD = (TextInputEditText) findViewById(R.id.com_pass_edit);

        SAVEBUTTON = (Button)findViewById(R.id.btn_save);

    }
}