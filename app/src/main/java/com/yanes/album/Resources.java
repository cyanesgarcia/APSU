package com.yanes.album;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by LidiayClaudia on 28/04/2018.
 */

public class Resources extends Activity {
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resources);
        TextView te= (TextView)findViewById(R.id.CA);
        String hola= goToUrl("https://matadornetwork.com");
        te.setText(hola);

}public String goToUrl(String st){
        Uri uri= Uri.parse(st);
        Intent intent= new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
        return st;
    }}
