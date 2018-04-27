package com.yanes.album;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by LidiayClaudia on 28/04/2018.
 */

public class States extends Activity {
    public static String State;

    static final String[] STATES={
            "California(CA)","Florida(FL)","Georgia(GA)","Hawaii(HI)",
            "New York(NY)", "Tennessee(TN)", "Texas(TX)",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.states);

        ListView lv= (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, STATES
        );
        lv.setAdapter(adapter);

    }



}
