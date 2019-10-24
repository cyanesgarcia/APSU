package com.yanes.album;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by claud on 5/12/2018.
 */

public class register_page extends Activity implements View.OnClickListener {
   /// static int entrar=0;

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

        Button button=(Button) findViewById(R.id.bregister);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bregister) {
            String str_name = name.getText().toString();
            String str_surname = surname.getText().toString();
            String str_age = age.getText().toString();
            String str_username = username.getText().toString();
            String str_password = password.getText().toString();

            String type = "register";

            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute(type, str_name, str_surname, str_age, str_username, str_password);
/*
            Intent intent = new Intent(register_page.this, login_page.class);
            startActivity(intent);*/
////////AQUIIIIIIIIIII

        }
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final Context mContext = this;
        // TODO Auto-generated method stub
        // builder.setCancelable(false);
        builder.setTitle("Do you want to quit your registration?");
        builder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                Toast.makeText(mContext, "You exited without any record", Toast.LENGTH_LONG).show();
                finish();
            }
        });
        builder.setNegativeButton("No",new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.cancel();

            }
        });

        AlertDialog alert=builder.create();
        alert.show();
        //super.onBackPressed();
    }
}
