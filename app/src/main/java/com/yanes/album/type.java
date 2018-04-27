package com.yanes.album;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by LidiayClaudia on 28/04/2018.
 */

public class type extends Activity {
    public static String Type;
    static final String[] TYPES = {
            "Capital", "Foods & Drinks", "Places",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_t);

        ListView lv = (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, TYPES
        );
        lv.setAdapter(adapter1);
    }
}
