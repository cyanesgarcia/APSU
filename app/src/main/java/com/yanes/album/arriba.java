package com.yanes.album;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class arriba extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_header_main);

         }
   public void setUsername(String user_name){
        Log.i("holeee"," leee");
       TextView textView1=(TextView) findViewById(R.id.name_header);
       textView1.setText(user_name);

   }
}
