package com.yanes.album;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by claud on 5/12/2018.
 */

public class register_page extends Activity {
    EditText name, surname, age, username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = (EditText)findViewById(R.id.etname);
        surname = (EditText)findViewById(R.id.etsurname);
        age = (EditText)findViewById(R.id.etage);
        username = (EditText)findViewById(R.id.etusernameR);
        password = (EditText)findViewById(R.id.etpasswordR);
    }

    public void OnReg(View view){
        String str_name = name.getText().toString();
        String str_surname = surname.getText().toString();
        String str_age = age.getText().toString();
        String str_username = username.getText().toString();
        String str_password = password.getText().toString();

        String type = "register";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, str_name, str_surname, str_age, str_username,str_password);


    }
}
