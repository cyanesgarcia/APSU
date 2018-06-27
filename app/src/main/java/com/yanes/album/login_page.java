package com.yanes.album;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
        Button button=(Button) findViewById(R.id.btnRegister);
        button.setOnClickListener(this);
        Log.i("eeeee1","e");
    }

    public void OnLogin(View view) {
        username = UsernameEt.getText().toString();
        String password = PasswordEt.getText().toString();
        String type = "login";
        Log.i("eeeee2","e");
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, username, password);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnRegister) {
            Log.i("eeeee3","e");
            Intent intent = new Intent(this, register_page.class);
            startActivity(intent);
        }
    }
}