package com.yanes.album;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button album = (Button)findViewById(R.id.album);
        album.setOnClickListener(this);
        Button about_us= (Button) findViewById(R.id.about_us);
        about_us.setOnClickListener(this);
        Button resource= (Button) findViewById(R.id.resources);
        resource.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.album){
            Intent intent=new Intent(this,States.class);
            startActivity(intent);

        }else if(view.getId() == R.id.about_us){
            Intent intent=new Intent(this,Aboutus.class);
            startActivity(intent);


        }else if(view.getId() == R.id.resources){

        }

    }
}
