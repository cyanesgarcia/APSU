package com.yanes.album;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by claud on 6/9/2018.
 */

public class login_page extends Activity implements View.OnClickListener{
   static String check="No";
    EditText UsernameEt, PasswordEt;
    public static Activity a;
    static String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        a= this;
        UsernameEt = (EditText)findViewById(R.id.etUserName);
        PasswordEt = (EditText)findViewById(R.id.etPassword);
        TextView button=(TextView) findViewById(R.id.btnRegister);
        button.setOnClickListener(this);
        Button button1 = (Button) findViewById(R.id.btnLogin);
        button1.setOnClickListener(this);
        Log.i("eeeee1","e");
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnRegister) {
            Log.i("eeeee3","e");
            Intent intent = new Intent(this, register_page.class);
            startActivity(intent);
        }else if(view.getId()==R.id.btnLogin){
            username = UsernameEt.getText().toString();
            String password = PasswordEt.getText().toString();
            String type = "login";
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute(type, username, password);
        }
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final Context mContext = this;
        // TODO Auto-generated method stub
        builder.setTitle("Do you want to exit?");
        builder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
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
