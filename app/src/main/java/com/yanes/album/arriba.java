package com.yanes.album;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class arriba extends Activity {
    private static TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_header_main);

        textView=(TextView) findViewById(R.id.name_header);

    }


   public static void setStringUsername(String user_name){
        Log.i("holeee33"," leee");
       textView.setText("jjjj");

       Log.i("holeee331"," leee");
   }
}
