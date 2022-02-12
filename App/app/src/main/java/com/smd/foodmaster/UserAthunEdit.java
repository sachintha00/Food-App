package com.smd.foodmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.smd.foodmaster.Classes.NIC;
import com.smd.foodmaster.Database.DBhandler;

import java.util.List;

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

        DBhandler db = new DBhandler(getApplicationContext());
        List<String> authEdit = db.readUser(userMainActivity.passRollId);

        OLDPASSWORD.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(authEdit.get(8).equals(OLDPASSWORD.getText().toString())){
                    SAVEBUTTON.setEnabled(true);
                }
                else{
                    SAVEBUTTON.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        SAVEBUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(db.updateAuthDetails(userMainActivity.passRollId,USERNAME.getText().toString(),COMFIRMPASSWORD.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}