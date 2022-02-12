package com.smd.foodmaster;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.blogspot.atifsoftwares.circularimageview.CircularImageView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.smd.foodmaster.Classes.NIC;
import com.smd.foodmaster.Database.DBhandler;
import com.smd.foodmaster.ui.slideshow.SlideshowFragment;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.List;

public class UserPrivacyEdit extends AppCompatActivity {

    TextInputEditText NIC,GENDER,FIRSTNAME,LASTNAME,ADDRESS,MAIL, MOBILENUMBER;

    Button SAVEBUTTON;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_privacy_edit);

        NIC = (TextInputEditText) findViewById(R.id.nic_edit);
        GENDER = (TextInputEditText) findViewById(R.id.gender_edit);
        FIRSTNAME = (TextInputEditText) findViewById(R.id.firstname_edit);
        LASTNAME = (TextInputEditText) findViewById(R.id.lastname_edit);
        ADDRESS = (TextInputEditText) findViewById(R.id.address_edit);
        MAIL = (TextInputEditText) findViewById(R.id.email_edit);
        MOBILENUMBER = (TextInputEditText) findViewById(R.id.edit_mobile_number);

        SAVEBUTTON = (Button)findViewById(R.id.btn_save);

        DBhandler db = new DBhandler(getApplicationContext());
        List<String> userEdit = db.readUser(userMainActivity.passRollId);

        FIRSTNAME.setText(userEdit.get(0));
        LASTNAME.setText(userEdit.get(1));
        ADDRESS.setText(userEdit.get(2));
        MAIL.setText(userEdit.get(3));
        MOBILENUMBER.setText(userEdit.get(4));
        GENDER.setText(userEdit.get(5));
        NIC.setText(userEdit.get(6));

        NIC.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                NIC obj = new NIC(NIC.getText().toString());
                GENDER.setText(obj.GENDER);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        SAVEBUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (db.updateUserDetails(userMainActivity.passRollId,FIRSTNAME.getText().toString(),LASTNAME.getText().toString(),
                        ADDRESS.getText().toString(),MAIL.getText().toString(),MOBILENUMBER.getText().toString(),GENDER.getText().toString(),
                        NIC.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}