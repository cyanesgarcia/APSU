package com.yanes.album;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends Activity implements View.OnClickListener{
    private static final int REQUEST_CODE_ADD=100;
    public static String Activity_KEY ="activity";
Toolbar toolbar;
int total =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_main);

        //toolbar=(Toolbar) findViewById(R.id.toolbar);
        setActionBar(toolbar);
        Button album = (Button)findViewById(R.id.album);
        album.setOnClickListener(this);
        Button about_us= (Button) findViewById(R.id.about_us);
        about_us.setOnClickListener(this);
        Button resource= (Button) findViewById(R.id.resources);
        resource.setOnClickListener(this);
        Button game= (Button) findViewById(R.id.game);
        game.setOnClickListener(this);
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
            Intent intent=new Intent(this,Resources.class);
            startActivity(intent);


        }else if(view.getId() == R.id.game){
        Intent intent=new Intent(this,Game.class);
        startActivity(intent);


    }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_ADD) {


            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Cancelled ", Toast.LENGTH_SHORT).show();
                return;
            } else if (resultCode == RESULT_OK) {

                int h = 0;

                String high_score = data.getStringExtra(Activity_KEY);
                Log.i("high score", "high score" + high_score);
                h = Integer.parseInt(high_score);


                if (total< h) {
                    total= h;
                }
                TextView highscore = findViewById(R.id.toolbar);
                highscore.setText("The highest score in the  game is " + total);
            }
        }
    }
}
